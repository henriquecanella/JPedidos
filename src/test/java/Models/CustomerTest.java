package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Models.Customer;

public class CustomerTest {

  //Customer
  @Test
  public void customerConstructorTest() {
    Customer c = new Customer(1, "cliente", "(11)99999-9999", "Rua Legal 123");

    assertEquals(
      "1\n" +
      "cliente\n" +
      "(11)99999-9999\n" +
      "Rua Legal 123\n"
      , c.toString()
    );
  }

  @Test
  public void customerSettersTest() {
    Customer c = new Customer();
    
    c.setCustomer_id(1);
    c.setCustomer_name("cliente");
    c.setCustomer_phone("(11)99999-9999");
    c.setCustomer_address("Rua Legal 123");
    
    assertEquals(1, c.getCustomer_id());
    assertEquals("cliente", c.getCustomer_name());
    assertEquals("(11)99999-9999", c.getCustomer_phone());
    assertEquals("Rua Legal 123", c.getCustomer_address());

  }

}