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
	public final static String [] FATTORE = {"POSITIVO","NEGATIVO"};
	public final static String [] GRUPPO = {"0","A","B","AB"};
	public final static String [] LETTERE = {"A","B","C","D","E","F","G","H","J","K","I","L","M","N","O","P","Q","R","S","T","U","X","Y","W","V","Z"};
	public final static int [] NUMERI = {0,1,2,3,4,5,6,7,8,9};
	public final static int [] POSIZIONE_LETTERE = {0,1,2,3,4,5,8,11,15};
	public final static int [] POSIZIONE_NUMERI = {6,7,9,10,12,1,3,14};
	public final static int NUM_CAP = 5;
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
	
	/**
	 * METODO che controlla se il codice fiscale e' composto da 6 lettere, 2 numeri, 1 lettera, 2 numeri, 1 lettera, 3 numeri, 1 lettera
	 * @return true il codice fisclae e' corretto, altrimenti false
	 */
	public boolean controlloCf()
	{
		
		if(codiceFiscale.length != LUNGH_MAX_CF)
		{
			return false;
		}
		
		else
		{
			for(int i=0; i<codiceFiscale.length; i++)
			{
				for(int j=0; j<POSIZIONE_LETTERE.length; j++)
				{
					while(i == POSIZIONE_LETTERE[j])
					{
						controlloLettera(codiceFiscale[i]);
					}// while delle lettere
				}// for delle lettere
				
				for(int j=0; j<POSIZIONE_NUMERI.length; j++)
				{
					while(i == POSIZIONE_NUMERI[j])
					{
						controlloNumero(codiceFiscale[i]);
					}// while dei numeri
				}// for dei numeri
			}// for del codice fiscale
			
			return true;
		}//else
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
	
	/**
	 * METODO per vedere se un numero di telefono e' gia' presente
	 * @param tel il numero di telefono che inserisco
	 * @return true s eil numero e' gia' presnete, altrimenti false
	 */
	public boolean TelDoppio(int tel)
	{
		for(int numTel: telefoni)
		{
			if(tel == numTel)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * METODO che controlla che il fattore sia positivo o negativo e il gruppo sanguigno sia 0,A,B o AB
	 * @param msg messaggio il controllo fallisce
	 * @return true se il controllo va a buon fine, altrimenti ritorna false
	 */
	public boolean controlloGruppo()
	{
		for(int i=0; i<FATTORE.length; i++)
		{
			if(fattoreRh.equalsIgnoreCase(FATTORE[i]))
			{
				for(int j=0; j<GRUPPO.length; j++)
				{
					if(gruppoSanguigno.equalsIgnoreCase(GRUPPO[j]))
					{
						return true;
					}// if interno
				}// for interno
			}// if esterno
		}// for esterno
		
		return false;
	}
	
	/**
	 * METODO che controlla che la stringa contenga lettere
	 * @param str la stringa che viene controllata
	 * @return true se la stringa contiene lettere, altrimenti false
	 */
	public boolean controlloLettera(String str)
	{
		for(int i=0; i<LETTERE.length; i++)
		{
			while(str.equalsIgnoreCase(LETTERE[i]))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * METODO che controlla che una stringa contenga numeri
	 * @param str la stringa che viene controllata
	 * @return true se la stringa contiene numeri, altrimenti false
	 */
	public boolean controlloNumero(String str)
	{
		for(int i=0; i<NUMERI.length; i++)
		{
			int num = Integer.parseInt(str);

			while(num == NUMERI[i])
			{
				return true;
			}
		}
		
		return false;
	}
}
