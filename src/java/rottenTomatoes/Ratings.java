/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

/**
 *
 * @author theaz_000
 */
public class Ratings {
    private String critics_rating;
    private String critics_scores;
    private String audience_rating;
    private String audience_score;

    public String getCritics_rating() {
        return critics_rating;
    }

    public String getCritics_scores() {
        return critics_scores;
    }

    public String getAudience_rating() {
        return audience_rating;
    }

    public String getAudience_score() {
        return audience_score;
    }

    public void setCritics_rating(String critics_rating) {
        this.critics_rating = critics_rating;
    }

    public void setCritics_scores(String critics_scores) {
        this.critics_scores = critics_scores;
    }

    public void setAudience_rating(String audience_rating) {
        this.audience_rating = audience_rating;
    }

    public void setAudience_score(String audience_score) {
        this.audience_score = audience_score;
    }
    
    
}
