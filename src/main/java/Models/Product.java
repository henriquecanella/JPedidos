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
public class Product {
    private int product_id;
    private String product_name;
    private String product_description;
    private float product_price;
    
    public Product(){
    }
    
    public Product(int id, String name, String description, float price){
        this.product_id = id;
        this.product_name = name;
        this.product_description = description;
        this.product_price = price;
    }
    
    @Override
    public String toString() {
        String resposta = this.getProduct_id()      + "\n";
        resposta += this.getProduct_name()          + "\n";
        resposta += this.getProduct_description()   + "\n";
        resposta += this.getProduct_price()         + "\n";
        return resposta;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }
    
    
}
