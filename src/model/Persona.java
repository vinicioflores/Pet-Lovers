package model;

import view.*;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Persona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2743407126392788006L;


	/**
     * 
     */
    public Persona() {
    }

    /**
     * 
     */
    protected String primerNombre;

    /**
     * 
     */
    protected String segundoNombre;

    /**
     * 
     */
    protected String primerApellido;

    /**
     * 
     */
    protected String segundoApellido ;

    /**
     * 
     */
    protected boolean requiereDonacion;

    /**
     * 
     */
    protected Condicion condicionCasaCuna ;

    /**
     * 
     */
    protected boolean aceptaRecompensa ;

    /**
     * 
     */
    protected ArrayList <Chip> MascotasEncontradas ;

    /**
     * 
     */
    protected User usuarioAsociado;


    /**
     * @param nombreCompleto 
     * @return
     */
    public Persona(String[] nombreCompleto) {
        setPrimerNombre(nombreCompleto[0]);
        setSegundoNombre(nombreCompleto[1]);
        setPrimerApellido(nombreCompleto[2]);
        setSegundoApellido(nombreCompleto[3]);
    }

    /**
     * @param nombreCompleto 
     * @param donacion 
     * @return
     */
    public Persona(String[] nombreCompleto, boolean donacion) {
        setPrimerNombre(nombreCompleto[0]);
        setSegundoNombre(nombreCompleto[1]);
        setPrimerApellido(nombreCompleto[2]);
        setSegundoApellido(nombreCompleto[3]);
        this.requiereDonacion = donacion;
    }

    /**
     * @param condition  
     * @return
     */
    public void setCondicionCasaCuna(Condicion condition ) {
        this.condicionCasaCuna = condition;
    }

    /**
     * @return
     */
    public Condicion getCondicionCasaCuna() {
        return this.condicionCasaCuna;
    }

    /**
     * @param chip  
     * @return
     */
    public void agregarMascotaEncontrada(Chip chip ) {
        this.MascotasEncontradas.add(chip);
    }

    /**
     * @param u 
     * @return
     */
    public void setUsuarioAsociado(User u) {
        usuarioAsociado = u;
    }

    /**
     * @return
     */
    public User getUsuarioAsociado() {
    	return usuarioAsociado;
    }

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public boolean isRequiereDonacion() {
		return requiereDonacion;
	}

	public void setRequiereDonacion(boolean requiereDonacion) {
		this.requiereDonacion = requiereDonacion;
	}

	public boolean isAceptaRecompensa() {
		return aceptaRecompensa;
	}

	public void setAceptaRecompensa(boolean aceptaRecompensa) {
		this.aceptaRecompensa = aceptaRecompensa;
	}

	public ArrayList<Chip> getMascotasEncontradas() {
		return MascotasEncontradas;
	}

	public void setMascotasEncontradas(ArrayList<Chip> mascotasEncontradas) {
		MascotasEncontradas = mascotasEncontradas;
	}

}