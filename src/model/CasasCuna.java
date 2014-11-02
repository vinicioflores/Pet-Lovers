package model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class CasasCuna extends Buscador {

    /**
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileNotFoundException 
     * 
     */
    public CasasCuna() throws FileNotFoundException, ClassNotFoundException, IOException {
    	super();
    	prepareArrays();
    }

    private void prepareArrays()
    {
    	casasCuna = new ArrayList<Adoptante>();
    	listaNegra = new ArrayList<Adoptante>();
    }
    
    /**
     * 
     */
    private ArrayList <Adoptante> casasCuna;

    /**
     * 
     */
    private ArrayList <Adoptante> listaNegra ;
    
    /**
     * @param contactSrc  
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileNotFoundException 
     */
    CasasCuna(ArrayList <Adoptante> contactSrc ) throws FileNotFoundException, ClassNotFoundException, IOException {
    	super();
        prepareArrays();
        casasCuna = contactSrc;
    }

    /**
     * @param tel 
     * @return
     */
    public boolean remove(int tel) {
    	int k;
        for(k = 0; casasCuna.get(k).getTelefono() != tel; k++);
        if(casasCuna.get(k).getTelefono() == tel)
        {
        	casasCuna.remove(k);
        	return true;
        }
        return false;
    }

    /**
     * @param mail  
     * @return
     */
    public boolean remove(String mail ) {
    	int k;
        for(k = 0; casasCuna.get(k).getCorreo() != mail; k++);
        if(casasCuna.get(k).getCorreo() == mail)
        {
        	casasCuna.remove(k);
        	return true;
        }
        return false;
    }

    /**
     * @param donacion  
     * @return
     */
    public boolean remove(boolean donacion ) {
    	int k;
        for(k = 0; casasCuna.get(k).isRequiereDonacion() != donacion; k++);
        if(casasCuna.get(k).isRequiereDonacion() == donacion)
        {
        	casasCuna.remove(k);
        	return true;
        }
        return false;
    }

    /**
     * @param nombreCompleto 
     * @return
     */
    public boolean remove(String[] nombreCompleto) {
    	int k;
    	String[] fullNombre = {"","","",""};
        for(k = 0; !fullNombre.equals(nombreCompleto); k++){
        	fullNombre[0] = casasCuna.get(k).getPrimerNombre();
        	fullNombre[1] = casasCuna.get(k).getSegundoNombre();
        	fullNombre[2] = casasCuna.get(k).getPrimerApellido();
        	fullNombre[3] = casasCuna.get(k).getSegundoApellido();
        }
        if(fullNombre.equals(nombreCompleto) == true)
        {
        	casasCuna.remove(k);
        	return true;
        }
        return false;
    }

    /**
     * @param nombreCompleto[] 
     * @return un puntero a la persona que coincida en nombre, o nulo si no existe
     */
    public Adoptante contactar(String nombreCompleto[]) {
    	int k;
    	String[] fullNombre = {"","","",""};
    	Adoptante pPersona=null;
        for(k = 0; !fullNombre.equals(nombreCompleto); k++){
        	pPersona = casasCuna.get(k);
        	fullNombre[0] = casasCuna.get(k).getPrimerNombre();
        	fullNombre[1] = casasCuna.get(k).getSegundoNombre();
        	fullNombre[2] = casasCuna.get(k).getPrimerApellido();
        	fullNombre[3] = casasCuna.get(k).getSegundoApellido();
        }
        if(fullNombre.equals(nombreCompleto) == true)
        {
        	return pPersona;
        }
        return null;
    }
    
    public Adoptante findByID(int id)
    {
    	int j;
    	for(j = 0; casasCuna.get(j).getID() != id; j++);
    	if(casasCuna.get(j).getID() == id) return casasCuna.get(j);
    	return null;
    }

    /**
     * @param adopID  
     * @return
     */
    public void agregarListaNegra(int adopID ) {
    	Adoptante target = findByID(adopID);
    	if(target != null){
    		if(!listaNegra.contains(target)) 
    			listaNegra.add(target);
    	}
    }

    /**
     * @param adoptID 
     * @return
     */
    public boolean quitarListaNegra(int adoptID) {
        Adoptante target = findByID(adoptID);
        if(target != null)
        {
        	if(listaNegra.contains(target))
        		return listaNegra.remove(target);
        }
        return false;
    }

    /**
     * @param adoptant 
     * @return
     */
    public void add(Adoptante adoptant) {
        casasCuna.add(adoptant);
    }

    /**
     * @param nombreCompleto 
     * @param tel 
     * @param mail 
     * @param donacion 
     * @return
     */
    public void add(String[] nombreCompleto, int tel, String mail, boolean donacion) {
        add(new Adoptante(nombreCompleto,tel,mail,donacion));
    }

}