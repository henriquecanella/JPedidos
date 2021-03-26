package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import Models.Order;
import Models.Product;

public class OrderDAOTest {
  //OrderDAO
	@Test
	public void orderDAOCreateEmptyListTest(){
		OrderDAO orderDAO = new OrderDAO();
		Order o = new Order();
		ArrayList<Product> p_list = new ArrayList<>();

		o.setOrder_customer_name("Customer1");
		o.setOrder_customer_phone("(16)99999-9999");
		o.setUser_id(1);
		o.setOrder_total(5.55f);
		
		orderDAO.createOrder(o, p_list);
	}
  //OrderDAO
	@Test
	public void orderDAOCreateListOneItemTest(){
		OrderDAO orderDAO = new OrderDAO();
		Order o = new Order();
		ArrayList<Product> p_list = new ArrayList<>();

    Product p = new Product();

		o.setOrder_customer_name("Customer1");
		o.setOrder_customer_phone("(16)99999-9999");
		o.setUser_id(1);
		o.setOrder_total(5.55f);

    p_list.add(p);
		
		orderDAO.createOrder(o, p_list);
	}
}
