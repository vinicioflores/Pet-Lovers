package model;
import java.util.*;

/**
 * 
 */
public class Adoptante extends Contacto {

	private void setLists()
	{
    	mascotasAdoptadas = new ArrayList<Chip>();
    	fotosAdoptante = new Fotos();
    	fotosAdoptanteMascotas = new Fotos();
    	notas = new ArrayList<String>();
    	starCounter = 0;
    	ID = hashCode();
    	enListaNegra = false;
	}
    /**
     * 
     */
    public Adoptante() {
    	super();
    	setLists();
    }
    
    public Adoptante(String []fullname, int tel, String mail, boolean reqDonacion)
    {
    	super(fullname,tel,mail,reqDonacion);
    	setLists();
    }

    /**
     * 
     */
    private ArrayList <Chip> mascotasAdoptadas ;

    /**
     * 
     */
    private Fotos fotosAdoptante;

    /**
     * 
     */
    private Fotos fotosAdoptanteMascotas;

    private static final int NOT_FOUND_INDEX=-2;
    private static final int FOTOS_SOLO_ADOPTANTE=1;
    private static final int FOTOS_CON_MASCOTA = 3;
    
    /**
     * 
     */
    private int starCounter=0;
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
    	if(mascotasAdoptadas == null) return false;
    	if(!mascotasAdoptadas.contains(id)){
    		mascotasAdoptadas.add(id);
    		return true;
    	} 
    	return false;
    }

    /**
     * @param fotodir 
     * @param int  nAlbumFotos 
     * @return
     */
    public void registrarFoto(String fotodir, int  nAlbumFotos) {
        switch(nAlbumFotos){
        case FOTOS_SOLO_ADOPTANTE:
        	fotosAdoptante.add(fotodir);
        	break;
        case FOTOS_CON_MASCOTA:
        	fotosAdoptanteMascotas.add(fotodir);
        	break;
        }
    }

    /**
     * @param fotodir 
     * @return
     */
    public boolean quitarFoto(String fotodir, int nAlbumFotos) {
        switch(nAlbumFotos){
        case FOTOS_SOLO_ADOPTANTE:
        	try {
        		fotosAdoptante.remove(fotodir);
        		return true;
        	} catch (Exception e){
        		return false;
        	}
        	
		case FOTOS_CON_MASCOTA:
        	try {
        		fotosAdoptanteMascotas.remove(fotodir);
        		return true;
        	} catch (Exception e){
        		return false;
        	}
        }
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
    public void calificar(int star) {
    	if(estrellas == null) return;
        if(star >= 0 && star <= 5){
        	estrellas[starCounter] = star;
        	starCounter++;
        }
    }

    /**
     * @param nota  
     * @return
     */
    public void nuevaNota(String nota ) {
    	try {
    		notas.add(nota);
    	} catch (Exception e){
    		System.out.println("Error de memoria: Fallo al intentar "
    				+ "añadir una nueva nota a la "
    				+ "ArrayList de notas de class Adoptante ... ");
    	}
    }

    /**
     * @return promedio entre 0,5
     */
    public int promediar() {
    	int acum=0;
        for(int k = 0; k < starCounter; k++){
        	acum += estrellas[k];
        }
   
        promedioEstrellas =  (acum / starCounter);
        return promedioEstrellas;
    }

    /**
     * @return promedio sobre 100% : entero
     */
    public int ponderar() {
        return ((promediar()*100)/5);
    }

	public ArrayList<Chip> getMascotasAdoptadas() {
		return mascotasAdoptadas;
	}

	public void setMascotasAdoptadas(ArrayList<Chip> mascotasAdoptadas) {
		this.mascotasAdoptadas = mascotasAdoptadas;
	}

	public Fotos getFotosAdoptante() {
		return fotosAdoptante;
	}

	public void setFotosAdoptante(Fotos fotosAdoptante) {
		this.fotosAdoptante = fotosAdoptante;
	}

	public Fotos getFotosAdoptanteMascotas() {
		return fotosAdoptanteMascotas;
	}

	public void setFotosAdoptanteMascotas(Fotos fotosAdoptanteMascotas) {
		this.fotosAdoptanteMascotas = fotosAdoptanteMascotas;
	}

	public int getStarCounter() {
		return starCounter;
	}

	public void setStarCounter(int starCounter) {
		this.starCounter = starCounter;
	}

	public int[] getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int[] estrellas) {
		this.estrellas = estrellas;
	}

	public int getPromedioEstrellas() {
		return promedioEstrellas;
	}

	public void setPromedioEstrellas(int promedioEstrellas) {
		this.promedioEstrellas = promedioEstrellas;
	}

	public ArrayList<String> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<String> notas) {
		this.notas = notas;
	}

	public boolean isEnListaNegra() {
		return enListaNegra;
	}

	public void setEnListaNegra(boolean enListaNegra) {
		this.enListaNegra = enListaNegra;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}