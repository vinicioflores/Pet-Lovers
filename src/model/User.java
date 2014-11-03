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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}