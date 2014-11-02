package model;

/**
 * 
 */
public class Asociacion {

    /**
     * 
     */
    public Asociacion() {
    	nombre = "";
    	asocID = hashCode();
    	donacionesTotal = 0;
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private int  asocID;

    /**
     * 
     */
    private float donacionesTotal ;


    /**
     * @param monto  
     * @return
     */
    public void donar(float monto ) {
        donacionesTotal += monto;
    }

    /**
     * @param id 
     * @return
     */
    public void setAsocID(int id) {
        asocID = id;
    }

    /**
     * @return
     */
    public int getAsocID() {
        return asocID;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDonacionesTotal() {
		return donacionesTotal;
	}

	public void setDonacionesTotal(float donacionesTotal) {
		this.donacionesTotal = donacionesTotal;
	}

}