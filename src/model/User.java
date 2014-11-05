package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 */
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7246256387114214782L;

	/**
     * 
     */
    public User() {
    }
    
    public User(String name, String pwd)
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
    public void setUserName(String name ) {
        username = name;
    }

    /**
     * @param pwd  
     * @return
     */
    public void setPassword(String pwd ) {
        password = pwd;
    }

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return
     */
    public String getPassword() {
    	return password;
    }

    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	
	public boolean equals(User u) {
		if(u.getUsername().equals(this.username))
			if(u.getPassword().equals(this.getPassword()))
				return true;
		return false;
	}

}