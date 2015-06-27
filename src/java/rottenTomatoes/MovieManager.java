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
         
        public static MovieManager getFromFile(String filename) {
         MovieManager um = null;
         try {
             /*
              * Create the input stream.  Since we want to read from the disk, 
              * we wrap a file stream.
              */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            /*
             * Now we can read the entire company in with only one call
             */
            um = (MovieManager) in.readObject();
            
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Load file not found: " + filename, e);
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on loading: " + filename, e);
        } catch (ClassNotFoundException e) {
            myLogger.log(Level.SEVERE, "Company class not found on loading: " + filename, e);
        }
        return um;
     }
}
