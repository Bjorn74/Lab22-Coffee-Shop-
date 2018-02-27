package com.gc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.Items;
import com.gc.model.User;

@Controller
public class HomeController {

	private static final String SALT = "This is the dawning of the age of asparagus";

	@RequestMapping("index")
	public ModelAndView index() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Items.class);
		@SuppressWarnings("unchecked")
		ArrayList<Items> itemList = (ArrayList<Items>) crit.list();
		tx.commit();
		session.close();

		return new ModelAndView("index", "iList", itemList);
	}

	@RequestMapping("insert")
	public ModelAndView insertUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password) throws SQLException, ClassNotFoundException {
		password = SALT + password;
		password = generateHash(password);
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User newUser = new User();
		newUser.setUserName(userName);
		newUser.setPassword(password);
		
        session.save(newUser);
        
        session.getTransaction().commit();
        session.close();



		return new ModelAndView("index", "index", "It worked");
	}

	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int i = 0; i < hashedBytes.length; i++) {
				byte b = hashedBytes[i];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
	
	private Connection getDBConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/northwind";
		String userName = "root";
		String password = "!waidh?oy";

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

}
