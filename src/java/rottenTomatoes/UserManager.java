package rottenTomatoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
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
public class UserManager implements Serializable {
    private static UserManager instance = new UserManager();
    
    /**
     *
     * @return Instance of usermanager
     */
    public static UserManager getInstance() {
        return instance;
    }
    
    
    private Map<String, UserData> users = new HashMap<>();
    
    
    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
        System.out.println("Creating User Manager");
        makeSomeUsers();
    }

    private void makeSomeUsers() {
        users.put("user", new UserData("nliu41@gatech.edu",
                "Admin", "user", "pass"));
    }
    
    /**
     * Change name for certain user
     * @param oldName old username
     * @param newName new username
     */
    public void addUser(String oldName, String newName) {
        UserData data = users.get(oldName);
        users.remove(oldName);
        users.put(newName, data);   
    }
    
    /**
     * Add new user
     * @param email
     * @param name
     * @param username
     * @param password
     */
    public void addUser(String email, String name,
            String username, String password) {
        users.put(username, new UserData(email, name, username, password));
    }
    
    /**
     * Edit user's data
     * @param username username
     * @param data new userdata
     */
    public void editUserData(String username, UserData data) {
        users.remove(username);
        users.put(username, data);
    }
    
    /**
     * Save data of application
     */
    public void saveBinary() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("userData.txt"));
            os.writeObject(users);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *  Load data of application
     */
    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("userData.txt"));
            users = (Map<String, UserData>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * find a certain user with their username
     * @param username
     * @return
     */
    public UserData find(String username) {
       System.out.println("Looking up user: " + username);
       return users.get(username);
    }

    /**
     * 
     * @return map of users
     */
    public Map getUsers() {
        return users;
    }
    
    /**
     * Set users
     * @param users
     */
    public void setUsers(Map users) {
        this.users = users;
    }
}