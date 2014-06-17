package paziente_esami;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import mainETest.MainProgetto;
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
	//COSTANTI
	public final static String [] FATTORE = {"POSITIVO","NEGATIVO"};
	public final static String [] GRUPPO = {"0","A","B","AB"};
	public final static String [] LETTERE = {"A","B","C","D","E","F","G","H","J","K","I","L","M","N","O","P","Q","R","S","T","U","X","Y","W","V","Z"};
	public final static int [] NUMERI = {0,1,2,3,4,5,6,7,8,9};
	public final static int [] POSIZIONE_LETTERE = {0,1,2,3,4,5,8,11,15};
	public final static int [] POSIZIONE_NUMERI = {6,7,9,10,12,13,14};
	public final static int LUNGH_MAX_CF = 16;
	public final static String NOME_COGNOME = "Nome: %s - Cognome: %s";
	public final static String SESSO_PESO_ALTEZZA = "Sesso: %c - Peso: %1.2f - Altezza: %1.2f";
	public final static String NASCITA = "Nato il %d/%d/%d a %s in provincia di %s";
	public final static String DOMICILIO = "Abita in via %s a %s in provicia di %s      CAP  %d";
	public final static String TEL_CF ="Telefono:  %s          Codice Fiscale:  %s";
	public final static String SANGUE = "Gruppo sanguigno: %s %s";
	public final static String CF_SBAGLIATO = "Il codice fiscale inserito non e' corretto. Rinserire il CF: ";
		
	//ATTRIBUTI
	private static String nome;
	private static String cognome;
	private static char sesso;
	private static double peso;
	private static double altezza;
	private static GregorianCalendar dataNascita;
	private static int giorno;
	private static int mese;
	private static int anno;
	private static String codiceFiscale;
	private static String fattoreRh;
	private static String gruppoSanguigno;
	private static String viaCasa;
	private static String comuneCasa;
	private static String provinciaCasa;
	private static String comuneNascita;
	private static String provinciaNascita;
	private static int capCasa;
	private static String telefono;
		
	/**
	 * COSTRUTTORE
	 * @param _nome il nome del paziente
	 * @param _cognome il cognome del paziente
	 * @param _sesso il sesso del paziente (M/F)
	 * @param _peso il peso del paziente (ex. 72.5 kg)
	 * @param _altezza l'altezza del paziente (ex. 1.5 m)
	 * @param _anno l'anno di nascita del paziente
	 * @param _mese il mese in cui e' nato
	 * @param _giorno il giorno in cui e' nato
	 * @param _codiceFiscale il codice fiscale del paziente
	 * @param _fattoreRh il fattore Rh del sangue (positivo/negativo)
	 * @param _gruppoSanguigno il gruppo sanguigno (0,A,B,AB)
	 * @param _viaCasa la via dell'abitazione
	 * @param _comuneCasa il comune di dove abita
	 * @param _provinciaCasa la provincia del comune del domicilio
	 * @param _comuneNascita il comune dove e' nato
	 * @param _provinciaNascita la provincia dove e' nato
	 * @param _capCasa il cap di dove abita
	 * @param _telefono il numero di telefono del paziente
	 */
	public Paziente(String _nome, String _cognome, char _sesso, double _peso, double _altezza, int _anno, int _mese, int _giorno, String  _codiceFiscale, String _fattoreRh, String _gruppoSanguigno, String _viaCasa, String _comuneCasa, String _provinciaCasa, String _comuneNascita, String _provinciaNascita, int _capCasa, String _telefono)
	{
		nome = _nome;
		cognome = _cognome;
		sesso = _sesso;
		peso = _peso;
		altezza = _altezza;
		dataNascita = new GregorianCalendar ();
		anno = _anno;
		mese = _mese;
		giorno = _giorno;
		codiceFiscale = _codiceFiscale;
		fattoreRh = _fattoreRh;
		gruppoSanguigno = _gruppoSanguigno;
		viaCasa = _viaCasa;
		comuneCasa = _comuneCasa;
		provinciaCasa = _provinciaCasa;
		comuneNascita = _comuneNascita;
		provinciaNascita = _provinciaNascita;
		capCasa = _capCasa;
		telefono = _telefono;		
	}
	
	/**
	 * METODO che controlla se il codice fiscale e' composto da 6 lettere, 2 numeri, 1 lettera, 2 numeri, 1 lettera, 3 numeri, 1 lettera
	 * @return il codice fiscale del paziente
	 */
	public static String controlloCf()
	{
		
		if(codiceFiscale.length() != LUNGH_MAX_CF)
		{
			System.out.println(CF_SBAGLIATO);
			codiceFiscale = InputDati.leggiStringaNonVuota(MainProgetto.COD_FISC);
		}
		
		else
		{
			ArrayList <String> codFiscale = new ArrayList <String>();
			codFiscale.add(codiceFiscale);
			for(int i=0; i<codFiscale.size(); i++)
			{
				for(int j=0; j<POSIZIONE_LETTERE.length; j++)
				{
					while(i == POSIZIONE_LETTERE[j])
					{
						controlloLettera(codiceFiscale.substring(i));
						if(controlloLettera(codiceFiscale.substring(i)) == false)
						{
							System.out.println(CF_SBAGLIATO);
							codiceFiscale = InputDati.leggiStringaNonVuota(MainProgetto.COD_FISC);
						}
					}// while delle lettere
				}// for delle lettere
				
				for(int j=0; j<POSIZIONE_NUMERI.length; j++)
				{
					while(i == POSIZIONE_NUMERI[j])
					{
						controlloNumero(codiceFiscale.substring(i));
						if(controlloNumero(codiceFiscale.substring(i)) == false)
						{
							System.out.println(CF_SBAGLIATO);
							codiceFiscale = InputDati.leggiStringaNonVuota(MainProgetto.COD_FISC);
						}
					}// while dei numeri
				}// for dei numeri
			}// for del codice fiscale
		}//else
		return codiceFiscale;
	}
	
	/**
	 * METODO per la visualizzazione sintetica dei dati del paziente (nome e cognome)
	 * @return il nome e il cognome del paziente
	 */
	public String toStringSintetico()
	{
		StringBuffer str = new StringBuffer();
		str.append(BelleStringhe.incornicia("Dati del paziente"));
		str.append(String.format(NOME_COGNOME, nome, cognome));
		return str.toString();
	}
	
	/**
	 * METODO per la visualizzazione completa dei dati anagrafici del paziente
	 * @return tutti i dati anagrafici del paziente
	 */
	public static String toStringCompleto()
	{
		StringBuffer str = new StringBuffer();
		str.append(BelleStringhe.incornicia("Dati anagrafici completi"));
		str.append(String.format(NOME_COGNOME, nome.toUpperCase(), cognome.toUpperCase()));
		str.append(String.format("\n" + SESSO_PESO_ALTEZZA, sesso, peso, altezza));
		str.append(String.format("\n" + NASCITA, giorno, mese, anno, comuneNascita.toUpperCase(), provinciaNascita.toUpperCase()));
		str.append(String.format("\n" + DOMICILIO, viaCasa.toUpperCase(), comuneCasa.toUpperCase(), provinciaCasa.toUpperCase(), capCasa));
		str.append(String.format("\n" + TEL_CF, telefono, codiceFiscale.toUpperCase()));
		str.append(String.format("\n" + SANGUE, gruppoSanguigno.toUpperCase(), fattoreRh.toUpperCase()));
		return str.toString();
	}
	
	/**
	 * METODO che controlla che la stringa contenga lettere
	 * @param str la stringa che viene controllata
	 * @return true se la stringa contiene lettere, altrimenti false
	 */
	public static boolean controlloLettera(String str)
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
	public static boolean controlloNumero(String str)
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
	
	/**
	 * METODO per ottenere informazioni sulla data di nascita
	 */
	public void infoData()
	{
		anno = dataNascita.get(GregorianCalendar.YEAR);
		mese = dataNascita.get(GregorianCalendar.MONTH) + 1; // i mesi iniziano da 0 nel GregorianCalendar
		giorno = dataNascita.get(GregorianCalendar.DATE);
	}

	/**
	 * METODO per prendere il nome del paziente
	 * @return il nome del paziente
	 */
	public static String getNome()
	{
		return nome;
	}
	
	/**
	 * METODO per prendere il cognome del paziente
	 * @return il cognome del paziente
	 */
	public static String getCognome()
	{
		return cognome;
	}
}