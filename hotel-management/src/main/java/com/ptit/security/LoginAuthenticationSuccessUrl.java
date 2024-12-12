package com.ptit.security;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ptit.service.UserService;
import com.ptit.staff.Position;
import com.ptit.staff.User;

public class LoginAuthenticationSuccessUrl implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	private String password = "";
	protected final Log logger = LogFactory.getLog(this.getClass());

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public LoginAuthenticationSuccessUrl() {
		super();
	}

	// API

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) throws IOException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	// IMPL

	protected void handle(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) throws IOException {
		final String targetUrl = determineTargetUrl(authentication);

		checkIn();

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	@SuppressWarnings("deprecation")
	public void checkIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
		password = user.getPassword();
		Date date = Calendar.getInstance().getTime();

		Date userLastLogin = user.getLastlogin();
		Date lastDate = new Date();
		boolean sameDay = true;

		if (userLastLogin != null) {
			sameDay = (date.getYear() == lastDate.getYear()) && (date.getDate() == lastDate.getDate())
					&& (date.getMonth() == lastDate.getMonth());
		} else {
			sameDay = false;
		}

		if (!sameDay) {
			int daysInWork = user.getDaysInWork();
			System.out.println(daysInWork);
			daysInWork++;
			user.setDaysInWork(daysInWork);
		}

		user.setLastLogin(date);
		userService.saveUserNonEncrypt(user);
	}

	protected String determineTargetUrl(final Authentication authentication) {
		boolean isUser = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("USER")) {
				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
				isAdmin = true;
				break;
			}
		}
		User user = userService.findUserByStaffCode(authentication.getName());
		Position position = userService.findPositionById(user.getPosition().getId());
		String department = position.getDepartment().getName();
		if (isUser) {
			return "/user/"+ department.toLowerCase() + "/home";
		} else if (isAdmin) {
			return "/admin/home";
		} else {
			throw new IllegalStateException();
		}
	}

	/**
	 * Removes temporary authentication-related data which may have been stored in
	 * the session during the authentication process.
	 */
	protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
		final HttpSession session = request.getSession(false);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
		user.setPassword(password);
		userService.saveUserNonEncrypt(user);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
