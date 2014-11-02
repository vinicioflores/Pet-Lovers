package control;

import view.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import model.*;
import view.*;

import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * 
 */
public class Control implements ActionListener {
    private ArrayList <User> users ;
	private boolean logeado=false;
	private User usuarioLogeado=null;
	private String userRegName = "users.rgf";
	private String petsFileName = "pets.rgf";
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
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws ClassNotFoundException 
     */
    public Control(View view , Model model) throws FileNotFoundException, IOException, ClassNotFoundException {
    	super();
        this.view = view;
        this.model = model;
        users = new ArrayList <User>();
        
        leerUsuariosRegistrados();
        
        System.out.println("Reading ArrayList <User> ... ");
        System.out.println(users.toString());
        System.out.println(model.getRegistro().getUsuarios().toString());
        
        leerArchivoRegistroMascotas(petsFileName);
        
        System.out.println("Reading ArrayList <Mascota> ... ");
        System.out.println(model.getRegistro().getMascotas().toString());
    }
    
    private void leerUsuariosRegistrados() throws FileNotFoundException, IOException, ClassNotFoundException
    {    
	    User currentUser = null;
	    ObjectInputStream oos=null;
	    try {
	    	oos = new ObjectInputStream(new FileInputStream(userRegName));
	    } catch (FileNotFoundException e) {
	    	System.out.println("WARN: Archivo de usuarios de sistema no ha sido creado aun ... ");
	    	return;
	    }
	
    	currentUser = new User();
    	if(!users.isEmpty())
    		users.clear();

		 while(currentUser != null)
			{	
			 	try {
			 		currentUser = (User) oos.readObject();
			 		System.out.println(currentUser.toString());
			 		users.add(currentUser);
			 	} catch (IOException e) {
			 		currentUser = null;
			 	}
			}
    }
    
    public boolean getLogeado(){ return logeado; }
    public void setLogeado(boolean bEstado) { logeado = bEstado; }
    
    public void setUsuarioLogeado(User u){ this.usuarioLogeado = u; }
    public User getUsuarioLogeado(){  return this.usuarioLogeado;  }

    public View  getView() { return view; }
    public Model getModel(){ return model; }
    
    
    public ArrayList <Mascota> leerArchivoRegistroMascotas(String file) throws  ClassNotFoundException, IOException
    {
    	ArrayList <Mascota> regValores = new ArrayList<Mascota>();
    	ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			System.out.println("Archivo de registro de mascotas " + file + " no encontrado! ... ");
			 return null;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	// Se lee el primer objeto
    	Mascota aux=null;
    	            
    	// Mientras haya objetos
    	while (aux != null)
    	{
    	    try {
				aux = (Mascota) ois.readObject();
				model.getRegistro().add(aux);
			} catch (IOException e) {
				System.out.println("Fallo al intentar leer linea de serialización de objeto ... ");
				e.printStackTrace();
				aux = null;
			}
    	}
    	try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return regValores;
    }
    
    public void reportarMascota(ReporteMascota wReporte, String file) throws FileNotFoundException, ClassNotFoundException, IOException
    {
    	Mascota newPet = new Mascota();
    	
    	newPet.setNombre(wReporte.getTextField().getText());
    	Chip newChip = new Chip();
    	newChip.setID(String.valueOf(wReporte.getPasswordField().getPassword()));
    	Color newColor = Color.NEGRO;
    	newColor = Color.valueOf(wReporte.getComboBox_2().getName());
    	newPet.setColor(newColor);
    	newPet.setChip(newChip);
    	Contacto newContact = model.getRegistro().findByUser(usuarioLogeado);
    	newContact.agregarMascotaEncontrada(newChip);
    	
    	if(wReporte.getChckbxHayRecompensa().isSelected()){
    		newContact.setCondicionCasaCuna(Condicion.REQ_DONACION);
    		newContact.setAceptaRecompensa(true);
    	} else { 
    		newContact.setCondicionCasaCuna(null);
    		newContact.setAceptaRecompensa(false);
    	}
    	
    	newPet.setContacto(newContact);
    	model.getRegistro().add(newPet);
    
    	int contadorMascotas = 1;
    	ObjectOutputStream ois=null;
		try {
			ois = new ObjectOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		serializeMascotas();
    }
    
    private void serializeMascotas() throws FileNotFoundException, IOException {
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(petsFileName) ); 
		for(Mascota pMascota : model.getRegistro().getMascotas())
		{
			oos.writeObject(pMascota);
		}
		oos.close();
	}

	public boolean addPersonas(User relatedUser, String primerNombre, 
    						String segundoNombre, String primerApellido,
    						String segundoApellido,String email,String telefono)
    {
    	Contacto nPersona = new Contacto();
    	nPersona.setUsuarioAsociado(relatedUser);
    	nPersona.setPrimerNombre(primerNombre);
    	nPersona.setSegundoNombre(segundoNombre);
    	nPersona.setPrimerApellido(primerApellido);
    	nPersona.setSegundoApellido(segundoApellido);
    	nPersona.setCorreo(email);
    	
    	try {
    		nPersona.setTelefono(Integer.parseInt(telefono));
    		model.getRegistro().addPersona(nPersona);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public void agregarRazas(JComboBox listaRazas)
    {
    	
    }
    
    /**
     * @param username 
     * @param password 
     * @return true si se pudo logear el usuario, o false si no existe o hubo algun otro error
     */
    public boolean login(String username, String password) 
    {
        if(exists(username,password)){
        	setLogeado(true);
        	User pUser = usersFind(username,password);
        	if(pUser != null){
        		setUsuarioLogeado(pUser);
        		return true;
        	}
        }
        return false;
        
    }
    
    /**
     * Desconecta al usuario actualmente logeado del sistema
     * @return
     */
    public boolean logout()
    {
    	if(getLogeado() == true)
    		if(getUsuarioLogeado() != null){
    			setLogeado(false);
    			setUsuarioLogeado(null);
    			return true;
    		}
    	return false;
    }

    /**
     * @param username 
     * @param password 
     * @return
     * @throws IOException 
     */
    public void signup(String username, String password, String nombreCompleto[],String mail, String tel) throws IOException {
        
    	User newUser = new User(username,password);
    	try {
    		users.add(newUser);
    	} catch (NullPointerException e){
    		users = new ArrayList<User>();
    		users.add(newUser);
    	} 
    	
    	addPersonas(newUser,nombreCompleto[0],
    			            nombreCompleto[1],
    			    		nombreCompleto[2],
    					    nombreCompleto[3],
    						mail, tel);
        ObjectOutputStream oos = null;
        try {
			oos = new ObjectOutputStream(new FileOutputStream("users.rgf"));
		} catch (FileNotFoundException e) {
			System.out.println("Error, no se encontró el archivo de registro de usuarios ... ");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
        
        try {
        	if(!users.isEmpty()){
        		int k=0;
       
				for(User currentUser : users)
				{
					oos.writeObject(currentUser);
					currentUser = users.get(k);
					k++;
				}
        	}
			
		} catch (IOException e) {
			System.out.println("Error al intentar escribir en el archivo de registro de usuarios ... ");
		}
        
        oos.close();
    }
    
    /**
     * @param username 
     * @return
     */
    private boolean exists(String username, String password) {
    	User target = usersFind(username,password);
    	if(target != null)
    		return users.contains(target);
    	return false;
    }
    
    public User usersFind(String sUsername, String sPassword)
    {
    	for(User pUser : users)
    	{
    		if(pUser.getUsername().equals(sUsername) && pUser.getPassword().equals(sPassword))
    			return pUser;
    	}
    	return null;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}