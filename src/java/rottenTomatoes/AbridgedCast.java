package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

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
public class AbridgedCast {
    
    @Expose
    private String name;
    
    @Expose
    private List<String> characters = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
}
