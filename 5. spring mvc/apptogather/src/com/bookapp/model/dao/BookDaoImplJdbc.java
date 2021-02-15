package com.bookapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookDaoImplJdbc implements BookDao {

	private DataSource dataSource;

	@Autowired
	public BookDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		Book tempBook = null;
		try (Connection connection = dataSource.getConnection()) {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");

			while (rs.next()) {
				tempBook = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"), rs.getDate("pubDate"), rs.getDouble("price"));
				books.add(tempBook);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public void addBook(Book book) {
		try {
			Connection connection = dataSource.getConnection();

			String add_book_query = "insert into books(isbn, title, author, pubDate, price) values(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(add_book_query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDate(4, new Date(book.getPubDate().getTime()));
			pstmt.setDouble(5, book.getPrice());

			int noOfRowsEffected = pstmt.executeUpdate();

			if (noOfRowsEffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				book.setId(rs.getInt(1));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public void deleteBook(int id) {
        Book bookToBeDeleted = getBookById(id);
           
           try {
               Connection connection=dataSource.getConnection();
               String delete_book_by_id="delete from books where id=?";
               PreparedStatement pstmt= connection.prepareStatement(delete_book_by_id);
               pstmt.setInt(1, id);
               pstmt.executeUpdate();
               
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}

	@Override
	public void updateBook(int id, Book book) {
		Book bookToUpdate=getBookById(book.getId());
        Connection conn=null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update books set price=? where id=?");
            pstmt.setDouble(1, book.getPrice());
            pstmt.setInt(2, book.getId());
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
	}

	@Override
	public Book getBookById(int id) {
		Connection conn;
		PreparedStatement pstmt;
		Book book = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from books where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDate("pubDate"), rs.getDouble("price"));
			} else {
				throw new BookNotFoundException("book with id " + id + " not found");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return book;
	}

}
