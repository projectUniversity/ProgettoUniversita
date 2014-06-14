package paziente_esami;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import it.unibs.fp.mylib.*;

/**
 * Classe che rappresenta il paziente con i relativi dati anagrafici
 * 
 * @author Balduzzi Marta, Barbieri Sonia, Spelta Colette
 * 
 * Classe svolta da Barbieri Sonia
 *
 */
public class Paziente
{
	
	/**
	 * COSTANTI
	 */
	public final static String FATTORE_POSITIVO = "POSITIVO";
	public final static String FATTORE_NEGATIVO = "NEGATIVO";
	public final static String GRUPPO_0 = "0";
	public final static String GRUPPO_A = "A";
	public final static String GRUPPO_B = "B";
	public final static String GRUPPO_AB = "AB";
	public final static int NUM_CAP = 5;
	public final static int NUM_TEL = 10;
	public final static int CF_VUOTO = 0;
	public final static int LUNGH_MAX_CF = 16;
	
	/**
	 * ATTRIBUTI
	 */
	private String nome;
	private String cognome;
	private char sesso;
	private double peso;
	private double altezza;
	private GregorianCalendar dataNascita;
	private String [] codiceFiscale;
	private String fattoreRh;
	private String gruppoSanguigno;
	private String viaCasa;
	private String comuneCasa;
	private String provinciaCasa;
	private String comuneNascita;
	private String provinciaNascita;
	private int [] capCasa;
	private ArrayList <Integer> telefoni;
	
	/**
	 * COSTRUTTORE
	 * @param _nome il nome del paziente
	 * @param _cognome il cognome del paziente
	 * @param _sesso il sesso del paziente (M/F)
	 * @param _peso il peso del paziente (ex. 72.5 kg)
	 * @param _altezza l'altezza del paziente (ex. 1.5 m)
	 * @param _fattoreRh il fattore Rh del sangue (positivo/negativo)
	 * @param _gruppoSanguigno il gruppo sanguigno (0,A,B,AB)
	 * @param _viaCasa la via dell'abitazione
	 * @param _comuneCasa il comune di dove abita
	 * @param _provinciaCasa la provincia del comune del domicilio
	 * @param _comuneNascita il comune dove e' nato
	 * @param _provinciaNascita la provincia dove e' nato
	 */
	public Paziente(String _nome, String _cognome, char _sesso, double _peso, double _altezza, String _fattoreRh, String _gruppoSanguigno, String _viaCasa, String _comuneCasa, String _provinciaCasa, String _comuneNascita, String _provinciaNascita)
	{
		nome = _nome;
		cognome = _cognome;
		sesso = _sesso;
		peso = _peso;
		altezza = _altezza;
		dataNascita = new GregorianCalendar ();
		codiceFiscale = new String [LUNGH_MAX_CF];
		fattoreRh = _fattoreRh;
		gruppoSanguigno = _gruppoSanguigno;
		viaCasa = _viaCasa;
		comuneCasa = _comuneCasa;
		provinciaCasa = _provinciaCasa;
		comuneNascita = _comuneNascita;
		provinciaNascita = _provinciaNascita;
		capCasa = new int [NUM_CAP];
		telefoni = new ArrayList <Integer> ();		
	}
	
	//???????????????????????????????????????????????????????????????????????????
	public boolean controlloCf(String msg)
	{
		boolean giusto = false;
		
		if(codiceFiscale.length != LUNGH_MAX_CF)
		{
			giusto = false;
			System.out.println(msg); // Deve stampare un messaggio di errore!
		}
		
		else
		{
			for(int i =0; i<=5; i++)
			{
				if(codiceFiscale[i]);
				
			}
		}
		
		return giusto;
	}
	
	/**
	 * METODO per la visualizzazione sintetica dei dati del paziente (nome e cognome)
	 * @return il nome e il cognome del paziente
	 */
	public String toStringSintetico()
	{
		StringBuffer str = new StringBuffer();
		str.append(BelleStringhe.incornicia("Dati del paziente"));
		str.append("Nome: " + nome);
		str.append("Cognome: " + cognome);
		return str.toString();
	}
	
	/**
	 * METODO per la visualizzazione completa dei dati anagrafici del paziente
	 * @return tutti i dati anagrafici del paziente
	 */
	public String toStringCompleto()
	{
		StringBuffer str = new StringBuffer();
		str.append(BelleStringhe.incornicia("Dati anagrafici completi"));
		str.append("Nome: " + nome);
		str.append("Cognome: " + cognome);
		str.append("Sesso: " + sesso + " - " + "Peso (kg) : " + peso + " - " + "Altezza (m): " + altezza);
		str.append("Nato il: " + dataNascita + " a " + comuneNascita + " in provincia di " + provinciaNascita);
		str.append("Abita in via " + viaCasa + " - " + comuneCasa + "In provincia di: " + provinciaCasa + " CAP: " + capCasa);
		
		for(int i=0; i<codiceFiscale.length; i++)
		{
			str.append("CF: " + codiceFiscale[i].toUpperCase());
		}
		
		str.append("Gruppo sanguigno: " + gruppoSanguigno + fattoreRh);
		
		for(int i=0; i<telefoni.size(); i++)
		{
			str.append("Telefono/i: ");
			int telefono = telefoni.get(i);
			str.append(telefono);
		}
		
		return str.toString();
	}
	
	/**
	 * METODO per aggiungere un numero di telefono
	 * @param nuovoTel il numero di telefono che si vuole aggiungere
	 */
	public void aggiungiTel(int nuovoTel)
	{
		telefoni.add(nuovoTel);
	}
	
	public boolean controlloGruppo()
	{
		boolean giusto = false;
		
		if()
	}
}
