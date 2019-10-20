package com.ptit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.service.UserService;
import com.ptit.staff.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private void addUserInModel(ModelAndView mav) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
		mav.addObject("user", user);
	}
	
	@GetMapping(path = "/user/accounting/home")
	public ModelAndView accountingHome() {
		return new ModelAndView("user/accounting/home");
	}
	
	@GetMapping(path = "/user/human_resources/home")
	public ModelAndView hrHome() {
		return new ModelAndView("user/human_resources/home");
	}

	@GetMapping(path = "/user/marketing/home")
	public ModelAndView marketingHome() {
		return new ModelAndView("user/marketing/home");
	}
	
	@GetMapping(path = "/user/room_management/home")
	public ModelAndView roomManagementHome() {
		return new ModelAndView("user/room_management/home");
	}
	
	@GetMapping(path = "/user/services/home")
	public ModelAndView servicesHome() {
		return new ModelAndView("user/services/home");
	}
	
	@RequestMapping(value = "/user/room_management/room_reservation", method = RequestMethod.GET)
	public ModelAndView roomReservation() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("user/room_management/room_reservation");
		return modelAndView;
	}
}
