package paziente_esami;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	public final static int GRUPPO_0 = 0;
	public final static String GRUPPO_A = "A";
	public final static String GRUPPO_B = "B";
	public final static String GRUPPO_AB = "AB";
	public final static int NUM_CAP = 5;
	public final static int NUM_TEL = 10;
	public final static int CF_VUOTO = 0;
	public final static int LUNGH_MAX_CF = 16;
	public final static int LARGHEZZA_RIGA = 20;
	
	/**
	 * ATTRIBUTI
	 */
	private String nome;
	private String cognome;
	private char genere;
	private double peso;
	private double altezza;
	GregorianCalendar dataNascita;
	ArrayList <String> codiceFiscale;
	private String viaCasa;
	private String comuneCasa;
	private String provinciaCasa;
	private String comuneNascita;
	private String provinciaNascita;
	int [] capCasa;
	int [] numTelefono;
	ArrayList <Integer> telefoni;
	
	/**
	 * COSTRUTTORE
	 * @param _nome il nome del paziente
	 * @param _cognome il cognome del paziente
	 * @param _genere genere del paziente (M/F)
	 * @param _peso il peso del paziente (ex. 72.5)
	 * @param _altezza l'altezza del paziente (ex. 1.35)
	 * @param _viaCasa la via dell'abitazione
	 * @param _comuneCasa il comune dove abita
	 * @param _provinciaCasa la provincia del comune dove abita
	 * @param _comuneNascita il comune dove e' nato
	 * @param _provinciaNascita òa proovincia del comune di nascita
	 */
	public Paziente(String _nome, String _cognome, char _genere, double _peso, double _altezza, String _viaCasa, String _comuneCasa, String _provinciaCasa, String _comuneNascita, String _provinciaNascita)
	{
		nome = _nome;
		cognome = _cognome;
		genere = _genere;
		peso = _peso;
		altezza = _altezza;
		dataNascita = new GregorianCalendar ();
		codiceFiscale = new ArrayList <String> ();
		viaCasa = _viaCasa;
		comuneCasa = _comuneCasa;
		provinciaCasa = _provinciaCasa;
		comuneNascita = _comuneNascita;
		provinciaNascita = _provinciaNascita;
		capCasa = new int [NUM_CAP];
		numTelefono = new int [NUM_TEL];
		telefoni = new ArrayList <Integer> ();		
	}
	
	//???????????????????????????????????????????????????????????????????????????
	public boolean controlloCodiceFiscale(String msg)
	{
		boolean giusto = false;
		
		if(codiceFiscale.size() == CF_VUOTO || codiceFiscale.size() != LUNGH_MAX_CF)
		{
			giusto = false;
			System.out.println(msg); // Deve stampare un messaggio di errore!
		}
		
		else
		{
			for(int i =0; i<=5; i++)
			{
				if(codiceFiscale.get(i));
				
			}
		}
	}
	
	/**
	 * METODO per la visualizzazione sintetica dei dati del paziente
	 * @return il nome e il cognome del paziente
	 */
	public String toStringSintetico()
	{
		StringBuffer str = new StringBuffer();
		
		str.append(BelleStringhe.centrata("Dati del paziente" + "\n" + "Nome: " + nome + "\n" + "Cognome: " + cognome);
		
		return str.toString();
	}
}
