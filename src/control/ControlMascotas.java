package control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Chip;
import model.Condicion;
import model.Contacto;
import model.Estado;
import model.EstadoTipos;
import model.Mascota;
import model.Model;
import model.PetColor;
import model.Raza;
import model.Razas;
import model.Recompensa;
import model.Tamaño;
import model.User;
import view.ReporteMascota;

public class ControlMascotas {
	
	private String petsFileName = "pets.rgf";	// El nombre de archivo del registro de mascotas
	private Model model = null;					// Puntero al módulo Model
	private User currentLoginUser;
	
	public ControlMascotas(Model pModel, User currentLoginUser)
	{
		this.model = pModel;
		this.currentLoginUser = currentLoginUser;
		System.out.println("INFO: ControlMascotas() User Logged IN:  " + currentLoginUser);
	}
	
	public void setupPetsRegister() throws ClassNotFoundException, IOException
	{
		 model.getRegistro().leerArchivoRegistroMascotas(petsFileName);
	}
	
	 public void reportarMascota(ReporteMascota wReporte, String file) throws FileNotFoundException, ClassNotFoundException, IOException
	    {
	    	Mascota newPet = new Mascota();
	    	
	    	newPet.setNombre(wReporte.getTextField().getText());
	    	Chip newChip = new Chip(String.valueOf(wReporte.getPasswordField().getPassword()));
	    	PetColor newColor = PetColor.ROJO;
	    	
	    	switch(wReporte.getComboBox_2().getSelectedIndex())
	    	{
		    	case 0:
		    		newColor = PetColor.ROJO;
		    		break;
		    	case 1:
		    		newColor = PetColor.NEGRO;
		    		break;
		    	case 2:
		    		newColor = PetColor.CAFE;
		    		break;
		    	case 3:
		    		newColor = PetColor.BLANCO;
		    		break;
		    	case 4:
		    		newColor = PetColor.GRIS;
		    		break;
		    	case 5:
		    		newColor = PetColor.BEIGE;
		    		break;
	    	}
	    	
	    	newPet.setPetColor(newColor);
	    	newPet.setChip(newChip);
	    	
	    	if(wReporte.getComboBox().getSelectedIndex() == Razas.Perro.ordinal())
	    		newPet.setTipoMascota("Perro");
	    	else if(wReporte.getComboBox().getSelectedIndex() == Razas.Gato.ordinal())
	    		newPet.setTipoMascota("Gato");
	    	else newPet.setTipoMascota("Otro");
	    	
	    	newPet.setLugarExtravio(wReporte.getTextField_4().getText());
	    	
	    	Raza mapRaza = new Raza();
	    	
	    	if(newPet.getTipoMascota().equals("Perro"))
	    		newPet.setRaza(mapRaza.get_perro(wReporte.getRazaComboBox().getSelectedIndex()));
	    	else if(newPet.getTipoMascota().equals("Gato"))
	    		newPet.setRaza(mapRaza.get_gato(wReporte.getRazaComboBox().getSelectedIndex()));
	    	else newPet.setRaza("");
	    	
	    	newPet.setFoto(wReporte.getFotoTextField().getText());
	    	
	    	System.out.println("INFO: current user logged: " + currentLoginUser);
	    	Contacto newContact = model.getRegistro().findByUser(currentLoginUser);
	    	
	    	if(wReporte.getChckbxHayRecompensa().isSelected()){
	    		newContact.setCondicionCasaCuna(Condicion.REQ_DONACION);
	    		newContact.setAceptaRecompensa(true);
	    	} else { 
	    		newContact.setCondicionCasaCuna(null);
	    		newContact.setAceptaRecompensa(false);
	    	}
	    	
	    	newPet.setEstado(new Estado(EstadoTipos.EXTRAVIADO));
	    	newPet.setExtraviado(true);
	    	newPet.getEstado().setFecha(newPet.getFechaExtravio());
	    	
	    	if(wReporte.getComboBox_3().getSelectedIndex() != EstadoTipos.EXTRAVIADO.ordinal()){
	    		newPet.setEstado(new Estado(EstadoTipos.ENCONTRADO));
	    		newPet.setExtraviado(false);
	    	}
	    	
	       	/** 
	    	 * Si la persona lo encontró agregamos el chip de dicho animal
	    	 * a su récord de animales hallados.
	    	 */
	    	if(newPet.getEstado().getEstado() == EstadoTipos.ENCONTRADO)
	    		newContact.agregarMascotaEncontrada(newChip);
	    	
	    	
	    	if(wReporte.getChckbxHayRecompensa().isSelected() == true){
	    		
	    		char[] monedaMap = {'$', '\u20AC', '\u20A1'};
	    		newPet.setRecompensa(new Recompensa(Float.parseFloat(wReporte.getFormattedTextField().getText()), 
	    				monedaMap[wReporte.getComboBox_4().getSelectedIndex()]));
	    	
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
	    	
	    	newPet.setDescripcion(wReporte.getEditorPane().getText());
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

		public User getCurrentLoginUser() {
			return currentLoginUser;
		}

		public void setCurrentLoginUser(User currentLoginUser) {
			this.currentLoginUser = currentLoginUser;
		}
	
	
}
