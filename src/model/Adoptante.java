package model;
import java.util.*;

/**
 * 
 */
public class Adoptante extends Contacto {

    /**
     * 
     */
    public Adoptante() {
    	super();
    }

    /**
     * 
     */
    private ArrayList <Chip> mascotasAdoptadas ;

    /**
     * 
     */
    private ArrayList <String> fotosAdoptante;

    /**
     * 
     */
    private ArrayList <String> fotosAdoptanteMascotas;

    /**
     * 
     */
    private int[] estrellas ;

    /**
     * 
     */
    private int promedioEstrellas ;

    /**
     * 
     */
    private ArrayList <String> notas;

    /**
     * 
     */
    private boolean enListaNegra;

    /**
     * 
     */
    private int ID;



    /**
     * @param id 
     * @return
     */
    public boolean adoptar(Chip id) {
        // TODO implement here
        return false;
    }

    /**
     * @param fotodir 
     * @param int  nAlbumFotos 
     * @return
     */
    public void registrarFoto(String fotodir, int  nAlbumFotos) {
        // TODO implement here
    }

    /**
     * @param fotodir 
     * @return
     */
    public boolean quitarFoto(String fotodir) {
        // TODO implement here
        return false;
    }

    /**
     * @param socialNetwork 
     * @return
     */
    public void publish(Sitios socialNetwork) {
        // TODO implement here
    }

    /**
     * @param star  
     * @return
     */
    public void calificar(int star ) {
        // TODO implement here
    }

    /**
     * @param nota  
     * @return
     */
    public void nuevaNota(String nota ) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int promediar() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int ponderar() {
        // TODO implement here
        return 0;
    }

}