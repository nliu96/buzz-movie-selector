/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
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
public class MovieLinks implements Serializable {
    @Expose
    private String self;
    
    @Expose
    private String alternate;
    
    @Expose
    private String cast;
    
    @Expose
    private String clips;
    
    @Expose
    private String reviews;
    
    @Expose
    private String similar;

    /**
     *
     * @return
     */
    public String getSelf() {
        return self;
    }

    /**
     *
     * @return
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     *
     * @return
     */
    public String getCast() {
        return cast;
    }

    /**
     *
     * @return
     */
    public String getSimilar() {
        return similar;
    }

    /**
     *
     * @return
     */
    public String getReviews() {
        return reviews;
    }

    /**
     *
     * @param self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     *
     * @param alternate
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    /**
     *
     * @param cast
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     *
     * @param clips
     */
    public void setClips(String clips) {
        this.clips = clips;
    }

    /**
     *
     * @param reviews
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     *
     * @param similar
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }
    
    
}