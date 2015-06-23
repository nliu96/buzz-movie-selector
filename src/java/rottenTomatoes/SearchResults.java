package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

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

    public String getTotal() {
        return total;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public SearchLink getLinks() {
        return links;
    }

    public String getLink_Template() {
        return link_Template;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setLinks(SearchLink links) {
        this.links = links;
    }

    public void setLink_Template(String link_Template) {
        this.link_Template = link_Template;
    }
    
    
}