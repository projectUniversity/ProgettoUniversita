package malattia_salvataggio;

import it.unibs.fp.mylib.InputDati;

import java.io.*;

import paziente_esami.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Classe usata per effettuare il salvataggio su un file
 * 
 * @author Marta Balduzzi, Sonia Barbieri, Colette Spelta
 *
 * Classe realizzata da Marta Balduzzi
 */

public class SalvaELeggi 
{
	/**
	 * COSTANTI
	 */
	private final static String MSG_NOME = "Inserire il nome della malattia: ";
	private final static String MSG_DATA_INIZIO = "Inserire la data di inizio della malattia: ";
	private final static String MSG_DATA_FINE = "Inserire la data di termine della malattia, se presente: ";
	private final static String MSG_SINTOMI = "Inserire i sintomi della malattia: ";
	private final static String MSG_DIAGNOSI = "Indicare la diagnosi finale: ";
	private final static String MSG_ESAMI = "Inserire gli esami indicati per la patologia: ";
	private final static String MSG_TERAPIA = "Indicare la terapia da seguire: ";
	
	private final static String NOME_ESAME = "Inserire il nome dell'esame: ";
	private final static String MSG_RACC = "Inserire eventuali raccomandazioni: ";
	private final static String MSG_TIPO = "Specificare il tipo dell'esame (P = periodico, D = diagnostico): ";
	private final static String MSG_DATA = "Inserire la data in cui si intende fare l'esame: ";
	private final static String MSG_ORA = "Inserire l'ora in cui si intende fare l'esame: ";
	private final static String MSG_OSPEDALE = "Specificare il nome della struttura in cui si intende fare l'esame: ";
	private final static String MSG_VIA = "Specificare la via della struttura sopracitata: ";
	private final static String MSG_COMUNE = "Specificare il comune di appartenenza della struttura sopracitata: ";
	private final static String MSG_PROVINCIA = "Specificare la provincia della struttura sopracitata: ";
	private final static String MSG_ESITO = "Inserire l'esito dell'esame: ";
	
	/**
	 * ATTRIBUTI
	 */
	private static String nomeMalattia;
	private static ArrayList <String> sintomiMalattia;
	private static String sintomo;
	private static ArrayList <String> diagnosiMalattia;
	private static String diagnosi;
	private static ArrayList <String> esamiAssociati;
	private static String esame;
	private static ArrayList <String> terapiaAssociata;
	private static String terapia;
	private static GregorianCalendar dataInizioMalattia;
	private static GregorianCalendar dataFineMalattia;
	
	private static String nomeEsame;
	private static String raccomandazione;
	private static char tipoEsame;
	private static GregorianCalendar dataEsame;
	private static String ospedale;
	private static String viaEsame;
	private static String comuneEsame;
	private static String provinciaEsame;
	private static GregorianCalendar oraEsame;
	
	private static ArrayList <Double> esitoPeriodico;
	private static ArrayList <String> esitoDiagnostico;
	private static double esito_P;
	private static String esito_D;
	
	private static String prenotato; 
	
	
	private FileOutputStream fileout;
	private ObjectOutputStream fout;
	private FileInputStream filein;
	private ObjectInputStream fin;
	private SalvaELeggi malattia ;
	 
	
	
	/**
	 * Metodo che permette di creare una nuova malattia
	 */
	public static void nuovaMalattia ()
	{
		InputDati.leggiStringaNonVuota(MSG_NOME);
		System.out.println(nomeMalattia);
		
		System.out.println(MSG_DATA_INIZIO);
		System.out.println(dataInizioMalattia);
		
		System.out.println(MSG_DATA_FINE);
		System.out.println(dataFineMalattia);
		
		InputDati.leggiStringa(MSG_SINTOMI);
		System.out.println(sintomiMalattia);
		
		InputDati.leggiStringa(MSG_DIAGNOSI);
		System.out.println(diagnosiMalattia);
		
		InputDati.leggiStringa(MSG_ESAMI);
		System.out.println(esamiAssociati);
		
		InputDati.leggiStringa(MSG_TERAPIA);
		System.out.println(terapiaAssociata);	
	}
	
	/**
	 * Metodo per creare un nuovo esame
	 */
	public static void nuovoEsame()
	{
		InputDati.leggiStringaNonVuota(NOME_ESAME);
		System.out.println(nomeEsame);
		
		InputDati.leggiStringa(MSG_RACC);
		System.out.println(raccomandazione);
		
		InputDati.leggiStringaNonVuota(MSG_TIPO);
		System.out.println(tipoEsame);
		
		InputDati.leggiStringaNonVuota(MSG_DATA);
		System.out.println(dataEsame);
		InputDati.leggiStringaNonVuota(MSG_ORA);
		System.out.println(oraEsame);
		
		InputDati.leggiStringaNonVuota(MSG_OSPEDALE);
		System.out.println(ospedale);
		InputDati.leggiStringaNonVuota(MSG_VIA);
		System.out.println(viaEsame);
		InputDati.leggiStringaNonVuota(MSG_COMUNE);
		System.out.println(comuneEsame);
		InputDati.leggiStringaNonVuota(MSG_PROVINCIA);
		System.out.println(provinciaEsame);
		
		prenotato = Esame.ESAME_PRENOTATO;
	}
	
	
	/**
	 * Metodo per inserire l'esito degli esami effettuati
	 */
	public void inserisciEsito()
	{
		if(tipoEsame == Esame.PERIODICO)
		{
			Esame.aggiungiEsitoPeriodico(MSG_ESITO, esito_P);
			prenotato = null;
			System.out.println(esitoPeriodico);
			
		}
		else
			if(tipoEsame == Esame.DIAGNOSTICO)
			{
				Esame.aggiungiEsitoDiagnostico(MSG_ESITO, esito_D);
				prenotato = null;
				System.out.println(esitoDiagnostico);
			}
	}
	
	
	/**
	 * Metodo per scrivere su file e memorizzare i dati
	 */
	public void scrittura()
	{
		try
		{
			
		}
			
	}
	
	
	/**
	 * Metodo per leggere da file
	 */
	public void lettura()
	{
		try
		{
			filein = new FileReader("Salvataggio.txt");
			fin = new BufferedReader(filein);
			while ((s = fin.readLine()) != null)
			{
				System.out.println(s);
			}
			
			fin.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
}
