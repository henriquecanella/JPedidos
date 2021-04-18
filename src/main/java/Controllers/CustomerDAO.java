/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Customer;
import Utils.JDBCUtil;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public class CustomerDAO {
    
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection connection = null;
    
    ArrayList<Customer> list = new ArrayList<>();
    
    public void CreateCustomer (Customer customer) {
        String sql = "INSERT INTO customers (customer_name, customer_phone, customer_address) VALUES (?,?,?)";
    
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, customer.getCustomer_name());
            pstm.setString(2, customer.getCustomer_phone());
            pstm.setString(3, customer.getCustomer_address());
            
            pstm.execute();
            pstm.close();
            
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
    }
    
    public ArrayList<Customer> listCustomers() {
        String sql = "select * from customers";
        
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setCustomer_phone(rs.getString("customer_phone"));
                customer.setCustomer_address(rs.getString("customer_address"));
                
                list.add(customer);
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
    
    public void updateCustomer(Customer customer) {
        String sql = "update customers set customer_name = ?, customer_phone = ?, customer_address = ? where customer_id = ?";
    
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, customer.getCustomer_name());
            pstm.setString(2, customer.getCustomer_phone());
            pstm.setString(3, customer.getCustomer_address());
            
            pstm.execute();
            pstm.close();
            
            
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
    
    }
    
    public void deleteCustomer(Customer customer) {
        String sql = "delete from customers where customer_id = ?";
        
        try {     
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, customer.getCustomer_id());
            
            pstm.execute();
            pstm.close();
            
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
    }
}
