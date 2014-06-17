package malattia_salvataggio;

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

public class Malattia 
{	
	/**
	 * ATTRIBUTI
	 */
	private static String nomeMalattia;
	private static GregorianCalendar dataInizioMalattia;
	private static GregorianCalendar dataFineMalattia;
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
	
	private static Vector<String> elenco;
	
	/**
	 * COSTRUTTORE
	 * @param _nomeMalattia Nome della malattia del paziente
	 */
	public Malattia (String _nomeMalattia)
	{
		nomeMalattia = _nomeMalattia;
		dataInizioMalattia = new GregorianCalendar();
		dataFineMalattia = new GregorianCalendar();
		sintomiMalattia = new ArrayList <String>();
		sintomo = null; 
		diagnosiMalattia = new ArrayList <String>();
		diagnosi = null;
		esamiAssociati = new ArrayList <String>();
		esame = null;
		terapiaAssociata = new ArrayList <String>();
		terapia = null;
		elenco = new Vector<String> ();
	}
	
	/**
	 * Metodi per aggiungere sintomi, diagnosi, esami associati o terapie
	 */
	public void aggiungiSintomi (String nuovoSintomo)
	{
		sintomiMalattia.add(nuovoSintomo);
	}
	
	public void aggiungiDiagnosi (String nuovaDiagnosi)
	{
		diagnosiMalattia.add(nuovaDiagnosi);
	}
	
	public void aggiungiEsami (String nuovoEsame)
	{
		esamiAssociati.add(nuovoEsame);
	}
	
	public void aggiungiTerapia (String nuovaTerapia)
	{
		terapiaAssociata.add(nuovaTerapia);
	}
	
	
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
	 */
	public static String toStringSintetico()
	{
		StringBuffer stringa = new StringBuffer();
		stringa.append(BelleStringhe.incornicia("DATI MALATTIA" + "\n" + "Nome: " + nomeMalattia + "\n" + "Data d'inizio: " + dataInizioMalattia + "\n" + "Data di termine: " + dataFineMalattia));
		return stringa.toString(); 
	}
	
	/**
	 * Metodo per visualizzare un toString completo per descrivere la malattia
	 */
	public String toStringCompleto()
	{
		StringBuffer stringa = new StringBuffer();
		stringa.append(BelleStringhe.incornicia("DATI MALATTIA" + "\n" +
						"Nome: " + nomeMalattia + "\n" +
						"Data d'inizio: " + dataInizioMalattia + "\n" +
						"Data di termine: " + dataFineMalattia + "\n" +
						"Sintomi: " + sintomiMalattia + "\n" +
						"Diagnosi: " + diagnosiMalattia + "\n" +
						"Esami associati: " + esamiAssociati + "\n" +
						"Terapia da seguire: " + terapiaAssociata));
		return stringa.toString();
	}
	
	/**
	 * Metodo per memorizzare i nomi di tutte le malattie (Vector di String)
	 */
	public static void aggiungiMalattia()
	{
		elenco.add(nomeMalattia);
		System.out.println(elenco);
	}
	
}

