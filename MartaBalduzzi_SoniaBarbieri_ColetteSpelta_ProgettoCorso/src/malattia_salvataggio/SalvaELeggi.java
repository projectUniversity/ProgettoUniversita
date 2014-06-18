package malattia_salvataggio;

import it.unibs.fp.mylib.InputDati;

import java.io.*;
import java.util.*;

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
	private final static String GIORNO_I = "Inserire il giorno di inizio della malattia: ";
	private final static String MESE_I = "Inserire il mese di inizio della malattia: ";
	private final static String ANNO_I = "Inserire l'anno di inizio della malattia: ";
	private final static String GIORNO_F = "Inserire il giorno di termine della malattia: ";
	private final static String MESE_F = "Inserire il mese di termine della malattia: ";
	private final static String ANNO_F = "Inserire l'anno di termine della malattia: ";
	private final static String MSG_SINTOMI = "Inserire i sintomi della malattia: ";
	private final static String MSG_DIAGNOSI = "Indicare la diagnosi finale: ";
	private final static String MSG_ESAMI = "Inserire gli esami indicati per la patologia: ";
	private final static String MSG_TERAPIA = "Indicare la terapia da seguire: ";
	
	private final static String NOME_ESAME = "Inserire il nome dell'esame: ";
	private final static String MSG_RACC = "Inserire eventuali raccomandazioni: ";
	private final static String MSG_TIPO = "Specificare il tipo dell'esame (P = periodico, D = diagnostico): ";
	private final static String MSG_GIORNO = "Inserire il giorno in cui si intende fare l'esame: "; 
	private final static String MSG_MESE = "Inserire il mese in cui si intende fare l'esame: ";
	private final static String MSG_ANNO = "Inserire l'anno in cui si intende fare l'esame: ";
	private final static String MSG_MINUTI = "Inserire i minuti: ";
	private final static String MSG_ORA = "Inserire l'ora in cui si intende fare l'esame: ";
	private final static String MSG_OSPEDALE = "Specificare il nome della struttura in cui si intende fare l'esame: ";
	private final static String MSG_VIA = "Specificare la via della struttura sopracitata: ";
	private final static String MSG_COMUNE = "Specificare il comune di appartenenza della struttura sopracitata: ";
	private final static String MSG_PROVINCIA = "Specificare la provincia della struttura sopracitata: ";
	private final static String MSG_ESITO = "Inserire l'esito dell'esame: ";
	private final static String SOGLIA_MAX = "Inserire il massimo valore che l'esame può presentare: ";
	private final static String SOGLIA_MIN = "Inserire il minimo valore che l'esame deve avere: ";
	
	public static final String NOME="Inserisci il nome: ";
	public static final String COGNOME="Inserisci il cognome: ";
	public static final String SESSO="Inserisci il genere (F=femmina, M=maschio): ";
	public static final String ALTEZZA="Inserisci l'altezza (in metri): ";
	public static final String PESO="Inserisci il peso (in kilogrammi): ";
	public static final String RH="Inserisci il fattore Rh del gruppo sanguigno: ";
	public static final String GRUPPO_SANGUIGNO="Inserisci il gruppo sanguigno: ";
	public static final String VIA="Inserisci la via di residenza: via ";
	public static final String COMUNE="Inserisci il comune di residenza: ";
	public static final String PROVINCIA="Inserisci la provincia di residenza: ";
	public static final String COMUNE_NASCITA="Inserisci il comune di nascita: ";
	public static final String PROVINCIA_NASCITA="Inserisci la provincia di nascita: ";
	public static final String ANNO="Inserisci l'anno di nascita: ";
	public static final String MESE="Inserisci il mese di nascita: ";
	public static final String GIORNO="Inserisci il giorno di nascita: ";
	public static final String COD_FISC="Inserisci il codice fiscale: ";
	public static final String CAP="Inserisci il cap di residenza: ";
	public static final String MSG_TELEFONO = "Inserisci il numero di telefono: ";
	
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
	
	private static int giornoInizio;
	private static int meseInizio;
	private static int annoInizio;
	private static int giornoFine;
	private static int meseFine;
	private static int annoFine;
	
	private static String nomeEsame;
	private static String raccomandazione;
	private static char tipoEsame;
	private static GregorianCalendar dataEsame;
	private static String ospedale;
	private static String viaEsame;
	private static String comuneEsame;
	private static String provinciaEsame;
	private static GregorianCalendar oraEsame;
	private static double sogliaMax; 
	private static double sogliaMin;
	
	private static ArrayList <Double> esitoPeriodico;
	private static ArrayList <String> esitoDiagnostico;
	private static double esito_P;
	private static String esito_D;
	
	private static String prenotato; 
	
	
	private FileOutputStream fileout;
	private ObjectOutputStream fout;
	private FileInputStream filein;
	private ObjectInputStream fin;
	
	private Paziente utente;
	private Malattia patologia;
	private Esame visitaMedica;

	
	
	private static String nome, cognome, fattoreRh,gruppoS,via,comune,provincia,comuneN,provinciaN, codF, telefono;
	private static char sesso;
	private static double peso,altezza;
	private static int anno,mese,giorno,cap, ora, minuti;
	
	/**
	 * Metodo per creare un nuovo paziente
	 * 
	 * @return nuovo oggetto di tipo Paziente
	 */
	public static Paziente creaUtente()
	{
		nome = InputDati.leggiStringaNonVuota(NOME);
		cognome = InputDati.leggiStringaNonVuota(COGNOME);
		sesso = InputDati.leggiChar(SESSO);
		peso = InputDati.leggiDoubleConMinimo(PESO, 0);
		altezza = InputDati.leggiDoubleConMinimo(ALTEZZA, 0);
		anno = InputDati.leggiIntero(ANNO);
		mese = InputDati.leggiIntero(MESE, 1, 12);
		giorno = InputDati.leggiIntero(GIORNO, 1, 31);
		codF = InputDati.leggiStringaNonVuota(COD_FISC);
		fattoreRh = InputDati.leggiStringaNonVuota(RH);
		gruppoS = InputDati.leggiStringaNonVuota(GRUPPO_SANGUIGNO);
		via = InputDati.leggiStringaNonVuota(VIA);
		comune = InputDati.leggiStringaNonVuota(COMUNE);
		provincia = InputDati.leggiStringaNonVuota(PROVINCIA);
		comuneN = InputDati.leggiStringaNonVuota(COMUNE_NASCITA);
		provinciaN = InputDati.leggiStringaNonVuota(PROVINCIA_NASCITA);
		cap = InputDati.leggiIntero(CAP);
		telefono = InputDati.leggiStringaNonVuota(MSG_TELEFONO);
		
		return new Paziente(nome, cognome, sesso, peso, altezza, anno, mese, giorno, codF, fattoreRh, gruppoS, via, comune, provincia, comuneN, provinciaN, cap, telefono);
	}
	
	/**
	 * Metodo che permette di creare una nuova malattia
	 * 
	 * @return nuovo oggetto di tipo Malattia
	 */
	public static Malattia nuovaMalattia ()
	{
		nomeMalattia = InputDati.leggiStringaNonVuota(MSG_NOME);
		
		giornoInizio = InputDati.leggiIntero(GIORNO_I, 1, 31);
		meseInizio = InputDati.leggiIntero(MESE_I, 1, 12);
		annoInizio = InputDati.leggiIntero(ANNO_I);
		giornoFine = InputDati.leggiIntero(GIORNO_F, 0, 31);
		meseFine = InputDati.leggiIntero(MESE_F, 0, 12);
		annoFine = InputDati.leggiIntero(ANNO_F);
		
		sintomo = InputDati.leggiStringa(MSG_SINTOMI);
		Malattia.aggiungiSintomi(sintomo);
		
		diagnosi = InputDati.leggiStringa(MSG_DIAGNOSI);
		Malattia.aggiungiDiagnosi(diagnosi);
		
		esame = InputDati.leggiStringa(MSG_ESAMI);
		Malattia.aggiungiEsami(esame);;
		
		terapia = InputDati.leggiStringa(MSG_TERAPIA);
		Malattia.aggiungiTerapia(terapia);
		
		return new Malattia(nomeMalattia, dataInizioMalattia, dataFineMalattia, sintomiMalattia, diagnosiMalattia, esamiAssociati, terapiaAssociata);
	}
	
	
	/**
	 * Metodo per creare un nuovo esame
	 * 
	 * @return nuovo oggetto di tipo Esame
	 */
	public static Esame nuovoEsame()  
	{
		nomeEsame = InputDati.leggiStringaNonVuota(NOME_ESAME);
		raccomandazione = InputDati.leggiStringa(MSG_RACC);
		tipoEsame = InputDati.leggiChar(MSG_TIPO);
		
		giorno = InputDati.leggiIntero(MSG_GIORNO, 1, 31);
		mese = InputDati.leggiIntero(MSG_MESE, 1, 12);
		anno = InputDati.leggiIntero(MSG_ANNO);
		ora = InputDati.leggiIntero(MSG_ORA, 0, 23);
		minuti = InputDati.leggiIntero(MSG_MINUTI, 0, 59);
		
		ospedale = InputDati.leggiStringaNonVuota(MSG_OSPEDALE);
		viaEsame = InputDati.leggiStringaNonVuota(MSG_VIA);
		comuneEsame = InputDati.leggiStringaNonVuota(MSG_COMUNE);
		provinciaEsame = InputDati.leggiStringaNonVuota(MSG_PROVINCIA);
		
		sogliaMax = InputDati.leggiDouble(SOGLIA_MAX);
		sogliaMin = InputDati.leggiDouble(SOGLIA_MIN); 
		
		prenotato = Esame.ESAME_PRENOTATO;
		
		return new Esame(nomeEsame, raccomandazione, tipoEsame, giorno, mese, anno, ora, minuti, ospedale, viaEsame, comuneEsame, provinciaEsame, sogliaMax, sogliaMin, prenotato);
	}
	
	
	/**
	 * Metodo di tipo void per inserire l'esito degli esami effettuati
	 */
	public static void inserisciEsito()
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
	 * Metodo per scrivere su file e memorizzare i dati del paziente
	 */
	public void scritturaUtente()
	{
		try
		{
			fileout = new FileOutputStream("SalvataggioUtente.dat");
			fout = new ObjectOutputStream(fileout);
			
			utente = SalvaELeggi.creaUtente();
			fout.writeObject(utente);
			
			fout.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo per scrivere su file i dati relativi ad una malattia
	 */
	public void scritturaMalattia()
	{
		try
		{
			fileout = new FileOutputStream("SalvataggioMalattia.dat");
			fout = new ObjectOutputStream(fileout);
			
			patologia = SalvaELeggi.nuovaMalattia();
			fout.writeObject(patologia);
			
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo per memorizzare su file i dati relativi ad un esame
	 */
	public void scritturaEsame()
	{
		try
		{
			fileout = new FileOutputStream("SalvataggioEsame.dat");
			fout = new ObjectOutputStream(fileout);
			
			visitaMedica = SalvaELeggi.nuovoEsame();
			fout.writeObject(visitaMedica);
			
			fout.writeObject(esitoPeriodico);
			fout.writeObject(esitoDiagnostico);
			
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo per leggere da file i dati relativi all'utente
	 */
	public void letturaUtente()
	{
		try
		{
			filein = new FileInputStream("SalvataggioUtente.dat");
			fin = new ObjectInputStream(filein);
			boolean fineFile = false;
			while(!fineFile)
			{
				try
				{
					utente = (Paziente)fin.readObject();
					System.out.println(utente);
					
				}
				catch(EOFException e)
				{
					fineFile = true;
				}
			}
			fin.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	
	/**
	 * Metodo per leggere da file i dati relativi ad una malattia
	 */
	public void letturaMalattia()
	{
		try
		{
			filein = new FileInputStream("SalvataggioMalattia.dat");
			fin = new ObjectInputStream(filein);
			boolean fineFile = false;
			while(!fineFile)
			{
				try
				{
					patologia = (Malattia)fin.readObject();
					System.out.println(patologia);
					
				}
				catch(EOFException e)
				{
					fineFile = true;
				}
			}
			fin.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo per leggere da file i dati relativi ad un esame
	 */
	public void letturaEsame()
	{
		try
		{
			filein = new FileInputStream("SalvataggioEsame.dat");
			fin = new ObjectInputStream(filein);
			boolean fineFile = false;
			while(!fineFile)
			{
				try
				{
					visitaMedica = (Esame)fin.readObject();
					System.out.println(visitaMedica);
				}
				catch(EOFException e)
				{
					fineFile = true;
				}
			}
			fin.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
}
