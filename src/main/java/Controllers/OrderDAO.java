/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Customer;
import Models.Order;
import Models.OrderProduct;
import Models.Product;
import Models.User;
import Utils.JDBCUtil;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class OrderDAO {
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection connection = null;
    String sql;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Order> list = new ArrayList<>();

    public void createOrder(Order order, Customer customer, ArrayList<Product> productList){
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            
            java.sql.Timestamp today = new java.sql.Timestamp(new java.util.Date().getTime());
            
            sql = "insert into orders(user_id, customer_id, order_total, order_status, created_at) values(?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, order.getUser_id());
            pstm.setInt(2, customer.getCustomer_id());
            pstm.setFloat(3, order.getOrder_total());
            pstm.setString(4, "opened");
            pstm.setTimestamp(5, today);
            pstm.execute();

            ResultSet rs = pstm.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }   
            System.out.println("Inserted record's ID: " + generatedKey);
            pstm.close();
            
            for(int n=0;n<productList.size();n++){
                sql = "insert into order_product(order_id, product_id) values(?,?)";
                pstm = connection.prepareStatement(sql);
                pstm.setInt(1, generatedKey);
                pstm.setInt(2, productList.get(n).getProduct_id());
                pstm.execute();
                pstm.close();
            }
            

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
    }
    
    public ArrayList<Order> listOrders() {
        String sql = "select * from orders";
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setUser_id(rs.getInt("user_id"));
                // order.setCreated_at(rs.getString("created_at"));
                // order.setClosed_at(rs.getString("closed_at"));
                order.setOrder_status(rs.getString("order_status"));
                // order.setOrder_amount(rs.getInt("order_amount"));
                order.setOrder_id(rs.getInt("order_id"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setOrder_total(rs.getFloat("order_total"));

                list.add(order);
            }

            return list;

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
            return null;
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return null;
        }
    }
}
