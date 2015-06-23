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
public class Movie {
    @Expose
    private String id;
    
    @Expose
    private String title;
    
    @Expose
    private String year;
    
    @Expose
    private List<String>genres = new ArrayList<String>();
    
    @Expose
    private String mpaa_rating;
    
    @Expose
    private String runtime;
    
    @Expose
    private String critics_concensus;
    
    @Expose
    private ReleaseDates release_dates;
    
    @Expose
    private Ratings ratings;
    
    @Expose
    private String synopsis;
    
    @Expose
    private Posters posters;
    
    @Expose
    private List<AbridgedCast> abridged_cast = new ArrayList<AbridgedCast>();
    
    @Expose
    private List<AbridgedDirectors> abridged_directors = new ArrayList<AbridgedDirectors>();
    
    @Expose
    private String studio;
    
    @Expose
    private AlternateIds alternate_ids;
    
    @Expose
    private MovieLinks links;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getCritics_concensus() {
        return critics_concensus;
    }

    public ReleaseDates getRelease_dates() {
        return release_dates;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Posters getPosters() {
        return posters;
    }

    public List<AbridgedCast> getAbridged_cast() {
        return abridged_cast;
    }

    public List<AbridgedDirectors> getAbridged_directors() {
        return abridged_directors;
    }

    public String getStudio() {
        return studio;
    }

    public AlternateIds getAlternate_ids() {
        return alternate_ids;
    }

    public MovieLinks getLinks() {
        return links;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setCritics_concensus(String critics_concensus) {
        this.critics_concensus = critics_concensus;
    }

    public void setRelease_dates(ReleaseDates release_dates) {
        this.release_dates = release_dates;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    public void setAbridged_cast(ArrayList<AbridgedCast> abridged_cast) {
        this.abridged_cast = abridged_cast;
    }

    public void setAbridged_directors(ArrayList<AbridgedDirectors> abridged_directors) {
        this.abridged_directors = abridged_directors;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setAlternate_ids(AlternateIds alternate_ids) {
        this.alternate_ids = alternate_ids;
    }

    public void setLinks(MovieLinks links) {
        this.links = links;
    }
    
}
