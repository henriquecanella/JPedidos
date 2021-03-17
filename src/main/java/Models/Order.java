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
public class Order {

    /**
     * @return the order_total
     */
    public float getOrder_total() {
        return order_total;
    }

    /**
     * @param order_total the order_total to set
     */
    public void setOrder_total(float order_total) {
        this.order_total = order_total;
    }
    private int order_id;
    private int order_amount;
    private String order_customer_name;
    private String order_customer_phone;
    private int user_id;
    private float order_total;
    
    public Order(){
    }
    
    public Order(int id, int amount, String customer_name, String customer_phone, int user_id){
        this.order_id = id;
        this.order_amount = amount;
        this.order_customer_name = customer_name;
        this.order_customer_phone = customer_phone;
        this.user_id = user_id;
    }
    
    public String toString() {
        String resposta = this.getOrder_id()        + "\n";
        resposta += this.getOrder_amount()          + "\n";
        resposta += this.getOrder_customer_name()   + "\n";
        resposta += this.getOrder_customer_phone()  + "\n";
        resposta += this.getUser_id()               + "\n";
        return resposta;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public String getOrder_customer_name() {
        return order_customer_name;
    }

    public String getOrder_customer_phone() {
        return order_customer_phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public void setOrder_customer_name(String order_customer_name) {
        this.order_customer_name = order_customer_name;
    }

    public void setOrder_customer_phone(String order_customer_phone) {
        this.order_customer_phone = order_customer_phone;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
}
