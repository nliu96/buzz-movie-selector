/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nick
 */
@ManagedBean
@SessionScoped
public class Admin implements Serializable {
    List<UserData> users = new ArrayList<UserData>();
    
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    @ManagedProperty("#{movieManager}")
    private MovieManager movieManager;
    
    public Admin() {
        userManager = userManager.getFromFile("userData.txt");
        movieManager = movieManager.getFromFile("movieData.txt");
        loadUserList();
    }
    
    public void loadUserList() {
        List<UserData> users = new ArrayList<UserData>(userManager.getUsers().values());
        this.users = users;
    }
    
    public String login() {
        return "admin.xhtml?faces-redirect=true";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public List<UserData> getUsers() {
        return users;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public void setUsers(List<UserData> users) {
        this.users = users;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }
}