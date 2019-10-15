package com.ptit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorController {
	
	@RequestMapping(value = { "/errors/404" }, method = RequestMethod.GET)
	public ModelAndView errorNotFound() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("errors/404");
		return modelAndView;
	}

	@RequestMapping(value = { "/errors/500" }, method = RequestMethod.GET)
	public ModelAndView errorNotAvailable() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("errors/500");
		return modelAndView;
	}
}
