package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/allbooks";
	}

	@GetMapping("allbooks")
	public ModelAndView allBooks(ModelAndView mv) {
		mv.setViewName("allbooks");
		mv.addObject("books", bookService.getAllBooks());
		return mv;
	}

	// we want to write code to add the book
	// ====================================
	// get
	@GetMapping("addbook")
	public String addBookGet(ModelMap map) {
		Book book = new Book();
		book.setAuthor("raj");
		// form bean :write now its empty
		// now i want to bind this object with the page...so that when user type
		// something is should be avaiable to that bean

		map.addAttribute("book", book);
		return "addbook";
	}

	// post
	@PostMapping("addbook")
	public String addBookPost(@Valid @ModelAttribute(name = "book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "addbook";
		} else {
			int id = book.getId();
			if (id == 0)
				bookService.addBook(book);
			else
				bookService.updateBook(id, book);

			return "redirect:/allbooks";
		}
	}

	// we want to do update operation
	// ==============================
	@GetMapping("updatebook")
	public String updateBookGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		Book book = bookService.getBookById(id);
		map.addAttribute("book", book);
		return "updatebookpage";
	}

	@GetMapping("deletebook")
	public String delBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		bookService.deleteBook(id);
		// return "allbooks"; // this will not work.. it will only do request dispached
		// to page allbooks.jsp
		return "redirect:/allbooks";
	}

}
