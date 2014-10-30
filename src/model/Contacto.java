package model;
import java.util.*;

/**
 * 
 */
public class Contacto extends Persona {

    /**
     * 
     */
    private int telefono;

    /**
     * 
     */
    private String correo;

    public Contacto() { }
    
    /**
     * @param nombreCompleto 
     * @param tel 
     * @param mail 
     * @return
     */
    public Contacto(String[] nombreCompleto, int tel, String mail) {
        // TODO implement here
    }

    /**
     * @param nombreCompleto 
     * @param mail 
     * @return
     */
    public Contacto(String[] nombreCompleto, String mail) {
        // TODO implement here
    }

    /**
     * @param nombreCompleto 
     * @param tel  
     * @return
     */
    public Contacto(String[] nombreCompleto, int tel ) {
        // TODO implement here
    }

    /**
     * @param nombreCompleto 
     * @return
     */
    public Contacto(String[] nombreCompleto) {
        // TODO implement here
    }

    /**
     * @param tel 
     * @return
     */
    public void setTelefono(int tel) {
        // TODO implement here
    }

    /**
     * @param mail 
     * @return
     */
    public void setCorreo(String mail) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getTelefono() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getCorreo() {
        // TODO implement here
        return "";
    }

}