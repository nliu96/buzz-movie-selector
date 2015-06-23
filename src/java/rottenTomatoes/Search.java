package rottenTomatoes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.registry.infomodel.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robertwaters
 */
@ManagedBean
@ApplicationScoped
public class Search {
    private String searchTerm;
    private List<Movie> movies = new ArrayList<Movie>();
    private List<Movie> newMovies = new ArrayList<Movie>();
    private List<Movie> newDvds = new ArrayList<Movie>();
    
    public String getSearchTerm() {
        return searchTerm;
    }
    
    public List getMovies() {
        return movies;
    }
    
    public List getNewMovies() {
        return newMovies;
    }
    
    public List getNewDvds() {
        return newDvds;
    }
    
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setNewMovies(List<Movie> newMovies) {
        this.newMovies = newMovies;
    }

    public void setNewDvds(List<Movie> newDvds) {
        this.newDvds = newDvds;
    }

    protected String getData(String link) {
        URL url = null;
        String data = "";
        try {
                url = new URL(link);
        
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        data+=output;
		}
                System.out.println("Got JSON: " + data);
		conn.disconnect();
                
                } catch (MalformedURLException ex) {
                   Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Cannot open url");
                }

        return data;
        }

    
    public String getSearchResults() {
        System.out.println("Getting the REST data");
        Gson gson = new Gson();
        String link = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=yedukp76ffytfuy24zsqk7f5&q="
                + (searchTerm.replaceAll(" ", "+")) + "&page_limit=5";
        String data = getData(link);
        SearchResults response = gson.fromJson(data, SearchResults.class);
        movies = response.getMovies();
        System.out.println("Returning the temp data");
        return "searchResults.xhtml?faces-redirect=true";
    }
    
    public String getNewDvdList() {
        System.out.println("Getting the REST data");
        Gson gson = new Gson();
        String link = "http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/new_releases.json"
                + "?page_limit=16&page=1&country=us&apikey=yedukp76ffytfuy24zsqk7f5";
        String data = getData(link);
        SearchResults response = gson.fromJson(data, SearchResults.class);
        newDvds = response.getMovies();
        System.out.println("Returning the temp data");
        return "newDvds.xhtml?faces-redirect=true";
    }
    
    public String getNewMovieList() {
        System.out.println("Getting the REST data");
        Gson gson = new Gson();
        String link = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/opening.json"
                + "?limit=16&country=us&apikey=yedukp76ffytfuy24zsqk7f5";
        String data = getData(link);
        SearchResults response = gson.fromJson(data, SearchResults.class);
        newMovies = response.getMovies();
        System.out.println("Returning the temp data");
        return "newMovies.xhtml?faces-redirect=true";
    }
}