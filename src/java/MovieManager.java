import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import rottenTomatoes.Movie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author theaz_000
 */
@ManagedBean (name = "movieManager")
@ApplicationScoped
public class MovieManager implements Serializable {
    
    private Map<String, Movie> movies = new HashMap<>();
    private Movie currentMovie;
    
    public MovieManager() {
        System.out.println("Creating Movie Manager");
    }
    
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    
    public void addMovie(String title, Movie movie) {
        movies.put(title, movie);
    }
    
    public void editMovieData(String title, Movie movie) {
        movies.put(title, movie);
    }
    
    public String viewDetails(String title, Movie movie) {
        if(!movies.containsKey(title)) {
            addMovie(title, movie);
        }
        currentMovie = movie;
        return "movieInfo.xthml?faces-redirect=true";
    }
    
    public Movie find(String title) {
        return movies.get(title);
    }
}
