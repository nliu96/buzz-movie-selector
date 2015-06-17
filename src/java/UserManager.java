/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author robertwaters
 */
@ManagedBean (name = "userManager")
@ApplicationScoped
public class UserManager {
    
    private Map<String, UserData> users = new HashMap<>();
    
    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
        System.out.println("Creating User Manager");
        makeSomeUsers();
    }

    private void makeSomeUsers() {
        users.put("user", new UserData("nliu41@gatech.edu", "Admin", "user", "pass"));
    }
    
    public void addUser(String oldName, String newName) {
        UserData data = users.get(oldName);
        users.remove(oldName);
        users.put(newName, data);   
    }
    
    public void addUser(String email, String name, String username, String password) {
        users.put(username, new UserData(email, name, username, password));
    }
    
    public void editUserData(String username, UserData data) {
        users.remove(username);
        users.put(username, data);
    }

    UserData find(String username) {
       System.out.println("Looking up user: " + username);
       return users.get(username);
    }
  
}