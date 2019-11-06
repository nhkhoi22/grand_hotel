package com.ptit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.customer.Customer;
import com.ptit.customer.RoomType;
import com.ptit.dao.PriceRecordDAO;
import com.ptit.dao.SqlDAO;
import com.ptit.outcome.SpendingRequest;
import com.ptit.product.InProduct;
import com.ptit.product.PriceHistory;
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

	@Autowired
	private PriceRecordDAO recordDao;

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
		modelAndView.addObject("customers", customer);
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
		String sqlEditor = "select op.out_product_id, op.out_product_name as 'Product Name', ph.price as 'price', ph.start_date as 'Start date' from out_product op\r\n"
				+ "inner join product_price_history ph on (ph.out_product_id = op.out_product_id)\r\n"
				+ "where (ph.start_date <= now() and (ph.end_date <= now()))";
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		results = sqlDao.queryForList(sqlEditor);
		Set<String> keys = results.get(0).keySet();
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("products", results);
		modelAndView.setViewName("user/sale_and_marketing/out_product");
		return modelAndView;
	}

	@RequestMapping(value = "/user/financial_and_accounting/financial_statement", method = RequestMethod.GET)
	public ModelAndView staffSalary() {
		String sqlEditor = "select u.staff_id as 'ID', u.full_name as 'Full Name', d.department_name as 'Department', pos.position_name as 'Position', u.days_in_work as 'Days in Work', u.days_in_work * u.contract_salary * pos.salary_level as 'Salary (đ)' from user u \r\n"
				+ "inner join position pos on (u.position_id = pos.position_id) inner join department d on (pos.department_id = d.department_id) ORDER BY u.staff_id;";
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
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

	@RequestMapping(value = { "/user/sale_and_marketing/product_price/{id}",
			"/user/sale_and_marketing/product_price" }, method = RequestMethod.GET)
	public ModelAndView outProductDetail(@PathVariable("id") Integer id) {
		String sqlEditor = "select op.out_product_name as 'Product Name', ph.start_date as 'Start Date', ph.end_date as 'End Date', ph.price as 'Price' from product_price_history ph "
				+ "inner join out_product op on (op.out_product_id = ph.out_product_id)" + "where ph.out_product_id = "
				+ id;
		String sql = "select op.out_product_name as 'Product Name', ph.start_date as 'Start Date', ph.end_date as 'End Date', ph.price as 'Price' from product_price_history ph "
				+ "inner join out_product op on (op.out_product_id = ph.out_product_id)" + "where ph.out_product_id = "
				+ id + " and (start_date <= now() and (end_date >= now() or end_date is null))";
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> currentPrice = new ArrayList<Map<String, Object>>();
		results = sqlDao.queryForList(sqlEditor);
		currentPrice = sqlDao.queryForList(sql);
		Set<String> keys = results.get(0).keySet();
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("records", results);
		modelAndView.addObject("productId", id);
		modelAndView.addObject("currentPrice", currentPrice);
		modelAndView.setViewName("user/sale_and_marketing/product_price");
		return modelAndView;
	}

	@RequestMapping(value = "/user/sale_and_marketing/product_price/{id}", method = RequestMethod.POST)
	public ModelAndView newHistory(@RequestParam(name = "price") String price, @PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		String sqlEditor = "update product_price_history set end_date = now() where out_product_id = " + id
				+ " and start_date <= now() and (end_date >= now() or end_date is NULL)";
		if (sqlDao.insert(sqlEditor)) {
			modelAndView.addObject("isValid", 1);
		} else {
			modelAndView.addObject("isValid", 0);
		}
		PriceHistory history = new PriceHistory();
		history.setPrice(Double.parseDouble(price));
		history.setStartDate(new Date());
		if (service.findOutProductById(id) != null) {
			history.setService(service.findOutProductById(id));
		}
		recordDao.save(history);
		modelAndView.setViewName("user/sale_and_marketing/product_price");
		return modelAndView;
	}

	@GetMapping("/user/room_division/checkout_handle")
	public ModelAndView checkout() {
		ModelAndView modelAndView = new ModelAndView("user/room_division/checkout_handle");
		addUserInModel(modelAndView);
		return modelAndView;
	}

	@PostMapping("/user/room_division/checkout_handle")
	public ModelAndView getAllBill(@RequestParam(name = "roomNum") String roomNum) {
		ModelAndView modelAndView = new ModelAndView("user/room_division/checkout_handle");
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> reservation = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> billTotal = new ArrayList<Map<String, Object>>();
		String roomCheckOut = "select rr.reservation_id, c.full_name, c.phone_number from room_reservation rr\r\n"
				+ "inner join room r on (r.room_id = rr.room_id)\r\n"
				+ "inner join bill b on (b.reservation_id = rr.reservation_id)\r\n"
				+ "inner join customer c on (c.customer_id = b.bill_id)\r\n"
				+ "where rr.check_in_date <= now() and rr.check_out_date >= now() and r.room_id = " + roomNum;
		reservation = sqlDao.queryForList(roomCheckOut);
		String sql = "";
		if(!reservation.isEmpty()) {
			sql = "select bill_total.bill_id as 'Bill Identifier', bill_total.price as 'Bill Price', sum(bill_total.price) as 'Total Fee' from (\r\n"
					+ "select rr.reservation_id as reservation_id, b.bill_id as bill_id, sum(ph.price * bd.quantity) as price from bill b inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n"
					+ "inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n"
					+ "inner join out_product op on (bd.service_id = op.out_product_id) inner join product_price_history ph on ((ph.start_date <= b.payment_time) and (ph.end_date >= b.payment_time) and (ph.out_product_id = bd.service_id))\r\n"
					+ "where rr.reservation_id = " + reservation.get(0).get("reservation_id")
					+ " group by bd.bill_id) as bill_total";
		}
		String getTotalBill = "select sum(bill_total.price) as 'total fee' from (\r\n"
				+ "select rr.reservation_id as reservation_id, b.bill_id as 'bill identifier', sum(ph.price * bd.quantity) as price from bill b inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n"
				+ "inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n"
				+ "inner join out_product op on (bd.service_id = op.out_product_id) inner join product_price_history ph on ((ph.start_date <= b.payment_time) and (ph.end_date >= b.payment_time) and (ph.out_product_id = bd.service_id))\r\n"
				+ "group by bd.bill_id	) as bill_total where bill_total.reservation_id = " + roomNum
				+ " group by bill_total.reservation_id";
		if(sql != "" ) {
			results = sqlDao.queryForList(sql);
		}
		billTotal = sqlDao.queryForList(getTotalBill);
		Set<String> keys = null;
		Set<String> ri = null;
		if (!billTotal.isEmpty()) {
			keys = reservation.get(0).keySet();
		}
		if (!reservation.isEmpty()) {
			ri = reservation.get(0).keySet();
		}
		modelAndView.addObject("reservationId", reservation);
		modelAndView.addObject("bills", results);
		modelAndView.addObject("totalFee", billTotal);
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("rikeys", ri);
		return modelAndView;
	}
}
