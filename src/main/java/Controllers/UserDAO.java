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

/**
 *
 * @author lucas
 */
public class UserDAO {
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection connection = null;
    
    public ResultSet userAuth(User user){
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
}
