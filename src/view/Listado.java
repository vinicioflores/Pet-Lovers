package view;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import model.Chip;
import model.PetColor;
import model.Contacto;
import model.Estado;
import model.Mascota;
import model.Recompensa;

public class Listado extends JList<JLabel> implements JEnlistable {

	public Listado() {
		super();
	}
	
	@Override
	public void JListAddPersonas(ArrayList<Contacto> personas) {
		removeAll();
		int i=0;	
		String values[] = new String[personas.size()];
		try {
			for(Contacto pt : personas){
					values[i] = pt.getPrimerNombre() + " " + pt.getSegundoNombre() + " " + 
			pt.getPrimerApellido() + " " + pt.getSegundoApellido();
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}
	
	@Override
	public void JListAddMascotas(ArrayList <Mascota> mascotas) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}

	@Override
	public void JListDelMascotas(ArrayList <Mascota> mascotas,String target) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(!target.equals(pt.getNombre()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);	
	}

	@Override
	public void JListDelPersonas(ArrayList <Contacto> personas,String target) {

	}
	
	@Override
	public void JListShowPerro(ArrayList <Mascota> mascotas, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(pt.getTipoMascota().equals("Perro"))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);			
	}

	@Override
	public void JListShowGato(ArrayList <Mascota> mascotas, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(pt.getTipoMascota().equals("Gato"))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}

	@Override
	public void JListShowOtro(ArrayList <Mascota> mascotas, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(pt.getTipoMascota().equals("Otro"))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}

	@Override
	public void JListShowFecha(ArrayList <Mascota> mascotas,Date f, boolean modifySrc) {
		
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(pt.getFechaExtravio().equals(f))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}

	@Override
	public void JListShowColor(ArrayList <Mascota> mascotas,PetColor c, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(pt.getPetColor().equals(c))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}
	
	@Override
	public void JListShowLugar(ArrayList <Mascota> mascotas, String lugar, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(lugar.equals(pt.getLugarExtravio()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);	
	}

	@Override
	public void JListShowChip(ArrayList <Mascota> mascotas, Chip chip, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(chip.getID().equals(pt.getChip().getID()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);	
	}
	
	
	@Override
	public void JListShowEstado(ArrayList <Mascota> mascotas,Estado e, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(e.equals(pt.getEstado()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e1) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
		
	}

	@Override
	public void JListShowContacto(ArrayList <Mascota> mascotas,Contacto c, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(c.equals(pt.getContacto()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);		
	}
	
	@Override
	public void JListShowRaza(ArrayList<Mascota> mascotas, String race, boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(race.equals(pt.getRaza()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);	
	}

	@Override
	public void JListShowRecompensa(ArrayList<Mascota> mascotas, Recompensa r,
			boolean modifySrc) {
		removeAll();
		int i=0;	
		String values[] = new String[mascotas.size()];
		try {
			for(Mascota pt : mascotas){
				if(r.equals(pt.getRecompensa()))
					values[i] = pt.getNombre() + " ->  " + pt.getTipoMascota();
				else
					if(modifySrc == true)
						mascotas.remove(pt);
				i++;
			}
		} catch (Exception e) {
			System.out.println("ERR: Error de indexación ... ");
		}
		
		configModel(values);
	}
	
	
	public void configModel(String values[])
	{
		setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		repaint();
	}
	
}
