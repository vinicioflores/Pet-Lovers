package model;

import java.io.Serializable;

/**
 * 
 */
public class Contacto extends Persona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7547424926978731275L;

	/**
     * 
     */
    private int telefono;

    /**
     * 
     */
    private String correo;

    public Contacto() { super(); }
    public Contacto(String[] fullname, int tel, String mail, boolean reqDonacion) {
    	super(fullname);
    	telefono = tel;
    	correo = mail;
    	setRequiereDonacion(reqDonacion);
    }
    
    /**
     * @param nombreCompleto 
     * @param tel 
     * @param mail 
     * @return
     */
    public Contacto(String[] nombreCompleto, int tel, String mail) {
        super(nombreCompleto);
        telefono = tel;
        correo = mail;
    }

    /**
     * @param nombreCompleto 
     * @param mail 
     * @return
     */
    public Contacto(String[] nombreCompleto, String mail) {
        super(nombreCompleto);
        correo = mail;
    }

    /**
     * @param nombreCompleto 
     * @param tel  
     * @return
     */
    public Contacto(String[] nombreCompleto, int tel ) {
        super(nombreCompleto);
        telefono = tel;
    }

    /**
     * @param nombreCompleto 
     * @return
     */
    public Contacto(String[] nombreCompleto) {
        super(nombreCompleto);
    }

    /**
     * @param tel 
     * @return
     */
    public void setTelefono(int tel) {
        this.telefono = tel;
    }

    /**
     * @param mail 
     * @return
     */
    public void setCorreo(String mail) {
        this.correo = mail;
    }

    /**
     * @return
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @return
     */
    public String getCorreo() {
        return correo;
    }
    
    public boolean equals(Contacto nPersona) 
    {
    	if(telefono == nPersona.getTelefono()){
    		if(correo == nPersona.getCorreo()){
    			if(this.getCondicionCasaCuna().equals(nPersona.getCondicionCasaCuna())) 
    			{
    				if(this.getMascotasEncontradas().equals(nPersona.getMascotasEncontradas())){
    					if(this.getPrimerNombre().equals(nPersona.getPrimerNombre())){
    						if(this.getPrimerApellido().equals(nPersona.getPrimerApellido())){
    							if(this.getSegundoNombre().equals(nPersona.getSegundoNombre())){
    								if(this.getSegundoApellido().equals(nPersona.getSegundoApellido())){
    									if(this.getUsuarioAsociado().equals(nPersona.getUsuarioAsociado())){
    										return true;
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
	@Override
	public String toString() {
		return "Contacto [telefono=" + telefono + ", correo=" + correo
				+ ", primerNombre=" + primerNombre + ", segundoNombre="
				+ segundoNombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido
				+ ", requiereDonacion=" + requiereDonacion
				+ ", condicionCasaCuna=" + condicionCasaCuna
				+ ", aceptaRecompensa=" + aceptaRecompensa
				+ ", MascotasEncontradas=" + MascotasEncontradas
				+ ", usuarioAsociado=" + usuarioAsociado + "]";
	}

}