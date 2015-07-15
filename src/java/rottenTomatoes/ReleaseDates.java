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
public class ReleaseDates implements Serializable {
    @Expose
    private String theater;
    
    @Expose
    private String dvd;

    /**
     *
     * @return
     */
    public String getTheater() {
        return theater;
    }

    /**
     *
     * @return
     */
    public String getDvd() {
        return dvd;
    }

    /**
     *
     * @param theater
     */
    public void setTheater(String theater) {
        this.theater = theater;
    }

    /**
     *
     * @param dvd
     */
    public void setDvd(String dvd) {
        this.dvd = dvd;
    }
    
    
}
