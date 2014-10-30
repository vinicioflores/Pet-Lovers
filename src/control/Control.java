package control;


import java.io.*;

import model.*;
import view.*;

import java.util.*;

/**
 * 
 */
public class Control {
	private boolean logeado=false;
    /**
     * Es la relación con el módulo de vista, encargado
     * de mostrar los datos al usuario, o sea, implementa 
     * la interfaz gráfica
     */
    private View view;

    /**
     * Es la relación con el módulo generador de datos
     * del sistema, alli se manejan todos los datos de personas y 
     * mascotas
     */
    private Model model;

    /**
     * @param view  
     * @param model  
     * @return 
     */
    public Control(View view , Model model ) {
        this.view = view;
        this.model = model;
    }
    
    public boolean getLogeado(){ return logeado; }
    public void setLogeado(boolean bEstado) { logeado = bEstado; }

    public View  getView() { return view; }
    public Model getModel(){ return model; }
    
    
    public ArrayList <Mascota> leerArchivoRegistroMascotas(String file) throws  ClassNotFoundException, IOException
    {
    	ArrayList <Mascota> regValores = new ArrayList<Mascota>();
    	ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			System.out.println("Archivo de registro de mascotas " + file + " no encontrado! ... Creando uno nuevo ...");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			 oos.writeObject(null);
			 return null;
			//e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	// Se lee el primer objeto
    	Object aux=null;
		
    	try {
    		if(ois != null)
    			aux = ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	            
    	// Mientras haya objetos
    	while (aux!=null)
    	{
    	    if (aux instanceof Persona)
    	        System.out.println(aux.toString());  // Se escribe en pantalla el objeto
    	    try {
				aux = ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Fallo al intentar leer linea de serialización de objeto ... ");
				e.printStackTrace();
			}
    	}
    	try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return regValores;
    }
}