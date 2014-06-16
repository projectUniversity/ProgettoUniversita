package malattia_salvataggio;

import java.io.*;
import paziente_esami.*;
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
		SalvaSuFile nuovaMalattia;
		SalvaSuFile nuovoEsame;
		
		try
		{
			FileInputStream salvaSuFile = new FileInputStream("Salvataggio.sav");
			ObjectInputStream salvataggio = new ObjectInputStream(salvaSuFile);
			
			nuovaMalattia = (SalvaSuFile) salvataggio.readObject();
			nuovoEsame = (SalvaSuFile) salvataggio.readObject();
			
			salvataggio.close();
		}
		catch(Exception e)
		{
			e.printStackTrace(); //Se c'è un errore stampa l'info
		}
	}
}
