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
    
    private int order_id;
    private int user_id;
    private int customer_id;
    private float order_total;
    private String order_status;
    private String created_at;
    private String closed_at;
    
    public Order(){
    }
    
    public Order(int id, int user_id, int customer_id, String status, String created_at, String closed_at){
        this.order_id = id;
        this.user_id = user_id;
        this.customer_id = customer_id;
        this.order_status = status;
        this.created_at = created_at;
        this.closed_at = closed_at;
    }
    
    public String toString() {
        String resposta = this.getOrder_id()        + "\n";
        resposta += this.getUser_id()               + "\n";
        resposta += this.getCustomer_id()           + "\n";
        resposta += this.getOrder_status()          + "\n";
        resposta += this.getCreated_at()            + "\n";
        resposta += this.getClosed_at()             + "\n";
        return resposta;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id() {
        return user_id;
    }
    
    public int getCustomer_id() {
        return customer_id;
    }
    
    public float getOrder_total() {
        return order_total;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getClosed_at() {
        return closed_at;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    
    public void setOrder_total(float order_total) {
        this.order_total = order_total;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setClosed_at(String closed_at) {
        this.closed_at = closed_at;
    }
    
    
}
