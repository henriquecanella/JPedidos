/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
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
 * @author lucas
 */
public class UserDAO {

    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection connection = null;

    ArrayList<User> list = new ArrayList<>();

    public ResultSet userAuth(User user) {
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            String sql = "select * from users where user_login = ? and user_password = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUser_login());
            pstm.setString(2, user.getUser_password());

            ResultSet rs = pstm.executeQuery();

            return rs;

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

    public void createUser(User user) {
        String sql = "insert into users (user_name, user_login, user_password, user_email, user_role) values(?,?,?,?,?)";

        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUser_name());
            pstm.setString(2, user.getUser_login());
            pstm.setString(3, user.getUser_password());
            pstm.setString(4, user.getUser_mail());
            pstm.setString(5, user.getUser_role());

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

    public ArrayList<User> listUsers() {
        String sql = "select * from users";
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_login(rs.getString("user_login"));
                user.setUser_mail(rs.getString("user_email"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_role(rs.getString("user_role"));

                list.add(user);
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

    public void alterarUser(User user) {
        String sql = "update users set user_name = ?, user_login = ?, user_password = ?, user_email = ?, user_role = ? where user_id = ?";
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUser_name());
            pstm.setString(2, user.getUser_login());
            pstm.setString(3, user.getUser_password());
            pstm.setString(4, user.getUser_mail());
            pstm.setString(5, user.getUser_role());
            pstm.setInt(6, user.getUser_id());

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

    public void deleteUser(User user) {
        String sql = "delete from users where user_id = ?";
        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, user.getUser_id());

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

    public boolean checkIfEmailExists(String email) {
        ArrayList<Models.User> usersList = this.listUsers();

        if (usersList.size() <= 0) {
            return false;
        }
        
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUser_mail().equals(email)) {
                return true;
            }
        }

        usersList.clear();
        return false;
    }
    
    public boolean checkIfLoginExists(String login) {
        ArrayList<Models.User> usersList = this.listUsers();

        if (usersList.size() <= 0) {
            return false;
        }
        
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUser_login().equals(login)) {
                return true;
            }
        }

        usersList.clear();
        return false;
    }
}
