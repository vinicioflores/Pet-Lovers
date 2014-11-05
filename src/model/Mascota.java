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
    	instanceAll();
    }
    
    private void instanceAll()
    {
    	fechaExtravio = new Date();
    	tipoMascota = new String();
    	razas = new Raza();
    	raza = new String();
    	chip = new Chip();
    	foto = new String();
    	contacto = new Contacto();
    	extraviado = false;
    	lugarExtravio = new String();
    	recompensa = new Recompensa();
    	estado = new Estado();
    	descripcion = new String();
    	fotos = new Fotos();
    }

    /**
     * 
     */
    private String tipoMascota;

    /**
     * 
     */
    private String raza;

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
    private PetColor PetColor;

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
    private int tamaño ;

    /**
     * 
     */
    private Fotos fotos ;

    /**
     * 
     */
    private Raza razas;

    /**
     * @param nombre 
     * @return
     */
    public Mascota(String nombre) {
        instanceAll();
        setNombre(nombre);
    }

    /**
     * @param type 
     * @return
     */
    public void setTipoMascota(String type) {
    	tipoMascota = new String(type);
    }

    /**
     * @param raza 
     * @return
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @param nombre 
     * @return
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param chip 
     * @return
     */
    public void setChip(Chip chip) {
        this.chip = chip;
    }

    /**
     * @param PetColor 
     * @return
     */
    public void setPetColor(PetColor PetColor) {
        this.PetColor = PetColor;
    }

    /**
     * @param foto 
     * @return
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @param contact 
     * @return
     */
    public void setContacto(Contacto contact) {
        this.contacto = contact;
    }

    /**
     * @param isPerdido 
     * @return
     */
    public void setExtraviado(boolean isPerdido) {
        this.extraviado = isPerdido;
    }

    /**
     * @param lugar 
     * @return
     */
    public void setLugarExtravio(String lugar) {
        this.lugarExtravio = lugar;
    }

    /**
     * @param fecha 
     * @return
     */
    public void setFechaExtravio(Date fecha) {
        this.fechaExtravio = fecha;
    }

    /**
     * @param reward 
     * @return
     */
    public void setRecompensa(Recompensa reward) {
        this.recompensa = reward;
    }

    /**
     * @param notas 
     * @return
     */
    public void setDescripcion(String notas) {
        this.descripcion = notas;
    }

    /**
     * @return
     */
    public String getTipoMascota() {
        return tipoMascota;
    }

    /**
     * @return
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return
     */
    public Chip getChip() {
        return chip;
    }

    /**
     * @return
     */
    public PetColor getPetColor() {
        return PetColor;
    }

    /**
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @return
     */
    public Contacto getContacto() {
        return contacto;
    }

    /**
     * @return
     */
    public boolean getExtraviado() {
        return this.extraviado;
    }

    /**
     * @return
     */
    public String getLugarExtravio() {
        return lugarExtravio;
    }

    /**
     * @return
     */
    public Date getFechaExtravio() {
        return fechaExtravio;
    }

    /**
     * @return
     */
    public Recompensa getRecompensa() {
        return recompensa;
    }

    /**
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param newstat 
     * @return
     */
    public void setEstado(Estado newstat) {
        this.estado = newstat; 
    }

    /**
     * @return
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param fotodir 
     * @return
     */
    public void registrarFoto(String fotodir) {
        this.fotos.add(fotodir);
    }

    /**
     * @param fotodir  
     * @return
     */
    public boolean quitarFoto(String fotodir ) {
        return fotos.remove(fotodir);
    }

	@Override
	public String toString() {
		return "Mascota [tipoMascota=" + tipoMascota + ", raza=" + raza
				+  ", nombre=" + nombre + ", chip=" + chip
				+ ", Color=" + PetColor + ", foto=" + foto + ", contacto="
				+ contacto + ", extraviado=" + extraviado + ", lugarExtravio="
				+ lugarExtravio + ", fechaExtravio=" + fechaExtravio
				+ ", recompensa=" + recompensa + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", tamaño=" + tamaño + ", fotos="
				+ fotos + "]";
	}
	
	public boolean equals(Chip chipID)
	{
		if(chip.getID().equals(chipID.getID()) == true) return true;
		return false;
	}
	
	public boolean equals(Date pFechaReportada)
	{
		if(fechaExtravio.equals(pFechaReportada) == true) return true;
		return false;
	}
	
	public boolean equals(Contacto reportante)
	{
		if(this.getContacto().equals(reportante) == true) return true;
		return false;
	}
	
	public boolean equals(Estado pEstado)
	{
		if(this.getEstado().equals(pEstado) == true) return true;
		return false;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(Tamaño tamaño) {
		this.tamaño = tamaño.ordinal();
	}

	public Fotos getFotos() {
		return fotos;
	}

	public void setFotos(Fotos fotos) {
		this.fotos = fotos;
	}
	
	
}