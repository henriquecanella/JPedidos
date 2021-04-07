package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import Models.Order;
import Models.Product;

public class ProductDAOTest {
  //ProductDAO
	@Test
	public void producctDAOCreateProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, "Produto1", "Esse eh o produto1", 250f);

		assertEquals(0, pd.createProduct(p));
	}
	
	@Test
	public void producctDAOCreateEmptyProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product();

		assertEquals(1, pd.createProduct(p));
	}

	@Test
	public void producctDAOCreateEmptyNameProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, null, "Esse eh o produto1", 250f);

		assertEquals(1, pd.createProduct(p));
	}

	@Test
	public void producctDAOCreateEmptyDescriptionProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, "Produto1", null, 250f);

		assertEquals(1, pd.createProduct(p));
	}	
	
	@Test
	public void producctDAOUpdateProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(2, "Produto1", "Esse eh o produto1", 250f);

		assertEquals(0, pd.updateProduct(p));
	}
	
	@Test
	public void producctDAOUpdateEmptyProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product();

		assertEquals(1, pd.updateProduct(p));
	}

	@Test
	public void producctDAOUpdateEmptyNameProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, null, "Esse eh o produto1", 250f);

		assertEquals(1, pd.updateProduct(p));
	}

	@Test
	public void producctDAOUpdateEmptyDescriptionProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, "Produto1", null, 250f);

		assertEquals(1, pd.updateProduct(p));
	}	
		
	@Test
	public void producctDAODeleteProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, "Produto1", "Esse eh o produto1", 250f);

		assertEquals(0, pd.deleteProduct(p));
	}
	
	@Test
	public void producctDAODeleteEmptyProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product();

		assertEquals(1, pd.deleteProduct(p));
	}

	@Test
	public void producctDAODeleteEmptyNameProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, null, "Esse eh o produto1", 250f);

		assertEquals(1, pd.deleteProduct(p));
	}

	@Test
	public void producctDAODeleteEmptyDescriptionProduct(){
		ProductDAO pd = new ProductDAO();
		Product p = new Product(1, "Produto1", null, 250f);

		assertEquals(1, pd.deleteProduct(p));
	}	
	
}
