package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.entities.Book;

public interface BookService {
	public Book add(Book book);
	public Book delete(int bookId);
	public Book update(Book book);
	public Book getById(int bookId);
	public Book getByIsbn(String isbn);
	public List<Book> getAll();
}
