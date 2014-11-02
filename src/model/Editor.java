package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 */
public class Editor extends Registro {

    /**
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileNotFoundException 
     * 
     */
    public Editor() throws FileNotFoundException, ClassNotFoundException, IOException {
    	super();
    }

    /**
     * @param id  
     * @return
     */
    public Mascota get(Chip id ) {
        int k=0;
        
        while(mascotas.get(k) != null && k < mascotas.size())
        {
        	if(mascotas.get(k).getChip().getID().equals(id.getID()) == true)
        		return mascotas.get(k);
        	k++;
        }
        return null;
    }

    /**
     * @param index  
     * @return
     */
    public Mascota get(int index) {
    	return mascotas.get(index);
    }

    /**
     * @param pet 
     * @return
     */
    public void edit(Mascota pet) {
        Mascota target = get(pet.getChip());
        
        try {
	        target.setChip(pet.getChip());
	        target.setNombre(pet.getNombre());
	        target.setTipoMascota(pet.getTipoMascota());
	        target.setColor(pet.getColor());
	        target.setContacto(pet.getContacto());
	        target.setDescripcion(pet.getDescripcion());
	        target.setEstado(pet.getEstado());
	        target.setExtraviado(pet.getExtraviado());
	        target.setFechaExtravio(pet.getFechaExtravio());
	        target.setRaza(pet.getRaza());
	        target.setLugarExtravio(pet.getLugarExtravio());
	        target.setRecompensa(pet.getRecompensa());
	        target.setFoto(pet.getFoto());
        } catch (NullPointerException e){
        	System.out.println("No existe la mascota con el Chip específicado ... ");
        }
    }

    /**
     * @param id  
     * @param estado  
     * @return true si se pudo cambiar el estado (si existe el animal), de lo contrario false
     */
    public boolean changeStatus(Chip id , Estado estado ) {
        Mascota target = get(id);
        try {
        	target.setEstado(estado);
        	return true;
        } catch(NullPointerException e){
        	return false;
        }
        
    }

}