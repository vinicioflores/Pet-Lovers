package model;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Recompensa implements Serializable {

    /**
     * 
     */
    public Recompensa() {
    }

    /**
     * 
     */
    private float monto ;

    /**
     * 
     */
    private char moneda ;


    /**
     * @param monto 
     * @param moneda 
     * @return
     */
    public Recompensa(float monto, char moneda) {
        setMonto(monto);
        setMoneda(moneda);
    }

    /**
     * @param moneda 
     * @return
     */
    public Recompensa(char moneda) {
        setMoneda(moneda);
    }

    /**
     * @param monto 
     * @return
     */
    public Recompensa(float monto) {
        setMonto(monto);
    }

    /**
     * @param nMoneda 
     * @return
     */
    public void setMoneda(char nMoneda) {
        this.moneda = nMoneda;
    }

    /**
     * @param nMonto 
     * @return
     */
    public void setMonto(float nMonto) {
        this.monto = nMonto;
    }

    /**
     * @return
     */
    public char getMoneda() {
        return this.moneda;
    }

    /**
     * @return
     */
    public float getMonto() {
        return this.monto;
    }

	@Override
	public String toString() {
		return "Recompensa [monto=" + monto + ", moneda=" + moneda + "]";
	}

}