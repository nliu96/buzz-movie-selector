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
    private String address;
    
    UserData(String em, String n, String usnm, String ps) {
        email = em;
        name = n;
        username = usnm;
        password = ps;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    boolean checkLogin(String p) {
        return p.equals(password);
    }
    
}
