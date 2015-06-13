/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author robertwaters
 */
@ManagedBean
@SessionScoped
public class User implements Serializable {
    private String email;
    private String name;
    private String username;
    private String password;
    private UserData data;
    private String major;
    private String interests;
    
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    
    
    /**
     * Creates a new instance of User
     */
    public User() {
        System.out.println("Making user");
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() { 
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getMajor() {
        return major;
    }
    
    public void setUsername(String u) {
        System.out.println("Setting username to " + u);
        username = u;
    }
    
    public void setPassword(String p) {
        System.out.println("Setting password to " + p);
        password = p;
    }
    
    public void setName(String n) {
        System.out.println("Setting name to " + n);
        name = n;
    }
    
    public void setEmail(String em) {
        System.out.println("Setting email to " + em);
        email = em;
    }
    
    public void setInterests(String i) {
        interests = i;
    }
    
        public void setMajor(String m) {
        major = m;
    }
        
    public void setData(String username) {
        UserData ud = userManager.find(username);
        setMajor(ud.getMajor());
        setName(ud.getName());
        setEmail(ud.getEmail());
        setInterests(ud.getInterests());
    }
    
    public void editProfile() {
        
    }
    
    
    public String login() {
        System.out.println("Doing some business logic here");
        UserData data = userManager.find(username);
        if (data == null || !data.checkLogin(password)) {
            username="";
            password="";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username or Password incorrect"));
            return null;
        }
        System.out.println("Login Success");
        setData(username);
        return "welcome.xhtml";
    }

    
    public void setUserManager(UserManager um) {
        userManager = um;
    }
    
    public String register() {
        userManager.addUser(email, name, username, password);
        return "welcome.xhtml";
    }

}
