package com.bookapp.web.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookapp.model.persistance.Book;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;


	@RequestMapping(value = "allbooks", method = RequestMethod.GET)
	public String getBooks(ModelMap map) {
		map.addAttribute("books", bookService.getAllBooks());
		return "all_books";
	}

	@RequestMapping(value = "addbook", method = RequestMethod.GET)
	public String addBookGet(ModelMap map) {
		// adding an form bean
		map.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public String addBookUpdatePost(@Valid Book book,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addbook";
		} else {

			if (book.getId() == 0)
				bookService.addBook(book);
			else
				bookService.updateBook(book);
			return "redirect:allbooks";
		}
	}

	// controller mapped for delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBook(HttpServletRequest req) {
		int bookId = Integer.parseInt(req.getParameter("id"));
		bookService.removeBook(bookId);
		return "redirect:allbooks";
	}

	// update get part
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateBookGet(HttpServletRequest req, ModelMap map) {
		int bookId = Integer.parseInt(req.getParameter("id"));
		Book bookToBeUpdate = bookService.getBookById(bookId);
		System.out.println(bookToBeUpdate);
		map.addAttribute("book", bookToBeUpdate);
		return "addbook";
	}

	@ModelAttribute(value = "pubList")
	public List<String> getPublisherList() {
		return Arrays.asList("wrox", "bpb", "abc", "MAL");
	}
}
