package control;

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
        
        System.out.println("INFO: Reading ArrayList <User> ... ");
        System.out.println(users.toString());
        System.out.println(model.getRegistro().getUsuarios().toString());
        
        model.getRegistro().leerArchivoRegistroMascotas(petsFileName);
        
        System.out.println("INFO: Reading ArrayList <Mascota> ... ");
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
    
    public void setModel(Model m){ this.model = m; }
    
    
 
    
    public void reportarMascota(ReporteMascota wReporte, String file) throws FileNotFoundException, ClassNotFoundException, IOException
    {
    	Mascota newPet = new Mascota();
    	
    	newPet.setNombre(wReporte.getTextField().getText());
    	Chip newChip = new Chip(String.valueOf(wReporte.getPasswordField().getPassword()));
    	Color newColor = Color.ROJO;
    	
    	switch(wReporte.getComboBox_2().getSelectedIndex())
    	{
	    	case 1:
	    		newColor = Color.ROJO;
	    		break;
	    	case 2:
	    		newColor = Color.NEGRO;
	    		break;
	    	case 3:
	    		newColor = Color.CAFE;
	    		break;
	    	case 4:
	    		newColor = Color.BLANCO;
	    		break;
	    	case 5:
	    		newColor = Color.GRIS;
	    		break;
	    	case 6:
	    		newColor = Color.BEIGE;
	    		break;
    	}
    	
    	newPet.setColor(newColor);
    	newPet.setChip(newChip);
    	
    	if(wReporte.getComboBox().getSelectedIndex() == Razas.Perro.ordinal())
    		newPet.setTipoMascota("Perro");
    	else if(wReporte.getComboBox().getSelectedIndex() == Razas.Gato.ordinal())
    		newPet.setTipoMascota("Gato");
    	else newPet.setTipoMascota("Otro");
    	
    	
    	Raza raza = new Raza();
    	
    	if(newPet.getTipoMascota().equals("Perro"))
    		raza.add(Razas.Perro);
    	else if(newPet.getTipoMascota().equals("Gato"))
    		raza.add(Razas.Gato);
    	else raza.add(Razas.Otro);
    	
    	raza.setRaza(raza.get());
    	newPet.setRaza(raza);
    	newPet.getRaza().setRaza(raza.get());
    	
    	
    	Contacto newContact = model.getRegistro().findByUser(usuarioLogeado);
    	newContact.agregarMascotaEncontrada(newChip);
    	
    	if(wReporte.getChckbxHayRecompensa().isSelected()){
    		newContact.setCondicionCasaCuna(Condicion.REQ_DONACION);
    		newContact.setAceptaRecompensa(true);
    	} else { 
    		newContact.setCondicionCasaCuna(null);
    		newContact.setAceptaRecompensa(false);
    	}
    	
    	newPet.setEstado(new Estado(EstadoTipos.EXTRAVIADO));
    	if(wReporte.getComboBox_3().getSelectedIndex() != EstadoTipos.EXTRAVIADO.ordinal())
    		newPet.setEstado(new Estado(EstadoTipos.ENCONTRADO));
    	
    	if(wReporte.getChckbxHayRecompensa().isSelected() == true){
    		
    		char moneda='0';
    		
    		if(wReporte.getComboBox_4().getSelectedIndex() == 1) moneda = '$';
    		else if(wReporte.getComboBox_4().getSelectedIndex() == 2) moneda = '\u20AC';
    		else moneda = '\u20A1';
    		newPet.setRecompensa(new Recompensa(Float.parseFloat(wReporte.getFormattedTextField().getText()), moneda));
    	
    	}
    		
    	if(wReporte.getComboBox_5().getSelectedIndex() == 1)
    		newPet.setTamaño(Tamaño.MUYPEQUEÑO);
    	else if(wReporte.getComboBox_5().getSelectedIndex() == 2)
    		newPet.setTamaño(Tamaño.PEQUEÑO);
    	else if(wReporte.getComboBox_5().getSelectedIndex() == 3)
    		newPet.setTamaño(Tamaño.MEDIANO);
    	else if(wReporte.getComboBox_5().getSelectedIndex() == 4)
    		newPet.setTamaño(Tamaño.GRANDE);
    	else newPet.setTamaño(Tamaño.MUYGRANDE);
    	
    	
    	newPet.setContacto(newContact);
    	model.getRegistro().add(newPet);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}