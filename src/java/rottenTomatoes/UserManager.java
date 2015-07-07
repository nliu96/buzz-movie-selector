package rottenTomatoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robertwaters
 */
@ManagedBean (name = "userManager")
@ApplicationScoped
public class UserManager implements Serializable{
    private static UserManager instance = new UserManager();
    
    public static UserManager getInstance() { return instance; }
    
    
    private Map<String, UserData> users = new HashMap<>();
    
    private static Logger myLogger = Logger.getLogger("example.Company");
    
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
    
    public void saveBinary() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("userData.txt"));
            os.writeObject(users);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("userData.txt"));
            users = (Map<String, UserData>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserData find(String username) {
       System.out.println("Looking up user: " + username);
       return users.get(username);
    }

    public Map getUsers() {
        return users;
    }
    
    public void setUsers(Map users) {
        this.users = users;
    }
}