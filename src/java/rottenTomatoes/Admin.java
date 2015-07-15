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
    
    /**
     *
     */
    public Admin() {
        UserManager.getInstance().loadBinary();
        MovieManager.getInstance().loadBinary();
    }
    
    /**
     *
     */
    public void loadUserList() {
        List<UserData> users = new ArrayList<UserData>(UserManager.getInstance().getUsers().values());
        this.users = users;
    }
    
    /**
     *
     * @return
     */
    public String login() {
        loadUserList();
        System.out.println("Admin login");
        return "admin.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    /**
     *
     * @return
     */
    public List<UserData> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<UserData> users) {
        this.users = users;
    }
}