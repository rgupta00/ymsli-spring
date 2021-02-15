package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;

	//@Resource(name = "jdbc/ymsli")
	private DataSource dataSource;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/ymsli");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			connection = dataSource.getConnection();
			if (connection != null)
				System.out.println("conn is obtained from conn pool :)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

// i have confiure conn pool "jdbc/ymsli"
//my servlet need that ( kid) how he can get it: pull vs push

//this is push approach: container see the ann 	@Resource(name="jdbc/ymsli")
//he get ds and push into this : push approach aka DI appr

// J2EE 1.4: jndi mapping code :(
//
//// java EE 5
//@Resource(name = "jdbc/ymsli")
//private DataSource dataSource;
