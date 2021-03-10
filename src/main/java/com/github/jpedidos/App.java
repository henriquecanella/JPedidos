package com.github.jpedidos;

import Utils.JDBCUtil;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class App {
        private static final String path = System.getProperty("user.dir");
        private static final File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");
        private static Connection connection = null;
        
	public static void main(String[] args) {
            try {
                System.out.println(config_file);
                
                
                JDBCUtil.init(config_file);
                
                connection = JDBCUtil.getConnection();
                connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.

                DatabaseMetaData dbmt = connection.getMetaData();
                System.out.println("Nome do BD: " + dbmt.getDatabaseProductName());
                System.out.println("Versao do BD: " + dbmt.getDatabaseProductVersion());
                System.out.println("URL: " + dbmt.getURL());
                System.out.println("Driver: " + dbmt.getDriverName());
                System.out.println("Versao Driver: " + dbmt.getDriverVersion());
                System.out.println("Usuario: " + dbmt.getUserName());
            } catch (ClassNotFoundException erro) {
                System.out.println("Falha ao carregar o driver JDBC." + erro);
            } catch (IOException erro) {
                System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            } catch (SQLException erro) {
                System.out.println("Falha na conexao, comando sql = " + erro);
            }
	}
}
