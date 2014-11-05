package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Contacto;
import model.Model;
import model.User;

public class ControlUsuarios {

	private Model model;
    private ArrayList <User> users ;
	private boolean logeado=false;
	private User usuarioLogeado=null;
	private String userRegName = "users.rgf";
	
	public ControlUsuarios(Model pModel)
	{
		this.model = pModel;
		users = new ArrayList <User>();
	}
	
	public void setupUsersRegister() throws FileNotFoundException, ClassNotFoundException, IOException
	{
        leerUsuariosRegistrados();
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
        		this.usuarioLogeado = pUser;
        		
        		System.out.println("Usuario logeado: " + toString());
        		System.out.println("Contacto asoc: " + model.getRegistro().getUsuarios().get(0));
        		
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
    	if(isLogeado() == true)
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
			System.out.println("ERR: Error, no se encontró el archivo de registro de usuarios ... ");
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
			System.out.println("ERR: Error al intentar escribir en el archivo de registro de usuarios ... ");
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
    
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public boolean isLogeado() {
		return logeado;
	}

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}

	public User getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(User usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	@Override
	public String toString() {
		return "ControlUsuarios [model=" + model + ", users=" + users
				+ ", logeado=" + logeado + ", usuarioLogeado=" + usuarioLogeado
				+ ", userRegName=" + userRegName + "]";
	}
	
}
