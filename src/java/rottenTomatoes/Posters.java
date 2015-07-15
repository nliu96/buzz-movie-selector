/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import java.io.Serializable;

/**
 *
 * @author theaz_000
 */
public class Posters implements Serializable {
    private String thumbnail;
    private String profile;
    private String detailed;
    private String original;

    /**
     * Getter for thumbnail
     * @return thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Getter for profile
     * @return profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * 
     * @return details
     */
    public String getDetailed() {
        return detailed;
    }

    /**
     * 
     * @return original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * 
     * @param thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @param profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     *
     * @param detailed
     */
    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    /**
     *
     * @param original
     */
    public void setOriginal(String original) {
        this.original = original;
    }
    
}
