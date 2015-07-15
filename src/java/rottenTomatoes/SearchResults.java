package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

/**
 *
 * @author dylanfloyd
 */
@Generated("org.jsonschema2pojo")
/**
 *
 * @author theaz_000
 */
public class SearchResults {
    @Expose
    private String total;
    
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();
    
    @Expose
    private SearchLink links;
    
    @Expose
    private String link_Template;

    /**
     * Getter method for number of results
     * @return total
     */
    public String getTotal() {
        return total;
    }

    /**
     *
     * @return movie search results
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     *
     * @return links form search results
     */
    public SearchLink getLinks() {
        return links;
    }

    /**
     *
     * @return movie link template
     */
    public String getLink_Template() {
        return link_Template;
    }

    /**
     *
     * @param total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     *
     * @param movies
     */
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     *
     * @param links
     */
    public void setLinks(SearchLink links) {
        this.links = links;
    }

    /**
     *
     * @param link_Template
     */
    public void setLink_Template(String link_Template) {
        this.link_Template = link_Template;
    }
    
    
}