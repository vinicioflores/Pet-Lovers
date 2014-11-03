package model;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Raza implements Serializable {

	public Raza(){
		razas = new ArrayList<Razas>();
	}
    /**
     * 
     */
    public Raza(Razas raza) {
    	razas = new ArrayList <Razas> ();
    	razas.add(raza);
    	setRaza(raza);
    }

    /**
     * 
     */
    private ArrayList <Razas> razas ;
    /**
     * 
     */
    private Razas raza;

    /**
     * @param raza 
     * @return
     */
    public void add(Razas raza) {
        razas.add(raza);
    }

    /**
     * @return
     */
    public Razas get() {
    	return raza;
    }
    
    /* Selecciona una raza de la lista de razas y la asigna a la raza actual */
    public void setRaza(Razas raza)
    {
    	for(Razas pR : razas){
    		if(pR.equals(raza))
    			raza = pR;
    	}
    }
	@Override
	public String toString() {
		return "Raza [razas=" + razas.toString() + ", raza=" + raza + "]";
	}
}