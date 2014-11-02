/**
 * Sistema de gesti�n de mascotas perdidas PetLovers
 * 
 * Autor: Vinicio Flores Hern�ndez
 * 
 * TEC - Tecnol�gico de Costa Rica, 2014
 * 
 * Curso IC-2101 - Programaci�n Orientada a Objetos
 * 
 * Prof. Adriana Alv�rez  
 */


// Clase principal del sistema
// Se encarga de arrancar la aplicaci�n

import java.io.FileNotFoundException;
import java.io.IOException;

import view.*;

public class PetLovers {

	private static View GUI = null;
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		GUI = new View();     // Construyo la vista, la cual a su vez construir� al model y al controlador
		GUI.boot();			  // Le doy la orden de iniciarse
	}

}
