package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
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

		o.setCustomer_id(1);
		o.setUser_id(1);
		o.setOrder_total(5.55f);
		
		orderDAO.createOrder(o, p_list);
	}
	
	@Test
	public void orderDAOCreateListOneEmptyItemTest(){
		OrderDAO orderDAO = new OrderDAO();
		Order o = new Order();
		ArrayList<Product> p_list = new ArrayList<>();

    Product p = new Product();

		o.setCustomer_id(1);
		o.setUser_id(1);
		o.setOrder_total(5.55f);

    p_list.add(p);
		
	orderDAO.createOrder(o, p_list);
	}
}
