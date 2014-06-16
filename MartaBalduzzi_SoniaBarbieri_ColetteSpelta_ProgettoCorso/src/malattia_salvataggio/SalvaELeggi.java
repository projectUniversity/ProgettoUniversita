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
	
	private static int giornoInizio;
	private static int meseInizio;
	private static int annoInizio;
	private static int giornoFine;
	private static int meseFine;
	private static int annoFine;
	
	private static String nomeEsame;
	private static String raccomandazione;
	private static char tipoEsame;
	static GregorianCalendar dataEsame;
	private String viaEsame;
	private String comuneEsame;
	private String provinciaEsame;
	int [] capEsame;
	static GregorianCalendar oraEsame;
	ArrayList <Double> esitoPeriodico;
	ArrayList <String> esitoDiagnostico;
	ArrayList <String> esamePeriodico;
	ArrayList <String> esameDiagnostico;
	
	
	FileWriter fileout;
	PrintWriter fout;
	FileReader filein;
	BufferedReader fin;
	String s;
	
	/**
	 * Metodo che permette di creare una nuova malattia
	 */
	public static void nuovaMalattia ()
	{
		System.out.println(MSG_NOME);
		InputDati.leggiStringaNonVuota(nomeMalattia);
		System.out.println(nomeMalattia);
		
		System.out.println(MSG_DATA_INIZIO);
		System.out.println(giornoInizio + "-" + meseInizio + "-" + annoInizio);
		
		System.out.println(MSG_DATA_FINE);
		System.out.println(giornoFine + "-" + meseFine + "-" + annoFine);
		
		System.out.println(MSG_SINTOMI);
		InputDati.leggiStringa(sintomo);
		System.out.println(sintomiMalattia);
		
		System.out.println(MSG_DIAGNOSI);
		InputDati.leggiStringa(diagnosi);
		System.out.println(diagnosiMalattia);
		
		System.out.println(MSG_ESAMI);
		InputDati.leggiStringa(esame);
		System.out.println(esamiAssociati);
		
		System.out.println(MSG_TERAPIA);
		InputDati.leggiStringa(terapia);
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
	}
	
	
	/**
	 * Metodo per scrivere su file e memorizzare i dati
	 */
	public void scrittura()
	{
		try
		{
			fileout = new FileWriter("Salvataggio.txt");
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader tastiera = new BufferedReader(input);
			
			while(!(s = tastiera.readLine()).equals("fine"))
			{
				fout.println(s);
			}
			
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
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
