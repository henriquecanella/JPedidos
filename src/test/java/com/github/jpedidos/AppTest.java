package com.github.jpedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import Controllers.OrderDAO;
import Controllers.ProductDAO;
import Controllers.UserDAO;
import Main.Main;
import Models.Order;
import Models.OrderProduct;
import Models.Product;
import Models.User;
import Utils.JDBCUtil;
import Views.Central;
import Views.Login;

public class AppTest {
	///=====MODELS======
	

/*	

	
	

	///=====UTILS=====
	

	///=====MAIN===

	
	///=====VIEWS=====
	//Central
	@Test
	public void centralTest(){
		Central c = new Central();
	}

	@Test
	public void centralAdminTest(){
		Central m = new Central("admin", "0");
	}

	@Test
	public void centralEmployeeTest(){
		Central m = new Central("Manager", "0");
	}

	@Test
	public void centralManagerTest(){
		Central m = new Central("Employee", "0");
	}

	@Test
	public void centralNonMatchingTest(){
		Central m = new Central("Type4", "0");
	}

	@Test
	public void centralTestNull(){
		assertThrows(Exception.class, () -> new Central(null, "0"));
	}

	@Test
	public void centralTestVazio(){
		new Central("", "0");
	}

	@Test
	public void centralMainTest(){
		new Central("", "0");
		String[] s = {""};
		Central.main(s);
	}

	//User
	@Test
	public void userViewCheckLoginFalseTest() {
		Views.User vu = new Views.User();

		assertFalse(vu.checkIfLoginExists("João"));		
	}

	@Test
	public void userViewCheckLoginTrueTest() {
		Views.User vu = new Views.User();

		assertTrue(vu.checkIfLoginExists("admin"));	
	}
	
	@Test
	public void userViewCheckEmailFalseTest() {
		Views.User vu = new Views.User();

		assertFalse(vu.checkIfEmailExists("joao@email.com"));		
	}

	@Test
	public void userViewCheckEmailTrueTest() {
		Views.User vu = new Views.User();

		assertTrue(vu.checkIfEmailExists("admin@email.com"));	
	}

	@Test
	public void userViewCreateUserTrueTest() {
		Views.User vu = new Views.User();

		vu.clearFields();	
	}

	//Login
	@Test
	public void loginHandleTest() {
		Login log = new Login();

		log.handleLogin();
	}

	//Order

	///=====CONTROLERS=====
	

	*/
}