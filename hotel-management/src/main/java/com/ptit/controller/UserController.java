package com.ptit.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import com.ptit.customer.Room;
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

	private Set<BigDecimal> price;

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
				+ "where (ph.start_date <= now() and (ph.end_date >= now()))";
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
	public void newHistory(@RequestParam(name = "price") String price, @PathVariable("id") Integer id) {
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
		outProductDetail(id);
	}

	@GetMapping("/user/room_division/checkout_handle")
	public ModelAndView checkout() {
		ModelAndView modelAndView = new ModelAndView("user/room_division/checkout_handle");
		List<Room> rooms = roomService.findAllRoom();
		modelAndView.addObject("rooms", rooms);
		addUserInModel(modelAndView);
		return modelAndView;
	}
	
	@PostMapping("/user/room_division/checkout_handle")
	public ModelAndView checkout(@RequestParam String roomNum) {
		return checkLastestRecord(roomNum).addObject("roomNum", roomNum);
	}

	@PostMapping("/user/room_division/checkout_handle/{roomNum}")
	public ModelAndView getAllBill(@PathVariable(name = "roomNum") String roomNum, @RequestParam Map<String, String> reqPar) {
		ModelAndView modelAndView = new ModelAndView("user/room_division/checkout_handle");
		if(roomNum != reqPar.get("roomNum")) {
			roomNum = reqPar.get("roomNum");
			return checkLastestRecord(roomNum);
		}
		modelAndView.addObject("roomNum", roomNum);
		addUserInModel(modelAndView);
		Date checkOutDate = new Date();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> reservation = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> billTotal = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> roomPrice = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> billDetails = new ArrayList<Map<String, Object>>();
		String roomCheckOut = "select rr.reservation_id, c.full_name, c.phone_number from room_reservation rr\r\n"
				+ "inner join room r on (r.room_id = rr.room_id)\r\n"
				+ "inner join bill b on (b.reservation_id = rr.reservation_id)\r\n"
				+ "inner join customer c on (c.customer_id = b.bill_id)\r\n"
				+ "where rr.check_in_date <= now() and r.room_id = " + roomNum 
				+ " order by rr.check_out_date desc limit 1";
		reservation = sqlDao.queryForList(roomCheckOut);
		String getEachBillTotalFee = "";
		String updateCheckOutTime = "";
		String rPrice = "";
		List<Room> rooms = roomService.findAllRoom();
		String updateBillTime = "";
		String getBillDetails = "";
		if(!reservation.isEmpty()) {
			updateCheckOutTime = "update room_reservation rr set rr.check_out_date = now() where rr.reservation_id = " + reservation.get(0).get("reservation_id");
			getEachBillTotalFee = "select b.bill_id as 'bill identifier', sum(ph.price * bd.quantity) as 'Price' from bill b \r\n" + 
					"inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n" + 
					"inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n" + 
					"inner join product_price_history ph on ((ph.start_date < now())and (ph.end_date is null or ph.end_date > now()) and ph.out_product_id = bd.service_id)\r\n" + 
					"where rr.reservation_id =" + reservation.get(0).get("reservation_id") + "\r\n" + 
					"group by b.bill_id";
			rPrice = "select rr.reservation_id as 'Reservation ID', c.full_name as 'Full Name', r.room_id as 'Room ID', rr.check_in_date as 'Check-in Time',"
					+ " rr.check_out_date as 'Check-out Time', rt.price * datediff(rr.check_out_date, rr.check_in_date) as 'Room Price' from room_type rt \r\n" + 
					"inner join room r on (rt.room_type_id = r.room_type)\r\n" + 
					"inner join room_reservation rr on (rr.room_id = r.room_id)\r\n" + 
					"inner join bill b on (b.reservation_id = rr.reservation_id)\r\n" + 
					"inner join customer c on (c.customer_id = b.bill_id)\r\n" + 
					"where rr.check_in_date <= now() and rr.check_out_date >= now() and rr.reservation_id =" + reservation.get(0).get("reservation_id");
			updateBillTime = "update bill bb set bb.payment_time = now() where bb.reservation_id = " + reservation.get(0).get("reservation_id");
			getBillDetails = "select op.out_product_name, bd.quantity as 'Quantity', sum(ph.price * bd.quantity) as 'Total', b.bill_id as 'bill identifier'from bill b \r\n" + 
					"inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n" + 
					"inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n" + 
					"inner join out_product op on (op.out_product_id = bd.service_id) "+
					"inner join product_price_history ph on ((ph.start_date < now())and (ph.end_date is null or ph.end_date > now()) and ph.out_product_id = bd.service_id)\r\n" + 
					"where b.reservation_id = " + reservation.get(0).get("reservation_id");
		}
		String getTotalBill = "select sum(bill_total.price) as 'total fee' from (\r\n"
				+ "select rr.reservation_id as reservation_id, b.bill_id as 'bill identifier', sum(ph.price * bd.quantity) as price from bill b inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n"
				+ "inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n"
				+ "inner join out_product op on (bd.service_id = op.out_product_id) inner join product_price_history ph on ((ph.start_date <= b.payment_time) and (ph.end_date >= b.payment_time) and (ph.out_product_id = bd.service_id))\r\n"
				+ "group by bd.bill_id	) as bill_total where bill_total.reservation_id = " + roomNum
				+ " group by bill_total.reservation_id";
		if(getEachBillTotalFee != "" ) {
			results = sqlDao.queryForList(getEachBillTotalFee);
		}
		if(updateCheckOutTime != "") {
			sqlDao.insert(updateCheckOutTime);
		}
		if(updateBillTime != "") {
			sqlDao.insert(updateBillTime);
		}
		if(rPrice != "") {
			roomPrice = sqlDao.queryForList(rPrice);
		}
		if(getBillDetails != "") {
			billDetails = sqlDao.queryForList(getBillDetails);
		}
		billTotal = sqlDao.queryForList(getTotalBill);
		Set<String> keys = null;
		Set<String> ri = null;
		Set<String> billKeys = null;
		Set<String> roomKeys = null;
		Set<String> detailKeys = null;
		price = new HashSet<>();
		if (!billTotal.isEmpty()) {
			keys = reservation.get(0).keySet();
		}
		if (!reservation.isEmpty()) {
			ri = reservation.get(0).keySet();
		}
		if (!results.isEmpty()) {
			billKeys = results.get(0).keySet();
		}
		if (!roomPrice.isEmpty()) {
			roomKeys = roomPrice.get(0).keySet();
			try {
				checkOutDate = dateFormat.parse(roomPrice.get(0).get("Check-out Time").toString());
				if(now.after(checkOutDate)) {
					modelAndView.addObject("isValid", 0);
					modelAndView.addObject("roomNum", null);
					return checkLastestRecord(roomNum);
				} else {
					modelAndView.addObject("isValid", 1);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Map<String, Object> rp : roomPrice) {
				price.add(new BigDecimal((Double)rp.get("Room Price")));
			}
		}
		if(!billDetails.isEmpty()) {
			detailKeys = billDetails.get(0).keySet();
		}
		modelAndView.addObject("reservationId", reservation);
		modelAndView.addObject("bills", results);
		modelAndView.addObject("totalFee", billTotal);
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("billkeys", billKeys);
		modelAndView.addObject("rikeys", ri);
		modelAndView.addObject("roomkeys", roomKeys);
		modelAndView.addObject("roomPrice", roomPrice);
		modelAndView.addObject("price", price);
		modelAndView.addObject("detailKeys", detailKeys);
		modelAndView.addObject("billdetails", billDetails);
		modelAndView.addObject("roomNum", null);
		modelAndView.addObject("rooms", rooms);
		return modelAndView;
	}
	
	@GetMapping("/user/room_division/checkout_handle/{roomNum}")
	public ModelAndView checkLastestRecord(@PathVariable String roomNum) {
		ModelAndView modelAndView = new ModelAndView("user/room_division/checkout_handle");
		modelAndView.addObject("roomNum", roomNum);
		addUserInModel(modelAndView);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date checkOutDate = new Date();
		Date now = new Date();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> reservation = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> billTotal = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> roomPrice = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> billDetails = new ArrayList<Map<String, Object>>();
		String roomCheckOut = "select rr.reservation_id, c.full_name, c.phone_number from room_reservation rr\r\n"
				+ "inner join room r on (r.room_id = rr.room_id)\r\n"
				+ "inner join bill b on (b.reservation_id = rr.reservation_id)\r\n"
				+ "inner join customer c on (c.customer_id = b.bill_id)\r\n"
				+ "where rr.check_in_date <= now() and r.room_id = " + roomNum 
				+ " order by rr.check_out_date desc limit 1";
		reservation = sqlDao.queryForList(roomCheckOut);
		String getEachBillTotalFee = "";
		String rPrice = "";
		String getBillDetails = "";
		if(!reservation.isEmpty()) {
			getEachBillTotalFee = "select b.bill_id as 'bill identifier', sum(ph.price * bd.quantity) as 'Price' from bill b \r\n" + 
					"inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n" + 
					"inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n" + 
					"inner join product_price_history ph on ((ph.start_date < now())and (ph.end_date is null or ph.end_date > now()) and ph.out_product_id = bd.service_id)\r\n" + 
					"where rr.reservation_id =" + reservation.get(0).get("reservation_id") + "\r\n" + 
					"group by b.bill_id";
			rPrice = "select rr.reservation_id as 'Reservation ID', c.full_name as 'Full Name', r.room_id as 'Room ID', rr.check_in_date as 'Check-in Time',"
					+ " rr.check_out_date as 'Check-out Time', rt.price * datediff(rr.check_out_date, rr.check_in_date) as 'Room Price' from room_type rt \r\n" + 
					"inner join room r on (rt.room_type_id = r.room_type)\r\n" + 
					"inner join room_reservation rr on (rr.room_id = r.room_id)\r\n" + 
					"inner join bill b on (b.reservation_id = rr.reservation_id)\r\n" + 
					"inner join customer c on (c.customer_id = b.bill_id)\r\n" + 
					"where rr.check_in_date <= now() and rr.reservation_id =" + reservation.get(0).get("reservation_id")
					+ " order by rr.check_out_date desc limit 1";
			getBillDetails = "select op.out_product_name, bd.quantity as 'Quantity', sum(ph.price * bd.quantity) as 'Total', b.bill_id as 'bill identifier'from bill b \r\n" + 
					"inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n" + 
					"inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n" + 
					"inner join out_product op on (op.out_product_id = bd.service_id) "+
					"inner join product_price_history ph on ((ph.start_date < now())and (ph.end_date is null or ph.end_date > now()) and ph.out_product_id = bd.service_id)\r\n" + 
					"where b.reservation_id = " + reservation.get(0).get("reservation_id");
		}
		String getTotalBill = "select sum(bill_total.price) as 'total fee' from (\r\n"
				+ "select rr.reservation_id as reservation_id, b.bill_id as 'bill identifier', sum(ph.price * bd.quantity) as price from bill b inner join bill_detail bd on (b.bill_id = bd.bill_id)\r\n"
				+ "inner join room_reservation rr on (rr.reservation_id = b.reservation_id)\r\n"
				+ "inner join out_product op on (bd.service_id = op.out_product_id) inner join product_price_history ph on ((ph.start_date <= b.payment_time) and (ph.end_date >= b.payment_time) and (ph.out_product_id = bd.service_id))\r\n"
				+ "group by bd.bill_id	) as bill_total where bill_total.reservation_id = " + roomNum
				+ " group by bill_total.reservation_id";
		if(getEachBillTotalFee != "" ) {
			results = sqlDao.queryForList(getEachBillTotalFee);
		}
		if(rPrice != "") {
			roomPrice = sqlDao.queryForList(rPrice);
		}
		if(getBillDetails != "") {
			billDetails = sqlDao.queryForList(getBillDetails);
		}
		billTotal = sqlDao.queryForList(getTotalBill);
		Set<String> keys = null;
		Set<String> ri = null;
		Set<String> billKeys = null;
		Set<String> roomKeys = null;
		Set<String> detailKeys = null;
		price = new HashSet<>();
		if (!billTotal.isEmpty()) {
			keys = reservation.get(0).keySet();
		}
		if (!reservation.isEmpty()) {
			ri = reservation.get(0).keySet();
		}
		if (!results.isEmpty()) {
			billKeys = results.get(0).keySet();
		}
		if (!roomPrice.isEmpty()) {
			roomKeys = roomPrice.get(0).keySet();
			try {
				checkOutDate = dateFormat.parse(roomPrice.get(0).get("Check-out Time").toString());
				if(now.after(checkOutDate)) {
					modelAndView.addObject("isValid", 0);
				} else {
					modelAndView.addObject("isValid", 1);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Map<String, Object> rp : roomPrice) {
				price.add(new BigDecimal((Double)rp.get("Room Price")));
			}
		}
		if(!billDetails.isEmpty()) {
			detailKeys = billDetails.get(0).keySet();
		}
		modelAndView.addObject("reservationId", reservation);
		modelAndView.addObject("bills", results);
		modelAndView.addObject("totalFee", billTotal);
		modelAndView.addObject("keys", keys);
		modelAndView.addObject("billkeys", billKeys);
		modelAndView.addObject("rikeys", ri);
		modelAndView.addObject("roomkeys", roomKeys);
		modelAndView.addObject("roomPrice", roomPrice);
		modelAndView.addObject("price", price);
		modelAndView.addObject("detailKeys", detailKeys);
		modelAndView.addObject("billdetails", billDetails);
		List<Room> room = roomService.findAllRoom();
		modelAndView.addObject("rooms", room);
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/room_division/guest_registration", method = RequestMethod.GET)
	public ModelAndView guestRegistration() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("user/room_division/guest_registration");
		return modelAndView;
	}
}
