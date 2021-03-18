package com.github.jpedidos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import Models.Order;
import Models.OrderProduct;
import Models.Product;
import Models.User;

public class AppTest {
	///=====MODELS======
	//USER
	@Test
	public void userConstructorTest() {
		// System.out.println("some test");
		User u = new User(0, "João", "joao123", "minhasenha", "joao@email.com", "admin");
        
		assertEquals("João", u.getUser_name());
	}

	@Test
	public void userGettersSettersTest() {
		// System.out.println("some test");
		User u = new User();

		u.setUser_id(0);
		u.setUser_name("João");
		u.setUser_login("joao123");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		assertEquals(0, u.getUser_id());
		assertEquals("João", u.getUser_name());
		assertEquals("joao123", u.getUser_login());
		assertEquals("minhasenha", u.getUser_password());
		assertEquals("joao@email.com", u.getUser_mail());
		assertEquals("admin", u.getUser_role());
	}

	@Test
	public void userToStringTest(){
		User u = new User(0, "João", "joao123", "minhasenha", "joao@email.com", "admin");

		assertEquals(0 + "\n" 
			+ "João\n" 
			+ "joao123\n"
			+ "minhasenha\n"
			+ "joao@email.com\n"
			+ "admin\n",
			u.toString());
	} 

	//OderProduct
	@Test
	public void orderProductConstructorTest() {
		OrderProduct op = new OrderProduct(2,5);

		assertEquals(2+"\n" + 5 + "\n", op.toString());
	}

	@Test
	public void orderProductSettersTest() {
		OrderProduct op = new OrderProduct();
		op.setOrder_id(2);
		op.setProduct_id(5);

		assertEquals(2+"\n" + 5 + "\n", op.toString());
	}

	//Product
	@Test
	public void productConstructorTest() {
		Product p = new Product(2, "Produto 1", "Essa e a descricao do produto um.", 5.5f);

		assertEquals(
			"2\n" + 
			"Produto 1\n" +
			"Essa e a descricao do produto um.\n" +
			"5.5\n"
			, p.toString());
	}

	@Test
	public void productSettersTest() {
		Product p = new Product();

		p.setProduct_id(2);
		p.setProduct_name("Produto 1");
		p.setProduct_description("Essa e a descricao do produto um.");
		p.setProduct_price(5.5f);

		assertEquals(
			"2\n" + 
			"Produto 1\n" +
			"Essa e a descricao do produto um.\n" +
			"5.5\n"
			, p.toString());
	}

	//Order
	@Test
	public void orderConstructorTest(){
		Order o = new Order(0, 2, "Joao da Silva", "(16)99999-9999", 5);

		assertEquals(
			"0\n" + 
			"2\n" + 
			"Joao da Silva\n" +
			"(16)99999-9999\n" +
			"5\n"
			, o.toString()
		);
	}

	@Test
	public void orderSettersTest(){
		Order o = new Order();

		o.setOrder_id(0);
		o.setOrder_amount(2);
		o.setOrder_customer_name("Joao da Silva");
		o.setOrder_customer_phone("(16)99999-9999");
		o.setUser_id(5);

		assertEquals(
			"0\n" + 
			"2\n" + 
			"Joao da Silva\n" +
			"(16)99999-9999\n" +
			"5\n"
			, o.toString()
		);
	}

	@Test
	public void orderTotalTest() {
		Order o = new Order(0, 2, "Joao da Silva", "(16)99999-9999", 5);
		
		o.setOrder_total(5.5f);

		assertEquals(5.5f, o.getOrder_total());
	}
}
