package com.bookapp.model.dao;
import java.util.*;

import com.bookapp.model.entities.Book;
public interface BookDao {
	public Book add(Book book);
	public Book delete(int bookId);
	public Book update(Book book);
	public Book getById(int bookId);
	public Book getByIsbn(String isbn);
	public List<Book> getAll();
	
}
