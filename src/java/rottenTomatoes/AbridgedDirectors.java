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
public class AbridgedDirectors implements Serializable {
    private String name;

    /**
     * Getter method for director name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for director name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
