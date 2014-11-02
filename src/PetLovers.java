/**
 * Sistema de gestión de mascotas perdidas PetLovers
 * 
 * Autor: Vinicio Flores Hernández
 * 
 * TEC - Tecnológico de Costa Rica, 2014
 * 
 * Curso IC-2101 - Programación Orientada a Objetos
 * 
 * Prof. Adriana Alvárez  
 */


// Clase principal del sistema
// Se encarga de arrancar la aplicación

import java.io.FileNotFoundException;
import java.io.IOException;

import view.*;

public class PetLovers {

	private static View GUI = null;
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		GUI = new View();     // Construyo la vista, la cual a su vez construirá al model y al controlador
		GUI.boot();			  // Le doy la orden de iniciarse
	}

}
