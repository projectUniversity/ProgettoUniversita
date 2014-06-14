package paziente_esami;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Classe che rappresenta gli esami del pazinte con i rispettivi esiti e caratteristiche
 * 
 * @author Balduzzi Marta, Barbieri Sonia, Spelta Colette
 *
 * Classe svolta da Barbieri Sonia
 *
 */
public class Esame
{
	
	/**
	 * COSTANTI
	 */
	public final static String ESAME_PRENOTATO = "PRENOTATO";
	
	/**
	 * ATTRIBUTI
	 */
	private String nomeEsame;
	private String raccomandazione;
	private char tipoEsame;
	GregorianCalendar dataEsame;
	private String viaEsame;
	private String comuneEsame;
	private String provinciaEsame;
	int [] capEsame;
	GregorianCalendar oraEsame;
	ArrayList <Double> esitoPeriodico;
	ArrayList <String> esitoDiagnostico;
	ArrayList <String> esamePeriodico;
	ArrayList <String> esameDiagnostico;
	
	/**
	 * COSTRUTTORE
	 * @param _nomeEsame il nome dell'esame fatto o prenotato
	 * @param _raccomandazione le raccomandazioni pre-esame
	 * @param _tipoEsame il tipo delle'esame (D = diagnostico, P = periodico)
	 * @param _viaEsame la via dove viene svolto l'esame
	 * @param _comuneEsame il comune di dove viene svolto l'esame
	 * @param _provinciaEsame la provincia del comune
	 */
	public Esame (String _nomeEsame, String _raccomandazione, char _tipoEsame, String _viaEsame, String _comuneEsame, String _provinciaEsame)
	{
		nomeEsame = _nomeEsame;
		raccomandazione = _raccomandazione;
		tipoEsame = _tipoEsame;
		dataEsame = new GregorianCalendar();
		viaEsame = _viaEsame;
		comuneEsame = _comuneEsame;
		provinciaEsame = _provinciaEsame;
		capEsame = new int [Paziente.NUM_CAP];
		oraEsame = new GregorianCalendar();
		esitoPeriodico = new ArrayList <Double>();
		esitoDiagnostico = new ArrayList <String>();
		esamePeriodico = new ArrayList <String>();
		esameDiagnostico = new ArrayList <String>();
	}
}
