package model;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Registro implements Serializable {

    /**
	 * 
	 */
	private static String contactRegName = "contact.rgf";
	private static final long serialVersionUID = 6083842885751180665L;

	/**
     * Construye el registro general del programa
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
     */
    public Registro() throws FileNotFoundException, ClassNotFoundException, IOException {
    	mascotas = new ArrayList<Mascota>();
    	usuarios = new ArrayList<Contacto>();

    	leerPersonas();
    	
    	mascotasEnAdopcion = new ArrayList<Chip>();
    }

    /**
     * Contiene todas las mascotas
     * reportadas, pueden ser las mismas aunque
     * con diferente estado, NUNCA va a existir
     * dos mascotas con el mismo estado.
     */
    protected ArrayList <Mascota> mascotas;

    /**
     * Corresponde a una lista de Chip ID de aquellas mascotas
     * de la lista de mascotas que están ofrecidas en adopción
     */
    protected ArrayList <Chip> mascotasEnAdopcion;

    /**
     * Contiene todos los usuarios del sistema
     */
    protected ArrayList <Contacto> usuarios;
    
    /**
     * @param nPet 
     * @return None
     */
    public void add(Mascota nPet) {
        mascotas.add(nPet);
    }

    /**
     * @param nombre 
     * @return Verdadero si se encontró la incidencia, falso si no se encontró -> no se pudo borrar
     */
    public boolean removeNombre(String nombre) {
    	
        for(Mascota pMascota : mascotas){
        	if(pMascota.getNombre().equals(nombre) == true){
        		mascotas.remove(pMascota);
        		return true;
        	}
        }
        
        return false;
    }

    /**
     * @param id : Chip (El chip de la mascota a eliminar)
     * @return true si se pudo borrar (si se encontró) o false si no se pudo borrar
     */
    public boolean remove(Chip id) {
    	
        for(Mascota pMascota : mascotas){
        	if(pMascota.getChip().getID().equals(id.getID()) == true){
        		mascotas.remove(pMascota);
        		return true;
        	}
        }
        return false;
    }

    /**
     * @param tipo : String (Representa el tipo de mascota o animal "perro, gato, etc")
     * @return true si se pudo eliminar, false si no se encontró
     */
    public boolean remove(String tipo) {
    	
        for(Mascota pMascota : mascotas){
        	if(pMascota.getTipoMascota().equals(tipo) == true){
        		mascotas.remove(pMascota);
        		return true;
        	}
        }
        return false;
    }

    /**
     * @return int : Número total de mascotas en el registro
     */
    public int getCantidadMascotas() {
        return mascotas.size();
    }

    /**
     * @param nPet : Referencia de la mascota a publicar en alguna red Social soportada  
     * @param socialNetwork  : Enumerador de los diferentes tipos de redes sociales soportadas
     * @return None
     */
    public void publish(Mascota nPet , Sitios socialNetwork ) {
        // TODO implement here
    }

    /**
     * @param id (Chip de la mascota a colocar en lista de Adopción) 
     * @return None
     */
    public void ponerEnAdopcion(Chip id) {
    	
        for(Mascota pMascota : mascotas){
        	if(pMascota.getChip().getID().equals(id.getID()) == true){
        		mascotasEnAdopcion.add(pMascota.getChip());
        	}
        }
    }

    public void addPersona(Contacto nPersona) throws IOException
    {
    	usuarios.add(nPersona);
    	serializePersonas();
    }

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public ArrayList<Chip> getMascotasEnAdopcion() {
		return mascotasEnAdopcion;
	}

	public void setMascotasEnAdopcion(ArrayList<Chip> mascotasEnAdopcion) {
		this.mascotasEnAdopcion = mascotasEnAdopcion;
	}

	public ArrayList<Contacto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Contacto> usuarios) {
		this.usuarios = usuarios;
	}
	
	private void serializePersonas() throws IOException
	{
	      ObjectOutputStream oos = null;
	        try {
				oos = new ObjectOutputStream(new FileOutputStream(contactRegName));
			} catch (FileNotFoundException e) {
				System.out.println("ERR: Error, no se encontró el archivo de registro de personas ... ");
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	        
	        try {
	        	if(!usuarios.isEmpty()){
					for(Contacto currentUser : usuarios)
						oos.writeObject(currentUser);
	        	}
				
			} catch (IOException e) {
				System.out.println("ERR: Error al intentar escribir en el archivo de registro de personas ... ");
			}
	        
	        oos.close();
	}
	
	private void leerPersonas() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream  oos=null;
	    Contacto currentUser = null;
	    
	    try {
	    	oos = new ObjectInputStream(new FileInputStream(contactRegName));
	    } catch (FileNotFoundException e) {
	    	System.out.println("WARN: Archivo de contactos de sistema no ha sido creado aun ... ");
	    	return;
	    }
	
    	currentUser = new Contacto();
    	if(!usuarios.isEmpty())
    		usuarios.clear();

		 while(currentUser != null)
			{	
			 	try {
			 		currentUser = (Contacto) oos.readObject();
			 		System.out.println(currentUser.toString());
			 		usuarios.add(currentUser);
			 	} catch (IOException e) {
			 		currentUser = null;
			 	} catch(ClassNotFoundException e){
			 		System.out.println("WARN: Archivo de registro de contactos corrupto ... Borrar archivo ... ");
			 		return;
			 	}
			}
	}
	
	public Contacto findByUser(User u)
	{
		for(Contacto persona : usuarios)
		{
			if(persona.getUsuarioAsociado().equals(u))
				return persona;
		}
		return null;
	}
	
	
	   public void leerArchivoRegistroMascotas(String file) throws  ClassNotFoundException, IOException
	    {
	    	ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e1) {
				System.out.println("WARN: Archivo de registro de mascotas " + file + " no encontrado! ... ");
				 return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	// Se inicializa el puntero temporal
	    	Mascota aux=new Mascota ();
	    	// Mientras haya objetos
	    	while (aux != null)
	    	{
	    	    try {
					aux = (Mascota) ois.readObject();
					mascotas.add(aux);
				} catch ( Exception e) {
					aux = null;
				}
	    	}
	    	try {
				ois.close();
			} catch (IOException e) {
				System.out.println("WARN: No se pudo cerrar el flujo de salida de serialización ... ");
			}
	    }
	
}