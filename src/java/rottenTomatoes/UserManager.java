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
    
     public void save(String filename) {
         try {
             /*
              * Create the object output stream for serialization.
              * We are wrapping a FileOutputStream since we
              * want to save to disk.  You can also save to socket
              * streams or any other kind of stream.
              */
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            
            /*
             * The only real call we need.  The stream buffers the output and reuses
             * data, so if you are serializing very frequently, then the object values might
             * not actually change because the old serialized object is being reused.
             * 
             * To fix this you can try writeUnshared() or you can reset the stream.
             * out.reset();
             */
            out.writeObject(this);
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Save file not found: " + filename, e);
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on saving: " + filename, e);
        }
         
     }
     
    public static UserManager getFromFile(String filename) {
         UserManager um = null;
         try {
             /*
              * Create the input stream.  Since we want to read from the disk, 
              * we wrap a file stream.
              */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            /*
             * Now we can read the entire company in with only one call
             */
            um = (UserManager) in.readObject();
            
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Load file not found: " + filename, e);
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on loading: " + filename, e);
        } catch (ClassNotFoundException e) {
            myLogger.log(Level.SEVERE, "Company class not found on loading: " + filename, e);
        }
        return um;
     }

    public UserData find(String username) {
       System.out.println("Looking up user: " + username);
       return users.get(username);
    }
  
}