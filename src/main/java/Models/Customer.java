/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author henrique
 */
public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_phone;
    private String customer_address;
    
    public Customer(){
    }
    
    public Customer(int id, String name, String phone, String address){
        this.customer_id = id;
        this.customer_name = name;
        this.customer_phone = phone;
        this.customer_address = address;
    }
    
    @Override
    public String toString() {
        String resposta = this.getCustomer_id()     + "\n";
        resposta += this.getCustomer_name()         + "\n";
        resposta += this.getCustomer_phone()        + "\n";
        resposta += this.getCustomer_address()      + "\n";
        return resposta;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
    
    
}



