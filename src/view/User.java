package view;

import java.util.*;

/**
 * 
 */
public class User {

    /**
     * 
     */
    User() {
    }
    
    User(String name, String pwd)
    {
    	setUserName(name);
    	setPassword(pwd);
    }

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;


    /**
     * @param name  
     * @return
     */
    public boolean setUserName(String name ) {
        // TODO implement here
        return false;
    }

    /**
     * @param pwd  
     * @return
     */
    public boolean setPassword(String pwd ) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public String getUsername() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getPassword() {
        // TODO implement here
        return "";
    }

}