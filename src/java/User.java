/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import rottenTomatoes.*;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robertwaters
 */
@ManagedBean
@SessionScoped
public class User implements Serializable {
    private String email;
    private String name;
    private String username;
    private String password;
    private UserData data;
    private String major;
    private String interests;
    private String newUsername;
    private String newPassword;
    private List<Movie> searchResults = new ArrayList<Movie>();
    private String searchTerm;
    
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    @ManagedProperty("#{movieManager}")
    private MovieManager movieManager;
    @ManagedProperty("#{search}")
    private Search search;
    
    /**
     * Creates a new instance of User
     */
    public User() {
        System.out.println("Making user");
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() { 
        return username;
    }
    
    public String getNewUsername() {
        return newUsername;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getNewPassword() {
        return newPassword;
    }
    
    public String getMajor() {
        return major;
    }
    
    public String getInterests() {
        return interests;
    }
    
    public String getSearchTerm() {
        return searchTerm;
    }
    
    public MovieManager getMovieManager() {
        return movieManager;
    }
    
    public Search getSearch() {
        return search;
    }
    
    public void setUsername(String u) {
        System.out.println("Setting username to " + u);
        username = u;
    }
    
    public void setPassword(String p) {
        System.out.println("Setting password to " + p);
        password = p;
    }
    
    public void setNewPassword(String np) {
        newPassword = np;
    }
    
    public void setNewUsername(String nun) {
        newUsername = nun;
    }
    
    public void setName(String n) {
        System.out.println("Setting name to " + n);
        name = n;
    }
    
    public void setEmail(String em) {
        System.out.println("Setting email to " + em);
        email = em;
    }
    
    public void setInterests(String i) {
        interests = i;
    }
    
    public void setMajor(String m) {
        major = m;
    }
   
    
    public void setSearchTerm(String st) {
        searchTerm = st;
    }
    
    public void setSearchResults(List<Movie> searchResults) {
        this.searchResults = searchResults;
    }
        
    public void setData(String username) {
        this.data = userManager.find(username);
        setMajor(data.getMajor());
        setName(data.getName());
        setEmail(data.getEmail());
        setInterests(data.getInterests());
    }
    
    public String editPassword() {
        setPassword(newPassword);
        data.setPassword(newPassword);
        return "profile.xhtml?faces-redirect=true";
    }
    
    public String editUsername() {
        userManager.addUser(username, newUsername);
        setUsername(newUsername);
        data.setUsername(newUsername);
        return "profile.xhtml?faces-redirect=true";
    }
    
    public String editProfile() {
        UserData ud = userManager.find(username);
        ud.setEmail(email);
        ud.setName(name);
        ud.setMajor(major);
        ud.setInterests(interests);
        return "profile.xhtml?faces-redirect=true";
    }
    
    public String cancelChanges() {
        setData(username);
        return "profile.xhtml?faces-redirect=true";
    }
    
    public String login() {
        System.out.println("Doing some business logic here");
        UserData data = userManager.find(username);
        if (data == null || !data.checkLogin(password)) {
            username="";
            password="";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username or Password incorrect"));
            return null;
        }
        System.out.println("Login Success");
        setData(username);
        return "welcome.xhtml?faces-redirect=true";
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
    
    public String getSearchResults() {
        return search.getSearchResults();
    }
    
    public String getNewMovieList() {
        return search.getNewMovieList();
    }
    
    public String getNewDvdList() {
        return search.getNewDvdList();
    }
    
    public void setUserManager(UserManager um) {
        userManager = um;
    }
    
    public void setMovieManager(MovieManager mm) {
        movieManager = mm;
    }
    
    public void setSearch(Search search) {
        this.search = search;
    }
    
    public String register() {
        userManager.addUser(email, name, username, password);
        return "index.xhtml?faces-redirect=true";
    }
}
