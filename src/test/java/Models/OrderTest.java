package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.OrderProduct;

public class OrderTest {
  
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
