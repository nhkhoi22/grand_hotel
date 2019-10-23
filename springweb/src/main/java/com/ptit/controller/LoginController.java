package com.ptit.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.model.Department;
import com.ptit.model.Position;
import com.ptit.model.User;
import com.ptit.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        Position position = new Position();
        Department department = new Department();
        modelAndView.addObject("user", user);
        modelAndView.addObject("department", department);
        modelAndView.addObject("position", position);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, @RequestParam Map<String,String> reqPar
    		, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        String pName = reqPar.get("pName");
        String dName = reqPar.get("dName");
        User userExists = userService.findUserByStaffCode(user.getStaffCode());
        Position positionExists = userService.findPositionByName(pName);
        Department departmentExists = userService.findDepartmentByName(dName);
        if (userExists != null) {
            bindingResult
                    .rejectValue("staffCode", "error.user",
                            "There is already a user registered with the staff code provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
        	if(departmentExists == null) {
        		departmentExists = new Department();
        		departmentExists.setName(dName);
        	}
        	userService.saveDepartment(departmentExists);
        	departmentExists = userService.findDepartmentByName(dName);
        	
        	if(positionExists == null) {
            	positionExists = new Position();
            	positionExists.setName(pName);
            }
        	
        	positionExists.setDepartment(departmentExists);
        	
        	userService.savePosition(positionExists);
        	positionExists = userService.findPositionByName(pName);
        	
        	departmentExists.getPositions().add(positionExists);
        	userService.saveDepartment(departmentExists);
        	
        	userService.saveUser(user, positionExists);
        	
        	positionExists.getUsers().add(user);
        	userService.savePosition(positionExists);
        	
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.addObject("position", new Position());
            modelAndView.addObject("department", new Department());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByStaffCode(auth.getName());
        modelAndView.addObject("staffCode", "Welcome " + user.getName()  + " (" + user.getStaffCode() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/information", method = RequestMethod.GET)
    public ModelAndView info() {
    	ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByStaffCode(auth.getName());
        modelAndView.addObject("email",user.getStaffCode());
        modelAndView.addObject("user", user.getName());
        modelAndView.addObject("role", user.getActive());
        modelAndView.setViewName("/information");
    	return modelAndView;
    }

}
