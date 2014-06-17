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
	
	//COSTANTI
	public final static String ESAME_PRENOTATO = "PRENOTATO";
	public final static char PERIODICO = 'P';
	public final static char DIAGNOSTICO = 'D';
	public final static String MSG_ASSENTE = "L'esame non e' presente nella lista";
	
	//ATTRIBUTI
	private String nomeEsame;
	private String raccomandazione;
	private char tipoEsame;
	private GregorianCalendar dataEsame;
	private int giorno;
	private int mese;
	private int anno;
	private int ora;
	private int minuti;
	private String ospedale;
	private String viaEsame;
	private String comuneEsame;
	private String provinciaEsame;
	private GregorianCalendar oraEsame;
	private ArrayList <Double> esitoPeriodico;
	private ArrayList <String> esitoDiagnostico;
	private ArrayList <String> esamePeriodico;
	private ArrayList <String> esameDiagnostico;
	private double sogliaMax;
	private double sogliaMin;
	private String prenotato;
	
	/**
	 * COSTRUTTORE
	 * @param _nomeEsame il nome dell'esame
	 * @param _raccomandazione le raccomandazioni pre-esame
	 * @param _tipoEsame il tipo delle'esame (D = diagnostico, P = periodico)
	 * @param _giorno il giorno in cui deve essere fatto l'esame
	 * @param _mese il mese in ciui fare l'esame
	 * @param _anno l'anno in cui fare l'esame
	 * @param _ora l'ora delle'esame
	 * @param _minuti i minuti dell'esame
	 * @param _ospedale l'ospedale dove viene effettuato l'esame
	 * @param _viaEsame la via dove viene svolto l'esame
	 * @param _comuneEsame il comune di dove viene svolto l'esame
	 * @param _provinciaEsame la provincia del comune
	 * @param _sogliaMax la soglia max per un esito misurabile
	 * @param _sogliaMin la soglia minima per un esito misurabile
	 * @param _prenotato se l'esame e' stato prenotato
	 */
	public Esame (String _nomeEsame, String _raccomandazione, char _tipoEsame, int _giorno, int _mese, int _anno, int _ora, int _minuti, String _ospedale, String _viaEsame, String _comuneEsame, String _provinciaEsame, double _sogliaMax, double _sogliaMin, String _prenotato)
	{
		nomeEsame = _nomeEsame;
		raccomandazione = _raccomandazione;
		tipoEsame = _tipoEsame;
		dataEsame = new GregorianCalendar();
		giorno = _giorno;
		mese = _mese;
		anno = _anno;
		ora = _ora;
		minuti = _minuti;
		ospedale = _ospedale;
		viaEsame = _viaEsame;
		comuneEsame = _comuneEsame;
		provinciaEsame = _provinciaEsame;
		oraEsame = new GregorianCalendar();
		esitoPeriodico = new ArrayList <Double>();
		esitoDiagnostico = new ArrayList <String>();
		esamePeriodico = new ArrayList <String>();
		esameDiagnostico = new ArrayList <String>();
		sogliaMax = _sogliaMax;
		sogliaMin = _sogliaMin;
		prenotato = _prenotato;
	}
	
	/**
	 * METODO per ottenere informazioni rigardo la data e l'ora deòò'esame
	 */
	public void dataOraEsame()
	{
		anno = dataEsame.get(GregorianCalendar.YEAR);
		mese = dataEsame.get(GregorianCalendar.MONTH) + 1;
		giorno = dataEsame.get(GregorianCalendar.DATE);
		ora = oraEsame.get(GregorianCalendar.HOUR);
		minuti = oraEsame.get(GregorianCalendar.MINUTE);
	}
	
	/**
	 * METODO per vedere se un esame e' gia' stato prenotato o meno
	 * @return true se l'esame e' gia' stato prenotato, altrimenti false
	 */
	public boolean prenotazione()
	{
		if(prenotato.equals(ESAME_PRENOTATO))
		{
			return true;
		}
		
		else
		{
			return false; 
		}
	}
	
	/**
	 * METODO per vedere se un esame periodico o diagnostico e' gia' presente nel rispettivo elenco
	 * @param nuovoEsame l'esame che voglio inserire
	 * @return true se il nuovoEsame e' gia' presente nella lista, altrimenti false;
	 */
	public boolean esameDoppio(String nuovoEsame)
	{
		if(tipoEsame == DIAGNOSTICO)
		{
			for(String esame: esameDiagnostico)
			{
				if(nuovoEsame.equalsIgnoreCase(esame))
				{
					return true;
				}
			}// for
		}// if
		
		else if(tipoEsame == PERIODICO)
		{
			for(String esame: esamePeriodico)
			{
				if(nuovoEsame.equalsIgnoreCase(esame))
				{
					return true;
				}
			}// for
		}// else if
		
		return false;
	}
	
	/**
	 * METODO per aggiungere un esame alla lista degli esami diagnostici o di quelli periodici
	 * @param nuovoEsame il nuovo esame che aggiungo alla lista
	 */
	public void aggiungiEsame(String nuovoEsame)
	{
		if(tipoEsame == DIAGNOSTICO)
		{
			esameDiagnostico.add(nuovoEsame);
		}
		
		else if(tipoEsame == PERIODICO)
		{
			esamePeriodico.add(nuovoEsame);
		}
	}
	
	/**
	 * METODO per aggiungere l'esito di un esame periodico
	 * @param esame il nome dell'esame da ricercare nell'elenco per poter aggiungere l'esito
	 * @param esito il valore dell'esito in virgola mobile (si tratta di un esame periodico)
	 */
	public void aggiungiEsitoPeriodico(String esame, double esito)
	{
		for(int i=0; i<esamePeriodico.size(); i++)
		{
			if(esame.equalsIgnoreCase(esamePeriodico.get(i)))
			{
					esitoPeriodico.add(esito);
			}
			
			else
			{
				System.out.println(MSG_ASSENTE);
			}
		}// for
	}// metodo
	
	/**
	 * METODO per aggiungere l'esito di un esame diagnostico
	 * @param esame il nome dell'esame da ricercare nell'elenco per poter aggiungere l'esito
	 * @param esito il vaolre dell'esito come stringa (si tratta di un esame diagnostico)
	 */
	public void aggiungiEsitoDiagnostico(String esame, String esito)
	{
		for(int i=0; i<esameDiagnostico.size(); i++)
		{
			if(esame.equalsIgnoreCase(esameDiagnostico.get(i)))
			{
				esitoDiagnostico.add(esito);
			}
				
			else
			{
				System.out.println(MSG_ASSENTE);
			}
		}// for
	}// metodo
	
	/**
	 * METODO he verifica se il valore di un esame e' minore del valore minimo consentito o maggiore di quello massimo
	 * @return true se l'esito di un esame e' minore o maggiore degli estremi, altrimenti false
	 */
	public boolean VerificaSoglia()
	{
		for(int i=0; i<esitoPeriodico.size(); i++)
		{
			if(esitoPeriodico.get(i) < sogliaMin)
			{
				return true;
			}
			
			else if(esitoPeriodico.get(i) > sogliaMax)
			{
				return true;
			}
		}// for
		
		return false;
	}// metodo
	
	/**
	 * METODO per la visualizzazione sintetica degli esami
	 * @return gli esami con i rispettivi esiti e date
	 */
	public String toStringSintetico()
	{
		StringBuffer str = new StringBuffer();
		for(int i=0; i<esamePeriodico.size(); i++)
		{
			for(int j=0; j<esitoPeriodico.size(); j++)
			{
				str.append("Esame: " + esamePeriodico.get(i) + "esito: " + esitoPeriodico.get(j) + "svolto in data: " + giorno + "/" + mese + "/" + anno);
			}
		}
		
		for(int i=0; i<esameDiagnostico.size(); i++)
		{
			str.append("Esame: " + esameDiagnostico.get(i) + "svolto in data:" + giorno + mese + anno);
		}
		
		return str.toString();
	}
	
	/**
	 * METODO per a visualizzazione completa degli esami
	 * @return la stringa completa con la descrizione dell'esame
	 */
	public String toStringCompleto()
	{
		StringBuffer str = new StringBuffer();
		if(tipoEsame == PERIODICO)
		{
			str.append("Esame: " + nomeEsame + "Raccomandazioni:" + raccomandazione);
			for(int i=0; i<esitoPeriodico.size(); i++)
			{
				str.append("esito: " + esitoPeriodico.get(i) + "svolto in data: " + giorno + "/" + mese + "/" + anno + "alle ore: " + ora + ":" + minuti + "a: " + ospedale + ", " + viaEsame + ", " + comuneEsame + "(" + provinciaEsame + ")");
				if(VerificaSoglia())
				{
					str.append("Il valore " + esitoPeriodico.get(i) + "registrato il " + giorno + "/" + mese + "/" + anno + "non si trova entro l'intervallo di normalita' " + sogliaMin + " - " + sogliaMax);
				}// if interno
			}// for
		}// if esterno
		
		if(tipoEsame == DIAGNOSTICO)
		{
			str.append("Esame: " + nomeEsame + "Raccomandazioni: " + raccomandazione);
			for(int i=0; i<esitoDiagnostico.size(); i++)
			{
				str.append("esito: " + esitoDiagnostico.get(i) + "svolto in data: " + giorno + "/" + mese + "/" + anno + "alle ore: " + ora + ":" + minuti + "a: " + viaEsame + ", " + comuneEsame + "(" + provinciaEsame + ")");
			}
		}
		
		return str.toString();
	}
	
	/**
	 * METODO per visualizzare gli esami prenotati
	 * @return gli esami prenotati
	 */
	public String toStringPrenotati()
	{
		StringBuffer str = new StringBuffer();
		for(int i=0; i<esamePeriodico.size(); i++)
		{
			if(prenotato == ESAME_PRENOTATO)
			{
				str.append("Esame periodico prenotato: " + esamePeriodico.get(i));
			}
		}
			
		for(int i=0; i<esameDiagnostico.size(); i++)
		{
			if(prenotato == ESAME_PRENOTATO)
			{
				str.append("Esame diagnostico prenotato: " + esameDiagnostico.get(i));
			}
		}

		return str.toString();
	}
}
