package com.bookapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.service.aspects.Loggable;

@Service(value="bookservice")
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Loggable
	@Override
	public List<Book> getAllBooks() {
		List<Book> books=bookDao.getAllBooks();
		return books;
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
