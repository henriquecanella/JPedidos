package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.OrderProduct;

public class OrderProductTest {
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
}
