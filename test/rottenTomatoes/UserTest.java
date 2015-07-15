/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rottenTomatoes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NIck
 */
public class UserTest {
    private User instance;
    
    /**
     *
     */
    public UserTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        instance = new User();
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class User.
     */
    @Test
    public void testCorrectLogin() {
        System.out.println("login");
        String expResult = "welcome.xhtml?faces-redirect=true";
        instance.setUsername("user");
        instance.setPassword("pass");
        String result = instance.login();
        assertEquals(expResult, result);
    }
    
    /**
     * If correct, login should work
     */
    @Test(expected = NullPointerException.class)
    public void testIncorrectLogin() {
        System.out.println("incorrect login");
        String expResult = null;
        instance.setUsername("wrong");
        instance.setPassword("info");
        String result = instance.login();
        assertEquals(expResult, result);
    }

    /**
     * Testing if account is locked, then account cannot be logged into
     */
    @Test(expected = NullPointerException.class)
    public void testLockedAccount() {
        System.out.println("locked account");
        String expResult = null;
        instance.setUsername("user");
        instance.setPassword("pass");
        UserManager.getInstance().find("user").toggleLock();
        String result = instance.login();
        assertEquals(expResult, result);
        UserManager.getInstance().find("user").toggleLock();
    }
}
