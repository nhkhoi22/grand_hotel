package com.ptit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.dao.SqlDAO;
import com.ptit.service.UserService;
import com.ptit.staff.Department;
import com.ptit.staff.Position;
import com.ptit.staff.User;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SqlDAO sqlDao;
	
	private void addUserInModel(ModelAndView mav) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
		mav.addObject("user", user);
	}
	
	@RequestMapping(value = "/user/human_resources/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User newUser = new User();
		addUserInModel(modelAndView);
		List<Department> departments = userService.findAllDepartment();
		List<Position> positions = userService.findAllPosition();
		modelAndView.addObject("newUser", newUser);
		modelAndView.addObject("departments", departments);
		modelAndView.addObject("positions", positions);
		modelAndView.setViewName("user/human_resources/registration");
		return modelAndView;
	}

	@RequestMapping(value = "/user/human_resources/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User newUser, @RequestParam Map<String, String> reqPar,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Long pName = Long.parseLong(reqPar.get("pName"));
		Long dName = Long.parseLong(reqPar.get("dName"));
		User userExists = userService.findUserByStaffCode(newUser.getStaffCode());
		Position positionExists = userService.findPositionById(pName);
		Department departmentExists = userService.findDepartmentById(dName);
		if (userExists != null) {
			bindingResult.rejectValue("staffCode", "error.user",
					"There is already a user registered with the staff code provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("user/human_resources/registration");
		} else {
			positionExists.setDepartment(departmentExists);

			departmentExists.getPositions().add(positionExists);
			userService.saveDepartment(departmentExists);
			
			newUser.setPosition(positionExists);
			userService.saveUser(newUser);

			positionExists.getUsers().add(newUser);
			userService.savePosition(positionExists);

			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("newUser", new User());
			modelAndView.addObject("position", new Position());
			modelAndView.addObject("department", new Department());
			modelAndView.setViewName("user/human_resources/registration");

		}
		return modelAndView;
	}
	

	@RequestMapping(value = "/user/human_resources/list_user", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView searchStaff() {
		ModelAndView mav = new ModelAndView();
		addUserInModel(mav);
		List<User> users = userService.findAllStaff();
		mav.addObject("users", users);
		mav.setViewName("user/human_resources/list_user");
		return mav;
	}
	
	@PostMapping("/admin/lock/{staffCode}")
	@ResponseBody
	public String lockUser(@PathVariable String staffCode) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(auth.getName());
		if (user.getRole().getId() == 1L) {
			user = userService.findUserByStaffCode(staffCode);
			if(user.getActive() == 1L) {
				user.setActive(0);
			} else {
				user.setActive(1);
			}
			userService.saveUserNonEncrypt(user);
		}
		return "lockUser";
	}
	
	@RequestMapping(value = "/admin/updatePassword", method = RequestMethod.GET)
	public ModelAndView updatePassword() {
		ModelAndView mav = new ModelAndView("admin/updatePassword");
		addUserInModel(mav);
		return mav;
	}
	
	@RequestMapping(value = "/admin/updatePassword", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole()")
	@ResponseBody
	public ModelAndView changeUserPassword(@RequestParam Map<String, String> reqPar, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
	    User user = userService.findUserByStaffCode(
	      SecurityContextHolder.getContext().getAuthentication().getName());
	     
	    String oldPassword = reqPar.get("passOld");
	    String newPassword = reqPar.get("pass1");
	    
	    if(userService.checkIfValidOldPassword(user, oldPassword)) {
	    	mav.setViewName("admin/updatePassword");
	    	return mav;
	    }
	    
	    userService.changeUserPassword(user, newPassword);
	    mav.setViewName("admin/home");
	    return mav;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/information", method = RequestMethod.GET)
	public ModelAndView info() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("admin/information");
		return modelAndView;
	}
	@RequestMapping(value = "/admin/sql_test", method = RequestMethod.GET)
	public ModelAndView sqlTest() {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		modelAndView.setViewName("admin/sql_test");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/sql_test", method = RequestMethod.POST)
	public ModelAndView executeSql(@RequestParam String sqlEditor) {
		ModelAndView modelAndView = new ModelAndView();
		addUserInModel(modelAndView);
		List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
		if(sqlEditor.toLowerCase().indexOf("select") == 0) {
			results = sqlDao.queryForList(sqlEditor);
			Set<String> keys = results.get(0).keySet();
			modelAndView.addObject("keys", keys);
			modelAndView.addObject("results", results);
		} else {
			if(sqlDao.insert(sqlEditor)) {
				modelAndView.addObject("isValid", 1);
			} else {
				modelAndView.addObject("isValid", 0);
			}
			modelAndView.addObject("keys", new ArrayList<String>());
			modelAndView.addObject("results", new ArrayList<Map<String,Object>>());
		}
		modelAndView.setViewName("admin/sql_test");
		return modelAndView;
	}
}
