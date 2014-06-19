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
	private static ArrayList<String> elenco = (ArrayList)ServizioFile.caricaSingoloOggetto(salvataggioMalattia);
	
	
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
	public Malattia (String _nomeMalattia, GregorianCalendar _dataInizioMalattia, GregorianCalendar _dataFineMalattia, String _sintomo, String _diagnosi, String _esame, String _terapia)
	{
		nomeMalattia = _nomeMalattia;
		dataInizioMalattia = _dataInizioMalattia;
		dataFineMalattia = _dataFineMalattia;
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
	public void inizioMalattia()
	{
		giornoInizio = dataInizioMalattia.get(GregorianCalendar.DATE);
		meseInizio = dataInizioMalattia.get(GregorianCalendar.MONTH)+1;
		annoInizio = dataInizioMalattia.get(GregorianCalendar.YEAR);
	}
	
	/**
	 * Metodo per inserire la data di fine malattia
	 */
	public void fineMalattia()
	{
		giornoFine = dataFineMalattia.get(GregorianCalendar.DATE);
		meseFine = dataFineMalattia.get(GregorianCalendar.MONTH)+1;
		annoFine = dataFineMalattia.get(GregorianCalendar.YEAR);
	}
	
	/**
	 * Metodo per visualizzare un toString sintetico per descrivere la malattia
	 * 
	 * @return Un toString che descrive sinteticamente la malattia
	 */
	public static String toStringSintetico()
	{
		StringBuffer stringa = new StringBuffer();
		stringa.append(BelleStringhe.incornicia("DATI MALATTIA" + "\n" + "Nome: " + nomeMalattia + "\n" + "Data d'inizio: " + dataInizioMalattia + "\n" + "Data di termine: " + dataFineMalattia));
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
						"Data d'inizio: " + dataInizioMalattia + "\n" +
						"Data di termine: " + dataFineMalattia + "\n" +
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
	
	
}

