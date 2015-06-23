/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
/**
 *
 * @author theaz_000
 */
public class ReleaseDates {
    @Expose
    private String theater;
    
    @Expose
    private String dvd;

    public String getTheater() {
        return theater;
    }

    public String getDvd() {
        return dvd;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }
    
    
}
