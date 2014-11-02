package model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class Buscador extends Editor {

    /**
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileNotFoundException 
     * 
     */
    public Buscador() throws FileNotFoundException, ClassNotFoundException, IOException {
    	super();
    }

    /**
     * @param chip : Chip
     * @return Un puntero a la mascota que posea esa mismo chip especificado como parámetro
     */
    public Mascota find(Chip chip) {
    	
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).equals(chip)) return mascotas.get(k);
    	}
    	return null;
    }

    /**
     * @param estado 
     * @return
     */
    public Mascota find(Estado estado) {
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).getEstado().equals((Estado)estado)) return mascotas.get(k);
    	}
    	return null;
    }

    /**
     * @param fechaExtravio 
     * @return
     */
    public Mascota find(Date fechaExtravio) {
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).getFechaExtravio().equals(fechaExtravio) )return mascotas.get(k);
    	}
    	return null; 
    }

    /**
     * @param infoContacto 
     * @return
     */
    public Mascota find(Contacto infoContacto) {
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).getContacto().equals((Contacto)infoContacto) )return mascotas.get(k);
    	}
        return null;
    }
    
    /**
     * @param raza 
     * @return
     */
    public Mascota findRaza(Raza raza) {
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).getRaza().equals(raza) )return mascotas.get(k);
    	}
        return null;
    }

    /**
     * @param lugarExtravio  
     * @return
     */
    public Mascota findLugar(String lugarExtravio ) {
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).getLugarExtravio().equals(lugarExtravio) )return mascotas.get(k);
    	}
        return null;
    }

    /**
     * @param notas 
     * @return
     */
    public Mascota findDescripcion(String notas) {
    	for(int k = 0; mascotas.get(k) != null; k++){
    		if(mascotas.get(k).getDescripcion().equals(notas) )return mascotas.get(k);
    	}
        return null;
    }

}