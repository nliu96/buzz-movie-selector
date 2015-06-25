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
    
    public UserRating(int rating, UserData user) {
        this.rating = rating;
        this.user = user;
        major = user.getMajor();
    }   

    public int getRating() {
        return rating;
    }

    public UserData getUser() {
        return user;
    }

    public String getMajor() {
        return major;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
