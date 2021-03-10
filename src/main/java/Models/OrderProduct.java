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
public class OrderProduct {
    private int order_id;
    private int product_id;
    
    public OrderProduct(){
    }
    
    public OrderProduct(int order_id, int product_id){
        this.order_id = order_id;
        this.product_id = product_id;
    }
    
    @Override
    public String toString() {
        String resposta = this.getOrder_id() + "\n";
        resposta += this.getProduct_id() + "\n";
        return resposta;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    
    
}
