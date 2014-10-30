package model;
import java.util.*;

/**
 * 
 */
public class Registro {

    /**
     * 
     */
    public Registro() {
    }

    /**
     * 
     */
    protected ArrayList <Mascota> mascotas;

    /**
     * 
     */
    protected ArrayList <Chip> mascotasEnAdopcion;

    /**
     * 
     */
    protected ArrayList <Contacto> usuarios;

    /**
     * @param nPet 
     * @return
     */
    public void add(Mascota nPet) {
        // TODO implement here
    }

    /**
     * @param nombre 
     * @return
     */
    public boolean removeNombre(String nombre) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public boolean remove(Chip id) {
        // TODO implement here
        return false;
    }

    /**
     * @param tipo 
     * @return
     */
    public boolean remove(String tipo) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public int getCantidadMascotas() {
        // TODO implement here
        return 0;
    }

    /**
     * @param nPet  
     * @param socialNetwork  
     * @return
     */
    public void publish(Mascota nPet , Sitios socialNetwork ) {
        // TODO implement here
    }

    /**
     * @param id  
     * @return
     */
    public void ponerEnAdopcion(Chip id ) {
        // TODO implement here
    }

}