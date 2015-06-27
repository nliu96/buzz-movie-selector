/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nick
 */
@ManagedBean
@SessionScoped
public class Admin {
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    @ManagedProperty("#{movieManager}")
    private MovieManager movieManager;
    
    
}
