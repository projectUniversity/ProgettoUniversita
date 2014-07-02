package paziente_esami;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe che rappresenta gli esami del pazinte con i rispettivi esiti e caratteristiche
 * 
 * @author Balduzzi Marta, Barbieri Sonia, Spelta Colette
 *
 * Classe svolta da Barbieri Sonia
 *
 */
public class Esame implements Serializable
{
	
	//COSTANTI
	public final static String ESAME_PRENOTATO = "PRENOTATO";
	public final static char PERIODICO = 'P';
	public final static char DIAGNOSTICO = 'D';
	public final static String MSG_ASSENTE = "L'esame non e' presente nella lista";
	public final static String ESAME_P_ESITI = "Esame: %s      Esito: %f  svolto in data %d/%d/%d";
	public final static String ESAME_D = "Esame %s     svolto in data %d/%d/%d";
	public final static String RACCOMANDAZIONI = "Esame: %s       Raccomandazioni: %s";
	public final static String ESITI_P_DATA_ORA = "Esito: %1.2f    svolto in data %d/%d/%d   alle ore %d:%d  a %s in via %s, %s (%s)";
	public final static String MEDIA = "La media dei valori registrati e' %1.2f";
	public final static String SOGLIA = "Il valore %1.2f registrao in data %d/%d/%d non si rova entro l'intervallo di normalita' %1.2f - %1.2f";
	public final static String ESITO_D_DATA_ORA = "Esito: %s    svolto in data %d/%d/%d alle ore %d:%d   a %s in via %s, %s (%s)";
	public final static String ELENCO_PRENOTATI = "Elenco degli esami prenotati:";
	public final static String MSG_PRESENTE = "L'esame e' gia' presente in elenco";
	
	//ATTRIBUTI
	private String nomeEsame;
	private String raccomandazione;
	private char tipoEsame;
	private int giorno;
	private int mese;
	private int anno;
	private int ora;
	private int minuti;
	private String ospedale;
	private String viaEsame;
	private String comuneEsame;
	private String provinciaEsame;
	private ArrayList <Double> esitoPeriodico;
	private ArrayList <String> esitoDiagnostico;
	private ArrayList <String> esamePeriodico;
	private ArrayList <String> esameDiagnostico;
	private double sogliaMax;
	private double sogliaMin;
	private String prenotato;
	private ArrayList <String> esamePrenotato;
	
	/**
	 * COSTRUTTORE (con prenotato inizializzato a PRENOTATO)
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
	 */
	public Esame (String _nomeEsame, String _raccomandazione, char _tipoEsame, int _giorno, int _mese, int _anno, int _ora, int _minuti, String _ospedale, String _viaEsame, String _comuneEsame, String _provinciaEsame, double _sogliaMax, double _sogliaMin)
	{
		nomeEsame = _nomeEsame;
		raccomandazione = _raccomandazione;
		tipoEsame = _tipoEsame;
		giorno = _giorno;
		mese = _mese;
		anno = _anno;
		ora = _ora;
		minuti = _minuti;
		ospedale = _ospedale;
		viaEsame = _viaEsame;
		comuneEsame = _comuneEsame;
		provinciaEsame = _provinciaEsame;
		esitoPeriodico = new ArrayList <Double>();
		esitoDiagnostico = new ArrayList <String>();
		esamePeriodico = new ArrayList <String>();
		esameDiagnostico = new ArrayList <String>();
		sogliaMax = _sogliaMax;
		sogliaMin = _sogliaMin;
		prenotato = ESAME_PRENOTATO;
		esamePrenotato = new ArrayList <String>();
	}
	
	/**
	 * COSTRUTTORE (con prenotato inizializzato a null)
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
	 * @param _prenotato e' null se l'esame non e' stato prenotato
	 */
	public Esame (String _nomeEsame, String _raccomandazione, char _tipoEsame, int _giorno, int _mese, int _anno, int _ora, int _minuti, String _ospedale, String _viaEsame, String _comuneEsame, String _provinciaEsame, double _sogliaMax, double _sogliaMin, String _prenotato)
	{
		nomeEsame = _nomeEsame;
		raccomandazione = _raccomandazione;
		tipoEsame = _tipoEsame;
		giorno = _giorno;
		mese = _mese;
		anno = _anno;
		ora = _ora;
		minuti = _minuti;
		ospedale = _ospedale;
		viaEsame = _viaEsame;
		comuneEsame = _comuneEsame;
		provinciaEsame = _provinciaEsame;
		esitoPeriodico = new ArrayList <Double>();
		esitoDiagnostico = new ArrayList <String>();
		esamePeriodico = new ArrayList <String>();
		esameDiagnostico = new ArrayList <String>();
		sogliaMax = _sogliaMax;
		sogliaMin = _sogliaMin;
		prenotato = _prenotato;
		esamePrenotato = new ArrayList <String>();
	}
	
	/**
	 * METODO per aggiungere un esame alla lista degli esami diagnostici o di quelli periodici oppure di quelli prenotati
	 * @param il nuovo esame che aggiungo alla lista corrispondente
	 */
	public void aggiungiEsame(String nuovoEsame)
	{
		if(tipoEsame == DIAGNOSTICO && prenotato == null)
		{
			esamePrenotato.remove(nuovoEsame); //il nuovo esame viene rimosso dalla lista dei prenotati quando viene aggiunto l'esito
			esameDiagnostico.add(nuovoEsame);
		}
		
		else if(tipoEsame == PERIODICO && prenotato == null)
		{
			esamePrenotato.remove(nuovoEsame); //il nuovo esame viene rimosso dalla lista dei prenotati quando viene aggiunto l'esito
			esamePeriodico.add(nuovoEsame);
		}
		else if(prenotato == ESAME_PRENOTATO)
		{
			esamePrenotato.add(nuovoEsame);
		}
	}
	
	/**
	 * METODO per vedere se un esame e' gia' presente nella lista
	 * @param nome il nome dell'esame che cerco nella lista
	 * @return true se l'esame e' gia' presente, altrimenti false
	 */
	public boolean esameDoppio(String nome)
	{
		if(tipoEsame == PERIODICO)
		{
			for(String esame: esamePeriodico)
			{
				if(nome.equalsIgnoreCase(esame))
				{
					return true;
				}
			}
		}
		
		else if(tipoEsame == DIAGNOSTICO)
		{
			for(String esame: esameDiagnostico)
			{
				if(nome.equalsIgnoreCase(esame))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * METODO per aggiungere l'esito di un esame periodico
	 * @param esame il nome dell'esame da ricercare nell'elenco (se non e' presente vi viene aggiunti) per poter aggiungere l'esito
	 * @param esito il valore dell'esito in virgola mobile (si tratta di un esame periodico)
	 * @return il nuovo esame periodico con le relative caratteristiche
	 */
	public Esame aggiungiEsitoPeriodico(String esame, double esito)
	{
		for(int i=0; i<esamePeriodico.size(); i++)
		{
			if(esameDoppio(esame))
			{	
				if(esame.equalsIgnoreCase(esamePeriodico.get(i)))
				{
					prenotato = null;
					esitoPeriodico.add(esito);
				}
			}
			
			else
			{
				prenotato = null;
				aggiungiEsame(esame);
				esitoPeriodico.add(esito);
			}
		}// for
		
		return new Esame(nomeEsame, raccomandazione, tipoEsame, giorno, mese, anno, ora, minuti, ospedale, viaEsame, comuneEsame, provinciaEsame, sogliaMax, sogliaMin, prenotato);
	}// metodo
	
	/**
	 * METODO per aggiungere l'esito di un esame diagnostico
	 * @param esame il nome dell'esame da ricercare nell'elenco (se non e' presente vi viene aggiunto) per poter aggiungere l'esito
	 * @param esito il vaolre dell'esito come stringa (si tratta di un esame diagnostico)
	 * @return il nuovo esame diagnostico con le relative caratteristiche
	 */
	public Esame aggiungiEsitoDiagnostico(String esame, String esito)
	{
		for(int i=0; i<esameDiagnostico.size(); i++)
		{
			if(esameDoppio(esame))
			{
				if(esame.equalsIgnoreCase(esameDiagnostico.get(i)))
				{ 
					prenotato = null;
					esitoDiagnostico.add(esito);
				}
			}
			
			else
			{
				prenotato = null;
				aggiungiEsame(esame);
				esitoDiagnostico.add(esito);
			}
		}// for
		
		return new Esame(nomeEsame, raccomandazione, tipoEsame, giorno, mese, anno, ora, minuti, ospedale, viaEsame, comuneEsame, provinciaEsame, sogliaMax, sogliaMin, prenotato);
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
				str.append(String.format(ESAME_P_ESITI, esamePeriodico.get(i), esitoPeriodico.get(j), giorno, mese, anno));
			}
		}
		
		for(int i=0; i<esameDiagnostico.size(); i++)
		{
			str.append(String.format(ESAME_D, esameDiagnostico.get(i), giorno, mese, anno));
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
			str.append(String.format(RACCOMANDAZIONI, nomeEsame, raccomandazione));
			for(int i=0; i<esitoPeriodico.size(); i++)
			{
				str.append(String.format(ESITI_P_DATA_ORA, esitoPeriodico.get(i), giorno, mese, anno, ora, minuti, ospedale, viaEsame, comuneEsame, provinciaEsame));
				str.append(String.format("\n" + MEDIA, mediaEsiti()));
				if(VerificaSoglia())
				{
					str.append(String.format("\n" + SOGLIA, esitoPeriodico.get(i), giorno, mese, anno, sogliaMin, sogliaMax));
				}// if interno
			}// for
		}// if esterno
		
		if(tipoEsame == DIAGNOSTICO)
		{
			str.append(String.format(RACCOMANDAZIONI, nomeEsame, raccomandazione));
			for(int i=0; i<esitoDiagnostico.size(); i++)
			{
				str.append(String.format("\n" + ESITO_D_DATA_ORA, esitoDiagnostico.get(i), giorno, mese, anno, ora, minuti, ospedale, viaEsame, comuneEsame, provinciaEsame));
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
		str.append(String.format(ELENCO_PRENOTATI));
		for(int i=0; i<esamePrenotato.size(); i++)
		{
			str.append("\n" + esamePrenotato.get(i));
		}

		return str.toString();
	}
	
	/**
	 * METODO per calcolare la media dei valori misurabili di un esame periodico
	 * @return la media dei valori registrati
	 */
	public double mediaEsiti()
	{
		double somma = 0;
		for(int i=0; i<esitoPeriodico.size(); i++)
		{
			somma = somma + esitoPeriodico.get(i);
		}
		
		double media = somma/(esitoPeriodico.size() + 1);
		
		return media;
	}
}
