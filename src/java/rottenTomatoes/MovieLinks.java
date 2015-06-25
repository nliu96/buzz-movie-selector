/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.annotation.Generated;

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

    public String getSelf() {
        return self;
    }

    public String getAlternate() {
        return alternate;
    }

    public String getCast() {
        return cast;
    }

    public String getSimilar() {
        return similar;
    }

    public String getReviews() {
        return reviews;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setClips(String clips) {
        this.clips = clips;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }
    
    
}