package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.OrderProduct;
import java.util.Date;

public class OrderTest {
  
  //Order
  @Test
  public void orderConstructorTest(){
    // Order o = new Order(0, 2, "Joao da Silva", "(16)99999-9999", 5);

    
    Order o = new Order(1, 1, 1, "open", new Date(), new Date());
    
    assertEquals(
    "1\n" + 
    "1\n" + 
    "1\n" +
    "open\n" +
    new Date() + "\n" +
    new Date() + "\n" 
    , o.toString()
    );
  }
  
  @Test
  public void orderSettersTest(){
    Order o = new Order();
    
    o.setOrder_id(1);
    o.setUser_id(1);
    o.setCustomer_id(1);
    o.setOrder_total(500f);
    o.setOrder_status("closed");
    o.setCreated_at(new Date());
    o.setClosed_at(new Date());
    
    assertEquals(
    "1\n" + 
    "1\n" + 
    "1\n" +
    "closed\n" +
    new Date() + "\n" +
    new Date() + "\n" 
    , o.toString()
    );

    assertEquals(500f, o.getOrder_total());
  } 
}
