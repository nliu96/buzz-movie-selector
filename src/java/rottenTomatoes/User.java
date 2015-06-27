package rottenTomatoes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Nick Liu
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
    private List<Movie> recommendations = new ArrayList<Movie>();
    
    private String searchTerm;
    private Movie currentMovie;
    private int userRating;
    
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    @ManagedProperty("#{movieManager}")
    private MovieManager movieManager;
    @ManagedProperty("#{search}")
    private Search search;

    public void setRecommendations(List<Movie> recommendations) {
        this.recommendations = recommendations;
    }

    public List<Movie> getRecommendations() {
        return recommendations;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public UserData getData() {
        return data;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public UserManager getUserManager() {
        return userManager;
    }
    
    /**
     * Creates a new instance of User
     */
    public User() {
        userManager = userManager.getFromFile("userData.txt");
        movieManager = movieManager.getFromFile("movieData.txt");
        System.out.println("Making user");
    }
    
    /**
     * Get user's email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Get user's name
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get user's username
     * @return username
     */
    public String getUsername() { 
        return username;
    }
    
    /**
     * Get new username
     * @return newUsername
     */
    public String getNewUsername() {
        return newUsername;
    }
    
    /**
     * Get password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Get new password
     * @return newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }
    
    /**
     * Get student's major
     * @return major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Get student's interest
     * @return 
     */
    public String getInterests() {
        return interests;
    }
    
    /**
     * Get search term
     * @return 
     */
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
        if (!data.getStatus()) {
            System.out.println("Account is locked");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Account is locked"));
            return null;
        }
        System.out.println("Login Success");
        setData(username);
        return "welcome.xhtml?faces-redirect=true";
    }   

    public String logOut() {
        userManager.save("userData.txt");
        movieManager.save("movieData.txt");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
    
    public List<Movie> getSearchResults() {
        return searchResults;
    }
    
    public String searchMovies() {
        searchResults = search.getSearchResults(searchTerm);
        return "searchResults.xhtml?faces-redirect=true";
    }
    
    public String viewDetails(String id, Movie movie) {
        if(!movieManager.getMovies().containsKey(id)) {
            movieManager.addMovie(movie.getId(), movie);
        }
        currentMovie = movieManager.find(movie.getId());
        if(currentMovie.getUserRatings().containsKey(username)) {
            UserRating movieRating = (UserRating) currentMovie.getUserRatings().get(username);
            userRating  = movieRating.getRating();
            System.out.println("success");
        } else {
            userRating = 3;
        }
        return "movieInfo";
    }
    
    public void addRating() {
        System.out.println(userRating);
        currentMovie.addRating(username, new UserRating(userRating, data));
        UserRating lol = (UserRating) currentMovie.getUserRatings().get(username);
        System.out.println(lol.getRating());
    }
    
    public String recommend() {
        recommendations = movieManager.getRecommendations(major);
        return "recommendations.xhtml?faces-redirect=true   ";
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
