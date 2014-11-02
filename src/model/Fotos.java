package model;

import java.util.*;

public class Fotos {
	private ArrayList <String> fotosDirs;
	
	Fotos()
	{
		fotosDirs = new ArrayList<String>();
	}
	
	public void add(String newFotoDir)
	{
		try {
			fotosDirs.add(newFotoDir);
		} catch (Exception e)
		{
			System.out.println(" -> Error al intentar agregar nueva foto (directorio) a la lista de class Fotos ... ");
		}
	}
	
	public String get(int index)
	{
		try {
			return fotosDirs.get(index);
		} catch (Exception e)
		{
			return null;
		}
	}
	
	public boolean remove(String FotoDir)
	{
		int i;
		if(fotosDirs == null) return false;
		for(i = 0; fotosDirs.get(i) != null && !fotosDirs.get(i).equals(FotoDir); i++);
		if(fotosDirs.get(i).equals(FotoDir) == true){
			try {
				fotosDirs.remove(i);
				return true;
			} catch(Exception e){
				return false;
			}
		}
		return false;
	}
}
