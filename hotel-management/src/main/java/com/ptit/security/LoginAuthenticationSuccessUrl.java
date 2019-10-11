package com.ptit.security;

import java.io.IOException;
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

import com.ptit.common.DateUtil;
import com.ptit.service.UserService;
import com.ptit.staff.User;

public class LoginAuthenticationSuccessUrl implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserService userService;
	
    protected final Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public LoginAuthenticationSuccessUrl() {
        super();
    }

    // API

    @SuppressWarnings("deprecation")
	@Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
//        User user = userService.findUserByStaffCode(SecurityContextHolder.getContext().getAuthentication().getName());
//        Date date = new Date();
//        DateUtil dateUtil = new DateUtil();
//        
//        String userLastLogin = user.getLastlogin();
//        Date lastDate = new Date();
//        boolean sameDay = true;
//        
//        if(userLastLogin != null && userLastLogin != "") {
//        	lastDate = dateUtil.convertStringToDate(userLastLogin);
//        	sameDay = (date.getYear() == lastDate.getYear()) && (date.getDate() == date.getDate())
//            		&& (date.getMonth() == date.getMonth()) ;
//        }
//        else {
//			sameDay = false;
//        }
//        
//        if(!sameDay) {
//        	int daysInWork = user.getDaysInWork();
//        	System.out.println(daysInWork);
//        	daysInWork++;
//        	user.setDaysInWork(daysInWork);
//        }
//        
//        user.setLastlogin(dateUtil.convertDateToString(date));
//        userService.saveUser(user);
    }

    // IMPL

    protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        final String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
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

        if (isUser) {
            return "/user/home.html";
        } else if (isAdmin) {
            return "/admin/home.html";
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Removes temporary authentication-related data which may have been stored in the session
     * during the authentication process.
     */
    protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);

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
