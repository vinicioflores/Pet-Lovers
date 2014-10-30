package model;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Mascota implements Serializable {

    /**
     * 
     */
    public Mascota() {
    }

    /**
     * 
     */
    private String tipoMascota;

    /**
     * 
     */
    private Raza raza;

    /**
     * 
     */
    private ArrayList <Raza> razas;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private Chip chip;

    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private String foto;

    /**
     * 
     */
    private Contacto contacto;

    /**
     * 
     */
    private boolean extraviado;

    /**
     * 
     */
    private String lugarExtravio ;

    /**
     * 
     */
    private Date fechaExtravio;

    /**
     * 
     */
    private Recompensa recompensa;

    /**
     * 
     */
    private String descripcion;

    /**
     * 
     */
    private Estado estado;

    /**
     * 
     */
    private Tamaño tamaño ;

    /**
     * 
     */
    private ArrayList <String> fotos ;

    /**
     * 
     */

    /**
     * @param nombre 
     * @return
     */
    public Mascota(String nombre) {
        // TODO implement here
    }

    /**
     * @param type 
     * @return
     */
    public void setTipoMascota(String type) {
        // TODO implement here
    }

    /**
     * @param raza 
     * @return
     */
    public void setRaza(Raza raza) {
        // TODO implement here
    }

    /**
     * @param nombre 
     * @return
     */
    public void setNombre(String nombre) {
        // TODO implement here
    }

    /**
     * @param chip 
     * @return
     */
    public void setChip(Chip chip) {
        // TODO implement here
    }

    /**
     * @param color 
     * @return
     */
    public void setColor(Color color) {
        // TODO implement here
    }

    /**
     * @param foto 
     * @return
     */
    public void setFoto(String foto) {
        // TODO implement here
    }

    /**
     * @param contact 
     * @return
     */
    public void setContacto(Contacto contact) {
        // TODO implement here
    }

    /**
     * @param isPerdido 
     * @return
     */
    public void setExtraviado(boolean isPerdido) {
        // TODO implement here
    }

    /**
     * @param lugar 
     * @return
     */
    public void setLugarExtravio(String lugar) {
        // TODO implement here
    }

    /**
     * @param fecha 
     * @return
     */
    public void setFechaExtravio(Date fecha) {
        // TODO implement here
    }

    /**
     * @param reward 
     * @return
     */
    public void setRecompensa(Recompensa reward) {
        // TODO implement here
    }

    /**
     * @param notas 
     * @return
     */
    public void setDescripcion(String notas) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getTipoMascota() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Raza getRaza() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Chip getChip() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getFoto() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Contacto getContacto() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean getExtraviado() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public String getLugarExtravio() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Date getFechaExtravio() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Recompensa getRecompensa() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getDescripcion() {
        // TODO implement here
        return "";
    }

    /**
     * @param newstat 
     * @return
     */
    public void setEstado(Estado newstat) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Estado getEstado() {
        // TODO implement here
        return null;
    }

    /**
     * @param raza 
     * @return
     */
    public void addRaza(Raza raza) {
        // TODO implement here
    }

    /**
     * @param String 
     * @return
     */
    public boolean removeRaza(Raza raza) {
        // TODO implement here
    	return false;
    }

    /**
     * @param fotodir 
     * @return
     */
    public void registrarFoto(String fotodir) {
        // TODO implement here
    }

    /**
     * @param fotodir  
     * @return
     */
    public boolean quitarFoto(String fotodir ) {
        // TODO implement here
        return false;
    }

	@Override
	public String toString() {
		return "Mascota [tipoMascota=" + tipoMascota + ", raza=" + raza
				+ ", razas=" + razas + ", nombre=" + nombre + ", chip=" + chip
				+ ", color=" + color + ", foto=" + foto + ", contacto="
				+ contacto + ", extraviado=" + extraviado + ", lugarExtravio="
				+ lugarExtravio + ", fechaExtravio=" + fechaExtravio
				+ ", recompensa=" + recompensa + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", tamaño=" + tamaño + ", fotos="
				+ fotos + "]";
	}

}