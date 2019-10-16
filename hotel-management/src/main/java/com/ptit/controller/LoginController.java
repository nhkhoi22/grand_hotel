package com.ptit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.service.UserService;
import com.ptit.staff.Department;
import com.ptit.staff.Position;
import com.ptit.staff.User;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	

	@RequestMapping(value = "/admin/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		Position position = new Position();
		Department department = new Department();
		modelAndView.addObject("user", user);
		modelAndView.addObject("department", department);
		modelAndView.addObject("position", position);
		modelAndView.setViewName("admin/registration");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, @RequestParam Map<String, String> reqPar,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		String pName = reqPar.get("pName");
		String dName = reqPar.get("dName");
		User userExists = userService.findUserByStaffCode(user.getStaffCode());
		Position positionExists = userService.findPositionByName(pName);
		Department departmentExists = userService.findDepartmentByName(dName);
		if (userExists != null) {
			bindingResult.rejectValue("staffCode", "error.user",
					"There is already a user registered with the staff code provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("admin/registration");
		} else {
			if (departmentExists == null) {
				departmentExists = new Department();
				departmentExists.setName(dName);
				userService.saveDepartment(departmentExists); 
			}

			if (positionExists == null) {
				positionExists = new Position();
				positionExists.setName(pName);
				positionExists.setDepartment(departmentExists);
				userService.savePosition(positionExists);
			}

			positionExists.setDepartment(departmentExists);

			departmentExists.getPositions().add(positionExists);
			userService.saveDepartment(departmentExists);
			
			user.setPosition(positionExists);
			userService.saveUser(user);

			positionExists.getUsers().add(user);
			userService.savePosition(positionExists);

			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.addObject("position", new Position());
			modelAndView.addObject("department", new Department());
			modelAndView.setViewName("admin/registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView searchStaff() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.findAllStaff();
		mav.addObject("users", users);
		mav.setViewName("admin/search");
		return mav;
	}
	
	@PostMapping("/lock/{staffCode}")
	@ResponseBody
	public String lockUser(@PathVariable String staffCode) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(auth.getName());
		if (user.getRole().getName() == "ADMIN") {
			user = userService.findUserByStaffCode(staffCode);
			user.setActive(0);
			userService.saveUserNonEncrypt(user);
		}
		return "lockUser";
	}
	
	@RequestMapping(value = "/admin/updatePassword", method = RequestMethod.GET)
	public ModelAndView updatePassword() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(auth.getName());
		ModelAndView mav = new ModelAndView("admin/updatePassword");
		mav.addObject("staff", user);
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
	public ModelAndView home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
        
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/menu", method = RequestMethod.POST)
	public ModelAndView menu() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
        
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/menu");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public ModelAndView userHome() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(authentication.getName());
        
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("user/home");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/information", method = RequestMethod.GET)
	public ModelAndView info() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByStaffCode(auth.getName());
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/information");
		return modelAndView;
	}

}
