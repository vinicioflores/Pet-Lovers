package model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class Donaciones extends Buscador {

    /**
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileNotFoundException 
     * 
     */
    public Donaciones() throws FileNotFoundException, ClassNotFoundException, IOException {
    	super();
    }

    /**
     * 
     */
    private ArrayList <Asociacion> asociaciones ;

    /**
     * 
     */
    private ArrayList <Donacion> donaciones ;


    /**
     * @param asoc 
     * @return
     */
    public void registrarAsociacion(Asociacion asoc) {
        // TODO implement here
    }

    /**
     * @param nombre  
     * @return
     */
    public void registrarAsociacion(String nombre ) {
        // TODO implement here
    }

    /**
     * @param donacion 
     * @return
     */
    public boolean donar(Donacion donacion) {
        // TODO implement here
        return false;
    }

    /**
     * @param monto 
     * @param donante 
     * @param asocID 
     * @return
     */
    public boolean donar(float monto, Persona donante, int asocID) {
        // TODO implement here
        return false;
    }

}