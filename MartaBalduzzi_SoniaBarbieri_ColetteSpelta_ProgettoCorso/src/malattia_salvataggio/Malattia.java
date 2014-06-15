package malattia_salvataggio;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import it.unibs.fp.mylib.*;

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
	 * COSTANTI
	 */
	private final static String MSG_NOME = "Inserire il nome della malattia: ";
	private final static String MSG_DATA_INIZIO = "Inserire la data di inizio della malattia: ";
	private final static String MSG_DATA_FINE = "Inserire la data di termine della malattia, se presente: ";
	private final static String MSG_SINTOMI = "Inserire i sintomi della malattia: ";
	private final static String MSG_DIAGNOSI = "Indicare la diagnosi finale: ";
	private final static String MSG_ESAMI = "Inserire gli esami indicati per la patologia: ";
	private final static String MSG_TERAPIA = "Indicare la terapia da seguire: ";
	
	
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
		
		giornoInizio = dataInizioMalattia.get(GregorianCalendar.DATE);
		meseInizio = dataInizioMalattia.get(GregorianCalendar.MONTH)+1;
		annoInizio = dataInizioMalattia.get(GregorianCalendar.YEAR);
		giornoFine = dataFineMalattia.get(GregorianCalendar.DATE);
		meseFine = dataFineMalattia.get(GregorianCalendar.MONTH)+1;
		annoFine = dataFineMalattia.get(GregorianCalendar.YEAR);
		
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
	
}
