package com.bookapp.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNotFoundEx() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		mv.addObject("error", "resource/page not found");
		return mv;
	}

	@ExceptionHandler(DataAccessException.class)
	public String handleDataAccessException(HttpServletRequest request,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", ex);
		mv.addObject("url", request.getRequestURL());
		return "database_error";
	}
}
