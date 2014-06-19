package malattia_salvataggio;

import java.io.File;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import it.unibs.fp.mylib.*;

import java.util.*;

/**
 * Classe che rappresenta le malattie del paziente con le relative caratteristiche.
 * 
 * @author Balduzzi Marta, Barbieri Sonia, Spelta Colette
 * 
 * Classe svolta da Balduzzi Marta
 *
 */

public class Malattia implements Serializable 
{	
	/**
	 * ATTRIBUTI
	 */
	private static String nomeMalattia;
	private static GregorianCalendar dataInizioMalattia = new GregorianCalendar();
	private static GregorianCalendar dataFineMalattia = new GregorianCalendar();
	//private static ArrayList <String> sintomiMalattia = new ArrayList<String>();
	private static String sintomo;
	//private static ArrayList <String> diagnosiMalattia = new ArrayList<String>();
	private static String diagnosi;
	//private static ArrayList <String> esamiAssociati = new ArrayList<String>();
	private static String esame;
	//private static ArrayList <String> terapiaAssociata = new ArrayList<String>();
	private static String terapia;

	private static int giornoInizio;
	private static int meseInizio;
	private static int annoInizio;
	private static int giornoFine;
	private static int meseFine;
	private static int annoFine;
	
	private static File salvataggioMalattia = new File("SalvataggioMalattia.dat");
	private static ArrayList<String> elenco;
	
	
	/**
	 * COSTRUTTORE
	 * @param _nomeMalattia Nome della malattia del paziente
	 * @param _dataInizioMalattia Data di inizio della malattia
	 * @param _dataFineMalattia Data di termine della malattia
	 * @param _sintomo String che contiene tutti i sintomi della malattia
	 * @param _diagnosi String che contiene la diagnosi della malattia
	 * @param _esame String che contiene l'elenco degli esami associati alla malattia
	 * @param _terapia String che contiene la terapia da seguire per guarire la malattia
	 */
	public Malattia (String _nomeMalattia, int _giornoInizio, int _meseInizio, int _annoInizio, int _giornoFine, int _meseFine, int _annoFine, String _sintomo, String _diagnosi, String _esame, String _terapia)
	{
		nomeMalattia = _nomeMalattia;
		giornoInizio = _giornoInizio;
		meseInizio = _meseInizio;
		annoInizio = _annoInizio;
		giornoFine = _giornoFine;
		meseFine = _meseFine;
		annoFine = _annoFine;
		sintomo = _sintomo;
		diagnosi = _diagnosi;
		esame = _esame;
		terapia = _terapia;
		/**sintomiMalattia = _sintomiMalattia;
		diagnosiMalattia = _diagnosiMalattia;
		esamiAssociati = _esamiAssociati;
		terapiaAssociata = _terapiaAssociata;**/
	}
	
	/**
	 * Metodi per aggiungere sintomi, diagnosi, esami associati o terapie
	 */
	/**public static void aggiungiSintomi (String nuovoSintomo)
	{
		sintomiMalattia.add(nuovoSintomo);
	}
	
	public static void aggiungiDiagnosi (String nuovaDiagnosi)
	{
		diagnosiMalattia.add(nuovaDiagnosi);
	}
	
	public static void aggiungiEsami (String nuovoEsame)
	{
		esamiAssociati.add(nuovoEsame);
	}
	
	public static void aggiungiTerapia (String nuovaTerapia)
	{
		terapiaAssociata.add(nuovaTerapia);
	}**/
	
	
	/**
	 * Metodo per inserire la data di inizio malattia
	 */
	/**public void inizioMalattia()
	{
		giornoInizio = dataInizioMalattia.get(GregorianCalendar.DATE);
		meseInizio = dataInizioMalattia.get(GregorianCalendar.MONTH)+1;
		annoInizio = dataInizioMalattia.get(GregorianCalendar.YEAR);
	}**/
	
	/**
	 * Metodo per inserire la data di fine malattia
	 */
	/**public void fineMalattia()
	{
		giornoFine = dataFineMalattia.get(GregorianCalendar.DATE);
		meseFine = dataFineMalattia.get(GregorianCalendar.MONTH)+1;
		annoFine = dataFineMalattia.get(GregorianCalendar.YEAR);
	}**/
	
	/**
	 * Metodo per visualizzare un toString sintetico per descrivere la malattia
	 * 
	 * @return Un toString che descrive sinteticamente la malattia
	 */
	public static String toStringSintetico()
	{
		StringBuffer stringa = new StringBuffer();
		stringa.append(BelleStringhe.incornicia("DATI MALATTIA" + "\n" + "Nome: " + nomeMalattia + "\n" + "Data d'inizio: " + giornoInizio +"-" + meseInizio +"-" + annoInizio + "\n" + "Data di termine: " + giornoFine +"-"+ meseFine +"-"+ annoFine));
		return stringa.toString(); 
	}
	
	/**
	 * Metodo per visualizzare un toString completo per descrivere la malattia
	 * 
	 * @return Un toString che descrive in modo completo la malattia
	 */
	public static String toStringCompleto(String nomeDellaMalattia)
	{
		StringBuffer stringa = new StringBuffer();
		stringa.append(BelleStringhe.incornicia("DATI MALATTIA" + "\n" +
						"Nome: " + nomeMalattia + "\n" +
						"Data d'inizio: " + giornoInizio +"-"+ meseInizio +"-"+ annoInizio + "\n" +
						"Data di termine: " + giornoFine +"-"+ meseFine +"-"+ annoFine + "\n" +
						"Sintomi: " + sintomo + "\n" +
						"Diagnosi: " + diagnosi + "\n" +
						"Esami associati: " + esame + "\n" +
						"Terapia da seguire: " + terapia));
		return stringa.toString();
	}
	
	/**
	 * Metodo per memorizzare i nomi di tutte le malattie (Vector di String)
	 * 
	 * @return elenco delle malattie inserite
	 */
	public static ArrayList<String> aggiungiMalattia()  
	{
		for(int i = 0; i < elenco.size(); i++)
		{
			elenco.add(nomeMalattia);
		}
		return elenco;
	}
	
	
	/**
	 * Metodo get del nome della malattia
	 * 
	 * @return String nome della malattia
	 */
	public static String getNomeMalattia() 
	{
		return nomeMalattia;
	}

	/**
	 * Metodo get dei sintomi della malattia
	 * 
	 * @return String sintomi della malattia 
	 */
	public static String getSintomo() 
	{
		return sintomo;
	}

	/**
	 * Metodo get della diagnosi della malattia
	 * 
	 * @return String della diagnosi
	 */
	public static String getDiagnosi() 
	{
		return diagnosi;
	}

	/**
	 * Metodo get degli esami associati alla cura della malattia
	 * 
	 * @return String esami associati alla malattia
	 */
	public static String getEsame() 
	{
		return esame;
	}

	/**
	 * Metodo get della terapia da seguire per la cura della malattia
	 * 
	 * @return String terapia associata alla malattia
	 */
	public static String getTerapia() 
	{
		return terapia;
	}

	/**
	 * Metodo get del numero del giorno d'inizio della malattia
	 * 
	 * @return int giorno di inizio
	 */
	public static int getGiornoInizio() 
	{
		return giornoInizio;
	}

	/**
	 * Metodo get per il mese d'inizio della malattia
	 * 
	 * @return int mese d'inizio
	 */
	public static int getMeseInizio() 
	{
		return meseInizio;
	}

	/**
	 * Metodo get per l'anno di inizio della malattia
	 * 
	 * @return int anno d'inizio
	 */
	public static int getAnnoInizio() 
	{
		return annoInizio;
	}

	/**
	 * Metodo get del giorno di termine della malattia
	 * 
	 * @return int giorno di termine
	 */
	public static int getGiornoFine() 
	{
		return giornoFine;
	}

	/**
	 * Metodo get del mese di termine della malattia
	 * 
	 * @return int mese di termine
	 */
	public static int getMeseFine() 
	{
		return meseFine;
	}

	/**
	 * Metodo get dell'anno di termine della malattia
	 * 
	 * @return int anno di termine 
	 */
	public static int getAnnoFine() 
	{
		return annoFine;
	}
	
	
	
	
}

