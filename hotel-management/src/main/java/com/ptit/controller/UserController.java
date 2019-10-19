package com.ptit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserController {

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
	
}
