package com.bookapp.model.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapp.model.entities.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory factory;
	
	public Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	@Override
	public Book add(Book book) {
		getCurrentSession().save(book);
		return book;
	}

	@Override
	public Book delete(int bookId) {
		Book bookToDelete=getById(bookId);
		getCurrentSession().delete(bookToDelete);
		return bookToDelete;
	}

	@Override
	public Book update(Book book) {
		return (Book) getCurrentSession().merge(book);
	}

	@Override
	public Book getById(int bookId) {
		return (Book) getCurrentSession().get(Book.class, bookId);
	}

	@Override
	public Book getByIsbn(String isbn) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAll() {
		return getCurrentSession().createQuery("from Book").list();
	}

}
