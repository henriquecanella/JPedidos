package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.Product;

public class ProductTest {
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
}
