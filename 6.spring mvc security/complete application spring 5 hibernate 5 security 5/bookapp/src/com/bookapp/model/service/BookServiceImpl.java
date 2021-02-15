package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.BookDao;
import com.bookapp.model.entities.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao;

	@Override
	public Book add(Book book) {
		return dao.add(book);
	}

	@Override
	public Book delete(int bookId) {
		return dao.delete(bookId);
	}

	@Override
	public Book update(Book book) {
		return dao.update(book);
	}

	@Override
	public Book getById(int bookId) {
		return dao.getById(bookId);
	}

	@Override
	public Book getByIsbn(String isbn) {
		return dao.getByIsbn(isbn);
	}

	@Override
	public List<Book> getAll() {
		return dao.getAll();
	}

}
