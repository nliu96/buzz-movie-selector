/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robertwaters
 */
class UserData {
    private String name;
    private String username;
    private String password;
    private String email;
    private String major;
    private String interests;
    
    public UserData(String em, String n, String usnm, String ps) {
        email = em;
        name = n;
        username = usnm;
        password = ps;
        major = "Select One";
        interests = "None";
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
    
    boolean checkLogin(String p) {
        return p.equals(password);
    }
}
