package rottenTomatoes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import rottenTomatoes.Movie;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static MovieManager instance = new MovieManager();
    
    public static MovieManager getInstance() { return instance; }
    
    private Map<String, Movie> movies = new HashMap<>();
    private Movie currentMovie;
    private static Logger myLogger = Logger.getLogger("example.Company");
    
    public MovieManager() {
        System.out.println("Creating Movie Manager");
    }
    
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    
    public Map getMovies() {
        return movies;
    }
    
    public void addMovie(String id, Movie movie) {
        movies.put(id, movie);
    }
    
    public void editMovieData(String id, Movie movie) {
        movies.put(id, movie);
    }
    
    public Movie find(String title) {
        return movies.get(title);
    }
    
    public List<Movie> getRecommendations(String major) {
        List<Movie> recommendations = new ArrayList<Movie>();
        for(Movie movie: movies.values()) {
            if(movie.ratingByMajor(major) > 3) {
                recommendations.add(movie);
            }
        }
        return recommendations;
    }
    
    public void saveBinary() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("movieData.txt"));
            os.writeObject(movies);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("movieData.txt"));
            movies = (Map<String, Movie>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
