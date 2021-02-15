package com.bookapp.model.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	@NotEmpty(message="isbn cant left blank")
	private String isbn;
	@NotEmpty(message="title cant left blank")
	private String title;
	@NotEmpty(message="author cant left blank")
	private String author;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date pubDate;
	
	@NotNull(message="price can not be null")
	@Min(value=10, message="min price should be more then 10")
	@Max(value=10000, message="max price should be less then 10000")
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	
	public Book(int id, String isbn, String title, String author, double price) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book() {}
	
	public Book(String isbn, String title, String author, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book(String isbn, String title, String author, Date pubDate, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubDate = pubDate;
		this.price = price;
	}
	public Book(int id, String isbn, String title, String author, Date pubDate, double price) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubDate = pubDate;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", pubDate=" + pubDate
				+ ", price=" + price + "]";
	}
	
	
	
}
