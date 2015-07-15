package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

/**
 *
 * @author dylanfloyd
 */
@Generated("org.jsonschema2pojo")
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author theaz_000
 */
public class AbridgedCast implements Serializable {
    
    @Expose
    private String name;
    
    @Expose
    private List<String> characters = new ArrayList<String>();

    /**
     * Getter method for cast name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the characters
     * @return characters
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     * Setter method for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for character names
     * @param characters
     */
    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
}
