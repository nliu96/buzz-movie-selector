package rottenTomatoes;

import java.io.FileInputStream;
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
    
    /**
     *
     * @return the instance of a movie manager
     */
    public static MovieManager getInstance() {
        return instance;
    }
    
    private Map<String, Movie> movies = new HashMap<>();
    private Movie currentMovie;
    /**
     * Movie Manager constructor
     */
    public MovieManager() {
        System.out.println("Creating Movie Manager");
    }
    
    /**
     * Getter for current movie
     * @return current movie
     */
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    
    /**
     *
     * @return Map of movies
     */
    public Map getMovies() {
        return movies;
    }
    
    /**
     *
     * @param id
     * @param movie
     */
    public void addMovie(String id, Movie movie) {
        movies.put(id, movie);
    }
    
    /**
     *
     * @param id
     * @param movie
     */
    public void editMovieData(String id, Movie movie) {
        movies.put(id, movie);
    }
    
    /**
     *
     * @param title
     * @return
     */
    public Movie find(String title) {
        return movies.get(title);
    }
    
    /**
     *
     * @param major
     * @return
     */
    public List<Movie> getRecommendations(String major) {
        List<Movie> recommendations = new ArrayList<Movie>();
        for (Movie movie: movies.values()) {
            if (movie.ratingByMajor(major) > 3) {
                recommendations.add(movie);
            }
        }
        return recommendations;
    }
    
    /**
     * saves movie data
     */
    public void saveBinary() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("movieData.txt"));
            os.writeObject(movies);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * loads movie data
     */
    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("movieData.txt"));
            movies = (Map<String, Movie>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.
                    getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }
}
