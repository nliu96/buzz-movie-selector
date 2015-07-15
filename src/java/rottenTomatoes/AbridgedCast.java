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
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param characters
     */
    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
}
