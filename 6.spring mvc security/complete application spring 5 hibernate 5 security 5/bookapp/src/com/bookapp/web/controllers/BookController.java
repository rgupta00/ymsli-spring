package com.bookapp.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.entities.Book;
import com.bookapp.model.service.BookNotFoundException;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@ModelAttribute(value="publishers")
	public List<String> getAllPublishers(){
		return Arrays.asList("pbp","wrox","headfirst");
	}
	
	@RequestMapping(value = "getallbooks", method = RequestMethod.GET)
	public ModelAndView getAllBooks(ModelAndView mv) {
		mv.setViewName("show_books");
		mv.addObject("books", service.getAll());
		return mv;
	}

	@RequestMapping(value = "addbook", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "add_book";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateBook(HttpServletRequest request , ModelMap model) {
		
		Integer bookId=Integer.parseInt(request.getParameter("id"));
		Book bookToUpdate=service.getById(bookId);
		model.addAttribute("book",bookToUpdate );
		return "add_book";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBook(HttpServletRequest request ) {
		
		Integer bookId=Integer.parseInt(request.getParameter("id"));
		service.delete(bookId);
		return "redirect:getallbooks";
	}

	
	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public String addBookPost(@ModelAttribute(value="book") @Valid Book book, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "add_book";
		}else{
		if(book.getId()==0)
			service.add(book);
		else
			service.update(book);
		}
		return "redirect:getallbooks";
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ModelAndView handleBookNotFoundException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}	
}
