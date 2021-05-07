/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import Models.Customer;

/**
 *
 * @author henrique
 */
public class CustomerDAOTest {
    @Test
    public void customerDAOCreateTest() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer c = new Customer();
        
        c.setCustomer_id(1);
        c.setCustomer_name("nome cliente");
        c.setCustomer_phone("(14)99999-9999");
        c.setCustomer_address("Rua Legal 123");
        
        customerDAO.CreateCustomer(c);
    }
    
    @Test
    public void customerDAOUpdate() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer c = new Customer();
        
        c.setCustomer_id(1);
        c.setCustomer_name("nome cliente");
        c.setCustomer_phone("(14)99999-9999");
        c.setCustomer_address("Rua Legal 123");
        
        customerDAO.updateCustomer(c);
    }
    
    @Test
    public void customerDAODelete() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer c = new Customer();
        
        c.setCustomer_id(1);
        c.setCustomer_name("nome cliente");
        c.setCustomer_phone("(14)99999-9999");
        c.setCustomer_address("Rua Legal 123");
        
        customerDAO.deleteCustomer(c);
    }
   
}
