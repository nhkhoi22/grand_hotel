package com.ptit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.customer.Customer;
import com.ptit.customer.RoomType;
import com.ptit.dao.SqlDAO;
import com.ptit.outcome.SpendingRequest;
import com.ptit.product.InProduct;
import com.ptit.service.ProductService;
import com.ptit.service.RoomService;
import com.ptit.service.UserService;
import com.ptit.staff.Department;
import com.ptit.staff.Position;
import com.ptit.staff.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private SqlDAO sqlDao;
	
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
		List<InProduct> products = service.findAllInProduct();
		SpendingRequest request = new SpendingRequest();
		modelAndView.addObject("request", request);
		modelAndView.addObject("products", products);
		modelAndView.setViewName("user/common/request_form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/common/request_form", method = RequestMethod.POST)
	public ModelAndView sendRequestForm(@RequestParam Map<String, String> reqPar) {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("user/common/request_form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/sale_and_marketing/out_product", method = RequestMethod.GET)
	public ModelAndView outProducts() {
		String sqlEditor = "select op.out_product_name as 'Product Name', ph.price as 'price', ph.start_date as 'Start date' from out_product op\r\n" + 
				"inner join product_price_history ph on (ph.out_product_id = op.out_product_id)\r\n" + 
				"where (ph.start_date <= now() and (ph.end_date <= now()))";
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
		results = sqlDao.queryForList(sqlEditor);
		Set<String> keys = results.get(0).keySet();
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("products", results);
		modelAndView.setViewName("user/sale_and_marketing/out_product");
		return modelAndView;
	}
	@RequestMapping(value = "/user/financial_and_accounting/financial_statement", method = RequestMethod.GET)
	public ModelAndView staffSalary() {
		String sqlEditor = "select u.staff_id as 'ID', u.full_name as 'Full Name',pos.position_name as 'Position', u.days_in_work as 'Days in Work', u.days_in_work * u.contract_salary * pos.salary_level as 'Salary' from user u \r\n" + 
				"inner join position pos on (u.position_id = pos.position_id);";
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
		results = sqlDao.queryForList(sqlEditor);
		Set<String> keys = results.get(0).keySet();
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("products", results);
		List<Position> positions = userService.findAllPosition();
		modelAndView.addObject("positions", positions);
		List<Department> departments = userService.findAllDepartment();
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("user/financial_and_accounting/financial_statement");
		return modelAndView;
	}
}
