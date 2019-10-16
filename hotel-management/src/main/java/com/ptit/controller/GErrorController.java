package com.ptit.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GErrorController implements ErrorController {
	
	public ModelAndView errorPage(boolean miss) {
		ModelAndView modelAndView = new ModelAndView();
		if(miss == true)
		{
			modelAndView.setViewName("errors/404");
		}
		else
		{
			modelAndView.setViewName("errors/500");
		}
		return modelAndView;
	}
	
	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	return errorPage(true);
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	return errorPage(false);
	        }
	    }
		return null;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
