package malattia_salvataggio;

import java.io.*;
import metodi.*;
import java.util.ArrayList;

/**
 * Classe che permette di leggere i dati salvati su un file
 * 
 * @author Marta Balduzzi, Sonia Barbieri, Colette Spelta
 * 
 * Classe realizzata da Marta Balduzzi
 */

public class LeggiDaFile 
{
	public static void main (String [] args)
	{
		ArrayList<CartellaSanitaria> mioSalvataggio = new ArrayList();
		
		try
		{
			FileInputStream salvaSuFile = new FileInputStream("Salvataggio.sav");
			ObjectInputStream salvataggio = new ObjectInputStream(salvaSuFile);
			
			mioSalvataggio = (ArrayList<CartellaSanitaria>) salvataggio.readObject();
			
			salvataggio.close();
		}
		catch(Exception e)
		{
			e.printStackTrace(); //Se c'è un errore stampa l'info
		}
	}
}
