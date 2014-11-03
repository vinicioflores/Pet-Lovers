package model;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Chip implements Serializable {

    /**
     * 
     */
    public Chip() {
    }
    
    public Chip(String id)
    {
    	this.id = id;
    }

    /**
     * 
     */
    private String id;



    /**
     * @param newid 
     * @return
     */
    public void setID(String newid) {
        id = newid;
    }

    /**
     * @return
     */
    public String getID() {
        return id;
    }

    /**
     * @param algorythm
     */
    public void genID(AlgoritmosChip algorythm) {
        id = String.valueOf(hashCode());
    }

	@Override
	public String toString() {
		return "Chip [id=" + id.toString() + "]";
	}

}