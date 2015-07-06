package rottenTomatoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 * Create a userdata object
 * @author Nick Liu
 */
public class UserData implements Serializable{
    private String name;
    private String username;
    private String password;
    private String email;
    private String major;
    private String interests;
    private boolean status;
    
    /**
     * Initialize user data object
     * @param em    Email
     * @param n     name
     * @param usnm  username
     * @param ps    password
     */
    public UserData(String em, String n, String usnm, String ps) {
        email = em;
        name = n;
        username = usnm;
        password = ps;
        major = "None";
        interests = "None";
        status = true;
    }
    
    /**
     * 
     * @param n name
     */
    public void setName(String n) {
        name = n;
    }
    
    /**
     * 
     * @param em email
     */
    public void setEmail(String em) {
        email = em;
    }
    
    /**
     * 
     * @param un username
     */
    public void setUsername(String un) {
        username = un;
    }
    
    /**
     * 
     * @param m major
     */
    public void setMajor(String m) {
        major = m;
    }
    
    /**
     * 
     * @param pw password
     */
    public void setPassword(String pw) {
        password = pw;
    }
    
    /**
     * 
     * @param i interests
     */
    public void setInterests(String i) {
        interests = i;
    }
    
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @return major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * 
     * @return interests
     */
    public String getInterests() {
        return interests;
    }
    
    /**
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * 
     * @return status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * 
     * @param status status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * Checks if entered password is same as stored password
     * @param p
     * @return if attempted login and password are equal
     */
    public boolean checkLogin(String p) {
        return p.equals(password);
    }
    
    /**
     * Change status of user
     * @return admin page
     */
    public String toggleLock() {
        status = !status;
        return "admin?faces-redirect=true";
    }
}
