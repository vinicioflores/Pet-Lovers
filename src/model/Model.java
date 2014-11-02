package model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class Model {

    /**
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileNotFoundException 
     * 
     */
    public Model() throws FileNotFoundException, ClassNotFoundException, IOException {
    	this.registro = new Buscador();
    }

    /**
     * 
     */
    private Buscador registro ;


    /**
     * @param newreg 
     * @return
     */
    public void setRegistro(Buscador newreg) {
        this.registro = newreg;
    }

    /**
     * @return
     */
    public Buscador getRegistro() {
        return this.registro;
    }

}