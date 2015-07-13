package rottenTomatoes;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author theaz_000
 */
public class UserRating implements Serializable {
    private int rating;
    private UserData user;
    private String major;
    
    /**
     *
     * @param rating Score for movie
     * @param user user that rated
     */
    public UserRating(int rating, UserData user) {
        this.rating = rating;
        this.user = user;
        major = user.getMajor();
    }   

    /**
     *
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @return user
     */
    public UserData getUser() {
        return user;
    }

    /**
     *
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     *
     * @param rating Score
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
}
