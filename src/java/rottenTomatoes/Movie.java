package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class Movie implements Serializable {
    @Expose
    private String id;
    
    @Expose
    private String title;
    
    @Expose
    private String year;
    
    @Expose
    private List<String> genres = new ArrayList<String>();
    
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
    private List<AbridgedDirectors> abridged_directors
            = new ArrayList<AbridgedDirectors>();
    
    @Expose
    private String studio;
    
    @Expose
    private AlternateIds alternate_ids;
    
    @Expose
    private MovieLinks links;
    
    private Map<String, UserRating> userRatings = new HashMap<>();

    /**
     * Getter method for a movie Id
     * @return id for the movie
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method for a movie title
     * @return title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the year a movie was produced
     * @return year movie was made
     */
    public String getYear() {
        return year;
    }

    /**
     * Getter method for the list of genres for the movie
     * @return list of different genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Get rating
     * @return rating
     */
    public String getMpaa_rating() {
        return mpaa_rating;
    }

    /**
     * Getter method for the movie runtime
     * @return runtime
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * Getter method for the consensus of critics
     * @return critics consensus
     */
    public String getCritics_concensus() {
        return critics_concensus;
    }

    /**
     * Getter method for release date for the movie
     * @return release date
     */
    public ReleaseDates getRelease_dates() {
        return release_dates;
    }

    /**
     * Getter method for movie ratings
     * @return ratings
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * Getter method for movie's synopsis
     * @return synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Getter method for movie's posters
     * @return posters
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     * Getter method for list of abridged cast
     * @return abridged cast
     */
    public List<AbridgedCast> getAbridged_cast() {
        return abridged_cast;
    }

    /**
     * Getter method for list of abridged directors
     * @return abridge directors
     */
    public List<AbridgedDirectors> getAbridged_directors() {
        return abridged_directors;
    }

    /**
     * 
     * @return movie's studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     *
     * @return alternate Id's
     */
    public AlternateIds getAlternate_ids() {
        return alternate_ids;
    }

    /**
     *
     * @return links to the movie
     */
    public MovieLinks getLinks() {
        return links;
    }

    /**
     *
     * @return the user ratings from the site
     */
    public Map getUserRatings() {
        return userRatings;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @param genres
     */
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     *
     * @param mpaa_rating
     */
    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    /**
     *
     * @param runtime
     */
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    /**
     *
     * @param critics_concensus
     */
    public void setCritics_concensus(String critics_concensus) {
        this.critics_concensus = critics_concensus;
    }

    /**
     *
     * @param release_dates
     */
    public void setRelease_dates(ReleaseDates release_dates) {
        this.release_dates = release_dates;
    }

    /**
     *
     * @param ratings
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    /**
     *
     * @param synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     *
     * @param posters
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    /**
     *
     * @param abridged_cast
     */
    public void setAbridged_cast(
            ArrayList<AbridgedCast> abridged_cast) {
        this.abridged_cast = abridged_cast;
    }

    /**
     *
     * @param abridged_directors
     */
    public void setAbridged_directors(
            ArrayList<AbridgedDirectors> abridged_directors) {
        this.abridged_directors = abridged_directors;
    }

    /**
     *
     * @param studio
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     *
     * @param alternate_ids
     */
    public void setAlternate_ids(AlternateIds alternate_ids) {
        this.alternate_ids = alternate_ids;
    }

    /**
     *
     * @param links
     */
    public void setLinks(MovieLinks links) {
        this.links = links;
    }

    /**
     *
     * @param genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     *
     * @param abridged_cast
     */
    public void setAbridged_cast(List<AbridgedCast> abridged_cast) {
        this.abridged_cast = abridged_cast;
    }

    /**
     *
     * @param abridged_directors
     */
    public void setAbridged_directors(List<AbridgedDirectors>
            abridged_directors) {
        this.abridged_directors = abridged_directors;
    }

    /**
     *
     * @param userRatings
     */
    public void setUserRatings(Map userRatings) {
        this.userRatings = userRatings;
    }    
    
    /**
     *
     * @param username
     * @param rating
     */
    public void addRating(String username, UserRating rating) {
        userRatings.put(username, rating);
    }
    
    /**
     * Returns the movie ratings by a certain major
     * @param major
     * @return
     */
    public int ratingByMajor(String major) {
        int rateMajor = 0;
        int count = 0;
        for (UserRating rates : userRatings.values()) {
            if (rates.getMajor().equals(major)) {
                rateMajor += rates.getRating();
                count++;
            }
        }
        if (count == 0) {
            return 3;
        }
        rateMajor = rateMajor / count;
        return rateMajor;
    }
}
