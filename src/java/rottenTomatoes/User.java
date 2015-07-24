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
    private String comments;
    
    private List<Movie> searchResults = new ArrayList<Movie>();
    private List<Movie> recommendations = new ArrayList<Movie>();
    
    private String searchTerm;
    private Movie currentMovie;
    private int userRating;
    
    @ManagedProperty("#{search}")
    private Search search;

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public String addComment() {
        currentMovie.addComments(username + ": " + comments);
        return "movieInfo";
    }
    
    /**
     *
     * @param recommendations
     */
    public void setRecommendations(List<Movie> recommendations) {
        this.recommendations = recommendations;
    }

    /**
     *
     * @return recommendations based on current major
     */
    public List<Movie> getRecommendations() {
        return recommendations;
    }

    /**
     *
     * @param userRating
     */
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    /**
     *
     * @return user rating
     */
    public int getUserRating() {
        return userRating;
    }

    /**
     *
     * @param data
     */
    public void setData(UserData data) {
        this.data = data;
    }

    /**
     *
     * @param currentMovie
     */
    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    /**
     *
     * @return userdata
     */
    public UserData getData() {
        return data;
    }

    /**
     *
     * @return currently selected movie
     */
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    
    /**
     * Creates a new instance of User
     */
    public User() {
        UserManager.getInstance().loadBinary();
        MovieManager.getInstance().loadBinary();
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
    
    /**
     * 
     * @return get search object
     */
    public Search getSearch() {
        return search;
    }
    
    /**
     *
     * @param u username
     */
    public void setUsername(String u) {
        System.out.println("Setting username to " + u);
        username = u;
    }
    
    /**
     *
     * @param p password
     */
    public void setPassword(String p) {
        System.out.println("Setting password to " + p);
        password = p;
    }
    
    /**
     *
     * @param np new password
     */
    public void setNewPassword(String np) {
        newPassword = np;
    }
    
    /**
     *
     * @param nun new username
     */
    public void setNewUsername(String nun) {
        newUsername = nun;
    }
    
    /**
     *
     * @param n name
     */
    public void setName(String n) {
        System.out.println("Setting name to " + n);
        name = n;
    }
    
    /**
     *
     * @param em email
     */
    public void setEmail(String em) {
        System.out.println("Setting email to " + em);
        email = em;
    }
    
    /**
     *
     * @param i interest
     */
    public void setInterests(String i) {
        interests = i;
    }
    
    /**
     *
     * @param m major
     */
    public void setMajor(String m) {
        major = m;
    }
   
    /**
     *
     * @param st search term
     */
    public void setSearchTerm(String st) {
        searchTerm = st;
    }
    
    /**
     *
     * @param searchResults
     */
    public void setSearchResults(List<Movie> searchResults) {
        this.searchResults = searchResults;
    }
        
    /**
     *
     * @param username
     */
    public void setData(String username) {
        this.data = UserManager.getInstance().find(username);
        setMajor(data.getMajor());
        setName(data.getName());
        setEmail(data.getEmail());
        setInterests(data.getInterests());
    }
    
    /**
     *
     * @return profile page
     */
    public String editPassword() {
        setPassword(newPassword);
        data.setPassword(newPassword);
        return "profile.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return profile page
     */
    public String editUsername() {
        UserManager.getInstance().addUser(username, newUsername);
        setUsername(newUsername);
        data.setUsername(newUsername);
        return "profile.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return profile pages
     */
    public String editProfile() {
        UserData ud = UserManager.getInstance().find(username);
        ud.setEmail(email);
        ud.setName(name);
        ud.setMajor(major);
        ud.setInterests(interests);
        return "profile.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return profile page
     */
    public String cancelChanges() {
        setData(username);
        return "profile.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return page to be directed to
     */
    public String login() {
        System.out.println("Doing some business logic here");
        UserData data = UserManager.getInstance().find(username);
        if (data == null || !data.checkLogin(password)) {
            username = "";
            password = "";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,
                    new FacesMessage("Username or Password incorrect"));
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

    /**
     *
     * @return welcome page
     */
    public String logOut() {
        UserManager.getInstance().saveBinary();
        MovieManager.getInstance().saveBinary();
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return search results
     */
    public List<Movie> getSearchResults() {
        return searchResults;
    }
    
    /**
     * search movie using search term
     * @return search results page
     */
    public String searchMovies() {
        searchResults = search.getSearchResults(searchTerm);
        return "searchResults.xhtml?faces-redirect=true";
    }
    
    /**
     * add movie if not in database and go to page with movie details
     * @param id
     * @param movie
     * @return movie info page
     */
    public String viewDetails(String id, Movie movie) {
        if (!MovieManager.getInstance().getMovies().containsKey(id)) {
            MovieManager.getInstance().addMovie(movie.getId(), movie);
        }
        currentMovie = MovieManager.getInstance().find(movie.getId());
        if (currentMovie.getUserRatings().containsKey(username)) {
            UserRating movieRating =
                    (UserRating) currentMovie.getUserRatings().get(username);
            userRating  = movieRating.getRating();
            System.out.println("success");
        } else {
            userRating = 3;
        }
        return "movieInfo";
    }
    
    /**
     * add rating to moviemanager
     */
    public void addRating() {
        System.out.println(userRating);
        currentMovie.addRating(username, new UserRating(userRating, data));
        UserRating lol = (UserRating)
                currentMovie.getUserRatings().get(username);
        System.out.println(lol.getRating());
    }
    
    /**
     * get recommendations based on major
     * @return Recommendations page
     */
    public String recommend() {
        recommendations = MovieManager.getInstance().getRecommendations(major);
        return "recommendations.xhtml?faces-redirect=true   ";
    }
    
    /**
     * get new movies
     * @return new movies list
     */
    public String getNewMovieList() {
        return search.getNewMovieList();
    }
    
    /**
     *
     * @return new DVD's list
     */
    public String getNewDvdList() {
        return search.getNewDvdList();
    }
    
    /**
     *
     * @param search
     */
    public void setSearch(Search search) {
        this.search = search;
    }
    
    /**
     * Add new user to user manager
     * @return welcome page
     */
    public String register() {
        UserManager.getInstance().addUser(email, name, username, password);
        return "index.xhtml?faces-redirect=true";
    }
}
