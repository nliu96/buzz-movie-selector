package rottenTomatoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
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
    
    public UserData(String em, String n, String usnm, String ps) {
        email = em;
        name = n;
        username = usnm;
        password = ps;
        major = "None";
        interests = "None";
        status = true;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public void setEmail(String em) {
        email = em;
    }
    
    public void setUsername(String un) {
        username = un;
    }
    
    public void setMajor(String m) {
        major = m;
    }
    
    public void setPassword(String pw) {
        password = pw;
    }
    
    public void setInterests(String i) {
        interests = i;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }
    
    public String getInterests() {
        return interests;
    }
    
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean checkLogin(String p) {
        return p.equals(password);
    }
    
    public String toggleLock() {
        status = !status;
        return "admin?faces-redirect=true";
    }
}
