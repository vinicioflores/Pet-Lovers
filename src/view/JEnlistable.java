package view;

import java.util.ArrayList;
import java.util.Date;

import model.Chip;
import model.PetColor;
import model.Contacto;
import model.Estado;
import model.Mascota;
import model.Recompensa;

public interface JEnlistable {
	public void JListAddMascotas(ArrayList <Mascota> mascotas);
	public void JListAddPersonas(ArrayList <Contacto> personas);
	public void JListDelMascotas(ArrayList <Mascota> mascotas,String target);
	public void JListDelPersonas(ArrayList <Contacto> mascotas,String target);
	public void JListShowPerro(ArrayList <Mascota> mascotas, boolean modifySrc);
	public void JListShowGato(ArrayList <Mascota> mascotas, boolean modifySrc);
	public void JListShowOtro(ArrayList <Mascota> mascotas, boolean modifySrc);
	public void JListShowFecha(ArrayList <Mascota> mascotas,Date f, boolean modifySrc);
	public void JListShowLugar(ArrayList <Mascota> mascotas, String lugar, boolean modifySrc);
	public void JListShowChip(ArrayList <Mascota> mascotas, Chip chip, boolean modifySrc);
	public void JListShowColor(ArrayList <Mascota> mascotas,PetColor c, boolean modifySrc);
	public void JListShowRaza(ArrayList <Mascota> mascotas, String race, boolean modifySrc);
	public void JListShowEstado(ArrayList <Mascota> mascotas,Estado e, boolean modifySrc);
	public void JListShowContacto(ArrayList <Mascota> mascotas,Contacto c, boolean modifySrc);
	public void JListShowRecompensa(ArrayList <Mascota> mascotas,Recompensa c, boolean modifySrc);
}
