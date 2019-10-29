package com.ptit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.customer.Customer;
import com.ptit.customer.RoomType;
import com.ptit.outcome.SpendingRequest;
import com.ptit.service.RoomService;
import com.ptit.service.UserService;
import com.ptit.staff.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	private void addUserInModel(ModelAndView mav) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
		mav.addObject("user", user);
	}
	
	@GetMapping(path = "/user/financial_and_accounting/home")
	public ModelAndView accountingHome() {
		return new ModelAndView("user/financial_and_accounting/home");
	}
	
	@GetMapping(path = "/user/human_resources/home")
	public ModelAndView hrHome() {
		return new ModelAndView("user/human_resources/home");
	}

	@GetMapping(path = "/user/maintenance_and_security/home")
	public ModelAndView msHome() {
		return new ModelAndView("user/maintenance_and_security/home");
	}
	
	@GetMapping(path = "/user/sale_and_marketing/home")
	public ModelAndView marketingHome() {
		return new ModelAndView("user/sale_and_marketing/home");
	}
	
	@GetMapping(path = "/user/room_division/home")
	public ModelAndView roomDivisionHome() {
		return new ModelAndView("user/room_division/home");
	}
	
	@GetMapping(path = "/user/services/home")
	public ModelAndView servicesHome() {
		return new ModelAndView("user/services/home");
	}
	
	@RequestMapping(value = "/user/room_division/room_reservation", method = RequestMethod.GET)
	public ModelAndView roomReservation() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<RoomType> roomTypes = roomService.findAllRoomType();
		modelAndView.addObject("roomTypes", roomTypes);
		modelAndView.setViewName("user/room_division/room_reservation");
		return modelAndView;
	}

	@RequestMapping(value = "/user/room_division/guest_record", method = RequestMethod.GET)
	public ModelAndView guestRecord() {
		ModelAndView modelAndView = new ModelAndView();
		List<Customer> customer = roomService.findAllCustomer();
		modelAndView.addObject("customers",customer);
		addUserInModel(modelAndView);
		modelAndView.setViewName("user/room_division/guest_record");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/financial_and_accounting/request_handle", method = RequestMethod.GET)
	public ModelAndView requestHandle() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("user/financial_and_accounting/request_handle");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/common/request_form", method = RequestMethod.GET)
	public ModelAndView requestForm() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		SpendingRequest request = new SpendingRequest();
		modelAndView.addObject("request", request);
		modelAndView.setViewName("user/common/request_form");
		return modelAndView;
	}
}
