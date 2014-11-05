package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.*;

import model.*;
import view.*;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 */
public class Control implements ActionListener {
	
	private ControlMascotas driverMascotas;
	private ControlUsuarios driverUsuarios;
	
	
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
     * El constructor de Control se encarga de realizar la instalación/configuración 
     * de los hilos de control, y su respuesta a las solicitudes de la interfaz gráfica
     * 
     * @param view  
     * @param model  
     * @return 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws ClassNotFoundException 
     */
    public Control(View view , Model model) throws FileNotFoundException, IOException, ClassNotFoundException {
    	
        this.view = view;
        this.model = model;
        
        driverUsuarios = new ControlUsuarios(this.model);
        driverUsuarios.setupUsersRegister();
        
        System.out.println("INFO: Leyendo ArrayList <User> ... ");
        System.out.println(driverUsuarios.getUsers().toString());
        System.out.println(model.getRegistro().getUsuarios().toString());
        System.out.println("Usuario logeado: " + driverUsuarios.toString());
        
        driverMascotas = new ControlMascotas(this.model, driverUsuarios.getUsuarioLogeado());
        driverMascotas.setupPetsRegister();
        
        System.out.println("INFO: Leyendo ArrayList <Mascota> ... ");
        System.out.println(model.getRegistro().getMascotas().toString());
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("INFO: -> Notificación a hilo Controller ... ");
		controllerThreadAnalize(arg0.getSource(), arg0);
	}
    
	
	private void controllerThreadAnalize(Object eventSrc, ActionEvent arg0)
	{
		if(view.login == null){
			/*** Si la llamada vino del Botón de Login ***/
			if(eventSrc.equals(view.getBtnControlDeAcceso())){
				try {
					view.login = view.doLogin();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				view.login.setVisible(true);
			}
			
			/*** Si el usuario invocó el Tabloide de noticias público ***/
			else if(eventSrc.equals(view.getBtnTabloidePblico())){
				publicTabloid news = new publicTabloid();
				news.setVisible(true);
			}
			
			else if(eventSrc.equals(view.getMntmSalir())){
					view.window.dispose();
					System.exit(0);
			}
			
			else if(eventSrc.equals(view.getMntmCrditos())){
				view.credits = new Version();
				view.credits.setVisible(true);
			}
		}
		
		else {
			System.out.println("INFO: View.login != nulo ... ");
		
			if(eventSrc.equals(view.login.getBtnIngresar()))
			{
				try {
					if(login(view.login.getTextField().getText(), String.valueOf(view.login.getPasswordField().getPassword()))){
						MainWindow mainWin = view.login.getMainWin();
						mainWin = getView().getLogin().doMainWindow();   
						mainWin.setVisible(true);
		    			mainWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    			driverMascotas.setCurrentLoginUser(getUsuarioLogeado());
					} else { 
						Dialog loginErr =  new Dialog("No se encontró usuario '" + view.login.getTextField().getText()  +"' registrado en el sistema ... ");
						loginErr.setVisible(true);
						loginErr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				view.login.getTextField().setText("");
				view.login.getPasswordField().setText("");
			}
			
			/***** Evento para revisar el perfil de la mascota seleccionada actualmente **/
			else if(view.login.getMainWin() != null && eventSrc.equals(view.login.getMainWin().getVerPerfilButton()))
			{
				Mascota m = model.getRegistro().getMascotas().get( view.login.getMainWin().getList().getSelectedIndex() );
				view.login.getMainWin().ventanaPerfil = new PerfilMascota(this, m);
				view.login.getMainWin().ventanaPerfil.setVisible(true);
				view.login.getMainWin().ventanaPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
	}

	public boolean addPersonas(User relatedUser, String primerNombre, 
    						   String segundoNombre, String primerApellido,
    						   String segundoApellido,String email,String telefono)
    {
		return driverUsuarios.addPersonas(relatedUser, primerNombre, segundoNombre, primerApellido, segundoApellido, email, telefono);
    }
  
    
    /**
     * @param username 
     * @param password 
     * @return true si se pudo logear el usuario, o false si no existe o hubo algun otro error
     */
    public boolean login(String username, String password) 
    {
        return driverUsuarios.login(username, password);
    }
    
    /**
     * Desconecta al usuario actualmente logeado del sistema
     * @return
     */
    public boolean logout()
    {
    	return driverUsuarios.logout();
    }

    /**
     * @param username 
     * @param password 
     * @return
     * @throws IOException 
     */
    public void signup(String username, String password, String nombreCompleto[],String mail, String tel) throws IOException {
        
    		driverUsuarios.signup(username, password, nombreCompleto, mail, tel); 
    	} 
    
    
    public User usersFind(String sUsername, String sPassword)
    {
    	return driverUsuarios.usersFind(sUsername, sPassword);
    }
    
    
    public boolean getLogeado(){ return driverUsuarios.isLogeado(); }
    public void setLogeado(boolean bEstado) { driverUsuarios.setLogeado(bEstado); }
    public void setUsuarioLogeado(User u){ driverUsuarios.setUsuarioLogeado(u); }
    public User getUsuarioLogeado(){  return driverUsuarios.getUsuarioLogeado();  }
    public View  getView() { return view; }
    public Model getModel(){ return model; }
    public void setModel(Model m){ this.model = m; }

	public ControlMascotas getDriverMascotas() {
		return driverMascotas;
	}

	public void setDriverMascotas(ControlMascotas driverMascotas) {
		this.driverMascotas = driverMascotas;
	}
    
}