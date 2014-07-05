package paziente_esami;

import it.unibs.fp.mylib.BelleStringhe;

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
	public final static String SOGLIA = "Il valore %1.2f registrato in data %d/%d/%d non si trova entro l'intervallo di normalita' %1.2f - %1.2f";
	
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
	private ArrayList <Esame> esamePeriodico;
	private ArrayList <Esame> esameDiagnostico;
	private double sogliaMax;
	private double sogliaMin;
	private String prenotato;
	private ArrayList <Esame> esamePrenotato;
	private int i;
	
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
		esamePeriodico = new ArrayList <Esame>();
		esameDiagnostico = new ArrayList <Esame>();
		sogliaMax = _sogliaMax;
		sogliaMin = _sogliaMin;
		prenotato = ESAME_PRENOTATO;
		esamePrenotato = new ArrayList <Esame>();
	}
	
	/**
	 * METODO per aggiungere un esame alla lista degli esami diagnostici o di quelli periodici oppure di quelli prenotati
	 * @param il nuovo esame che aggiungo alla lista corrispondente
	 */
	public void aggiungiEsame(ArrayList<Esame> nuovoEsame)
	{
		if(prenotato == ESAME_PRENOTATO)
		{
			esamePrenotato.addAll(nuovoEsame);
		}
		
		for(int i=0; i<esamePrenotato.size(); i++)
		{
			if((esamePrenotato.get(i).tipoEsame) == DIAGNOSTICO)
			{
				esameDiagnostico.add(esamePrenotato.get(i));
			}
		
			else
			{
				esamePeriodico.add(esamePrenotato.get(i));
			}
		}// for
	}// fine metodo
	
	/**
	 * METODO per aggiungere l'esito di un esame periodico
	 * @param esame il nome dell'esame da ricercare nell'elenco
	 * @param esitoP il valore dell'esito in virgola mobile se si tratta di un esame periodico
	 * @param esitoD il valore dell'esito come una stringa se si tratta di un esame diagnostico
	 */
	public void aggiungiEsito(String esame, double esitoP, String esitoD)
	{
		for(int i=0; i<esamePrenotato.size(); i++)
		{
			if((esamePrenotato.get(i).nomeEsame).equalsIgnoreCase(esame))
			{
				if((esamePrenotato.get(i).tipoEsame) == DIAGNOSTICO)
				{
					esamePrenotato.get(i).esitoDiagnostico.add(esitoD);
					esamePrenotato.get(i).prenotato=null;
				}
				
				else if((esamePrenotato.get(i).tipoEsame) == PERIODICO)
				{
					esamePrenotato.get(i).esitoPeriodico.add(esitoP);
					esamePrenotato.get(i).prenotato=null;
				}
			}// if esterno
		}// for
	}// fine metodo
	
	/**
	 * METODO he verifica se il valore di un esame e' minore del valore minimo consentito o maggiore di quello massimo
	 * @return true se l'esito di un esame e' minore o maggiore degli estremi, altrimenti false
	 */
	public boolean verificaSoglia()
	{
		for(i=0; i<esitoPeriodico.size(); i++)
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
		
		if(tipoEsame == PERIODICO)
		{
			str.append(BelleStringhe.incornicia("DATI ESAME PERIODICO" + "\n" +
												"Esame: " + nomeEsame.toUpperCase() + "  Esito: " + esitoPeriodico + "\n" +
												"Svolto in data " + giorno + "-" + mese + "-" + anno));
		}
		
		else if(tipoEsame == DIAGNOSTICO)
		{
			str.append(BelleStringhe.incornicia("DATI ESAME PERIODICO" + "\n" +
												"Esame: " + nomeEsame.toUpperCase() + "  Esito: " + esitoDiagnostico));
		}	
		
		return str.toString();
	}
	
	/**
	 * METODO per a visualizzazione completa degli esami
	 * @return la stringa completa con la descrizione dell'esame periodico o diagnostico
	 */
	public String toStringCompleto()
	{
		StringBuffer str = new StringBuffer();
		
		if(tipoEsame == PERIODICO)
		{
			str.append(BelleStringhe.incornicia("DATI ESAME PERIODICO" + "\n"+
												"Esame: " + nomeEsame.toUpperCase() + "  Raccomandazioni: " + raccomandazione + "\n" +
												"Esito: " + esitoPeriodico + "  Svolto in data " + giorno + "-" + mese + "-" + anno + "\n" +
												"Alle ore " + ora + ":" + minuti + "  nella struttura " + ospedale.toUpperCase() + " in via " + viaEsame.toUpperCase() + ", " + comuneEsame.toUpperCase() + " (" + provinciaEsame.toUpperCase() + ")" + "\n" +
												"La media degli esiti e': " + mediaEsiti()));
			if(verificaSoglia())
			{
				for(;i<esitoPeriodico.size();i++)
				{
				str.append(String.format("\n" + SOGLIA, esitoPeriodico.get(i), giorno, mese, anno, sogliaMin, sogliaMax));
				}
			}// if interno
		}// if esterno
		
		else if(tipoEsame == DIAGNOSTICO)
		{
			str.append(BelleStringhe.incornicia("DATI ESAME DIAGNOSTICO" + "\n" +
												"Esame: " + nomeEsame.toUpperCase() + "  Raccomandazioni: " + raccomandazione + "\n" +
												"Esito: " + esitoDiagnostico + "  Svolto in data " + giorno + "-" + mese + "-" + anno + "\n" +
												"Alle ore " + ora + ":" + minuti + "  nella struttura " + ospedale.toUpperCase() + " in via " + viaEsame.toUpperCase() + ", " + comuneEsame.toUpperCase() + " (" + provinciaEsame.toUpperCase() + ")"));
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
		str.append("\n" + nomeEsame);

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
