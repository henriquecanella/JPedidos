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

	///=====UTILS=====
	//JDBCUtil
	@Test
	public void JDBCUtilInitTest() throws IOException, ClassNotFoundException{
		JDBCUtil con = new JDBCUtil();
		String path = System.getProperty("user.dir");
		File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");

		JDBCUtil.init(config_file);
	}

	// @Test
	// public void JDBCUtilGetConnectionTest() throws IOException, ClassNotFoundException, SQLException{
	// 	String path = System.getProperty("user.dir");
	// 	File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");

	// 	JDBCUtil.init(config_file);

	// 	assertEquals(JDBCUtil.getConnection(), Connection.class);
	// }

	///=====MAIN===
	//Main
	@Test
	public void mainTest(){
		Main m = new Main();
		m.main(null);
	}
	
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
	//UserDAO
	@Test
	public void userDAOUserAuthTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.userAuth(u);
	}

	@Test
	public void userDAOCreateUserTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.createUser(u);
	}

	@Test
	public void userDAOAlterUserTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.alterarUser(u);
	}

	@Test
	public void userDAODeleteUserTest(){
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUser_name("Joao");
		u.setUser_login("joaovitor");
		u.setUser_password("minhasenha");
		u.setUser_mail("joao@email.com");
		u.setUser_role("admin");

		userDAO.deleteUser(u);
	}

	//OrderDAO
	@Test
	public void orderDAOCreateTest(){
		OrderDAO orderDAO = new OrderDAO();
		Order o = new Order();
		ArrayList<Product> p_list = new ArrayList<>();

		o.setOrder_customer_name("Customer1");
		o.setOrder_customer_phone("(16)99999-9999");
		o.setUser_id(1);
		o.setOrder_total(5.55f);
		
		orderDAO.createOrder(o, p_list);
	}
}
