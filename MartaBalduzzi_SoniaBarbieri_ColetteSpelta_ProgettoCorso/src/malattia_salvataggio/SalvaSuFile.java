package malattia_salvataggio;

import java.io.*;
import metodi.*;
import java.util.ArrayList;

/**
 * Classe usata per effettuare il salvataggio su un file
 * 
 * @author Marta Balduzzi, Sonia Barbieri, Colette Spelta
 *
 * Classe realizzata da Marta Balduzzi
 */

public class SalvaSuFile 
{
	public static void main (String [] args)
	{
		
		ArrayList<CartellaSanitaria> mioSalvataggio = new ArrayList();
	
		try
		{
			FileOutputStream salvaSuFile = new FileOutputStream("Salvataggio.sav");
			ObjectOutputStream salvataggio = new ObjectOutputStream(salvaSuFile);
			
			salvataggio.writeObject(mioSalvataggio);
			
			salvataggio.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(); //Se c'è un errore stampa l'info
		}
	}
}
