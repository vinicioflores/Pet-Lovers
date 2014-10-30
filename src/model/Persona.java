package model;

import view.*;
import java.util.*;

/**
 * 
 */
public class Persona {

    /**
     * 
     */
    public Persona() {
    }

    /**
     * 
     */
    private String primerNombre;

    /**
     * 
     */
    private String segundoNombre;

    /**
     * 
     */
    private String primerApellido;

    /**
     * 
     */
    private String segundoApellido ;

    /**
     * 
     */
    private boolean requiereDonacion;

    /**
     * 
     */
    private Condicion condicionCasaCuna ;

    /**
     * 
     */
    private boolean aceptaRecompensa ;

    /**
     * 
     */
    private ArrayList <Chip> MascotasEncontradas ;

    /**
     * 
     */
    private User usuarioAsociado;


    /**
     * @param nombreCompleto 
     * @return
     */
    public Persona(String[] nombreCompleto) {
        // TODO implement here
    }

    /**
     * @param nombreCompleto 
     * @param donacion 
     * @return
     */
    public Persona(String[] nombreCompleto, boolean donacion) {
        // TODO implement here
    }

    /**
     * @param condition  
     * @return
     */
    public void setCondicionCasaCuna(Condicion condition ) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Condicion getCondicionCasaCuna() {
        // TODO implement here
        return null;
    }

    /**
     * @param chip  
     * @return
     */
    public void agregarMascotaEncontrada(Chip chip ) {
        // TODO implement here
    }

    /**
     * @param u 
     * @return
     */
    public void setUsuarioAsociado(User u) {
        // TODO implement here
    }

    /**
     * @return
     */
    public User getUsuarioAsociado() {
        // TODO implement here
        return null;
    }

}