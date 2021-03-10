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
public class User {
    private int user_id;
    private String user_name;
    private String user_login;
    private String user_password;
    private String user_mail;
    private String user_role;
    
    public User(){
    }
    
    public User(int id, String name, String login, String password, String mail, String role) {
        this.user_id = id;
        this.user_name = name;
        this.user_login = login;
        this.user_password = password;
        this.user_mail = mail;
        this.user_role = role;
    }
    
    @Override
    public String toString() {
        String resposta = this.getUser_id() + "\n";
        resposta += this.getUser_name()     + "\n";
        resposta += this.getUser_login()    + "\n";
        resposta += this.getUser_password() + "\n";
        resposta += this.getUser_mail()     + "\n";
        resposta += this.getUser_role()     + "\n";
        return resposta;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
    
    
}
