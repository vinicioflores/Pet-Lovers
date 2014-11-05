package model;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Estado implements Serializable {

    /**
     * 
     */
    public Estado() {
    }
    
    public Estado(EstadoTipos s)
    {
    	setEstado(s);
    }

    /**
     * 
     */
    private Date fecha;

    /**
     * 
     */
    private EstadoTipos estado ;

    /**
     * @param nFecha 
     * @return
     */
    public void setFecha(Date nFecha) {
        this.fecha = nFecha;
    }

    /**
     * @param stat 
     * @return
     */
    public void setEstado(EstadoTipos stat) {
        this.estado = stat;
    }

    /**
     * @return
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * @return
     */
    public EstadoTipos getEstado() {
        return this.estado;
    }

	@Override
	public String toString() {
		return "Estado [fecha=" + fecha + ", estado=" + estado + "]";
	}

	public boolean equals(Estado e) {
		if(e.estado.equals(this.estado)) 
			return true;
		return false;
	}

}