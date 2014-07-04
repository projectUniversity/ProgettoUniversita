package mainETest;

import java.io.*;
import java.util.*;

import paziente_esami.*;
import it.unibs.fp.mylib.*;
import malattia_salvataggio.*;
import metodi.*;
import InputSalvataggioEMenu.*;

/**
 * 
 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
 * La classe e' stata curata da Spelta Colette
 *
 */
public class MainProgetto {
	
	//COSTANTI
	public static final String[] SCELTE={"Prenotazione di un nuovo esame","Inserimento dell'esito di un esame","Inserimento di una nuova malattia","Visualizzazione dei dettagli di una malattia a scelta","Visualizzazione della cartella sanitaria"};
	public static final String BENVENUTO="Benvenuto nel programma della cartella sanitaria";
	public static final String[] ESITO={"Inserimento esito di un esame periodico","Inserimento esito di un esame diagnostico"};
	public static final String MALATTIA_SCELTA="Digitare il nome della malattia per visualizzare i dettagli ";
	public static final String ESAME_SCELTA = "Digitare il nome dell'esame per inserirne l'esito: ";
	public static final String MSG="Questa e' la cartella sanitaria del paziente:";
	public static final String CORNICE="_____________________________________________";
	public static final String MSG_NO_CARICAMENTO ="Caricamento fallito. Creazione da zero";
	
	public static final String MSG_NOME = "Inserire il nome della malattia: ";
	public static final String GIORNO_I = "Inserire il giorno di inizio della malattia: ";
	public static final String MESE_I = "Inserire il mese di inizio della malattia: ";
	public static final String ANNO_I = "Inserire l'anno di inizio della malattia: ";
	public static final String GIORNO_F = "Inserire il giorno di termine della malattia: ";
	public static final String MESE_F = "Inserire il mese di termine della malattia: ";
	public static final String ANNO_F = "Inserire l'anno di termine della malattia: ";
	public static final String MSG_SINTOMI = "Inserire i sintomi della malattia: ";
	public static final String MSG_DIAGNOSI = "Indicare la diagnosi finale: ";
	public static final String MSG_ESAMI = "Inserire gli esami indicati per la patologia: ";
	public static final String MSG_TERAPIA = "Indicare la terapia da seguire: ";
	
	public static final String NOME_ESAME = "Inserire il nome dell'esame: ";
	public static final String MSG_RACC = "Inserire eventuali raccomandazioni: ";
	public static final String MSG_TIPO = "Specificare il tipo dell'esame (P = periodico, D = diagnostico): ";
	public static final String MSG_GIORNO = "Inserire il giorno in cui si intende fare l'esame: "; 
	public static final String MSG_MESE = "Inserire il mese in cui si intende fare l'esame: ";
	public static final String MSG_ANNO = "Inserire l'anno in cui si intende fare l'esame: ";
	public static final String MSG_MINUTI = "Inserire i minuti: ";
	public static final String MSG_ORA = "Inserire l'ora in cui si intende fare l'esame: ";
	public static final String MSG_OSPEDALE = "Specificare il nome della struttura in cui si intende fare l'esame: ";
	public static final String MSG_VIA = "Specificare la via della struttura sopracitata: ";
	public static final String MSG_COMUNE = "Specificare il comune di appartenenza della struttura sopracitata: ";
	public static final String MSG_PROVINCIA = "Specificare la provincia della struttura sopracitata: ";
	public static final String MSG_ESITO = "Inserire l'esito dell'esame(null se periodico,0 se diagnostico): ";
	public static final String SOGLIA_MAX = "Inserire il massimo valore che l'esame può presentare (0 se diagnostico): ";
	public static final String SOGLIA_MIN = "Inserire il minimo valore che l'esame deve avere (0 se diagnostico): ";
	public final static String ELENCO_PRENOTATI = "Elenco degli esami prenotati:";
	
	public static final String NOME="Inserisci il nome: ";
	public static final String COGNOME="Inserisci il cognome: ";
	public static final String SESSO="Inserisci il genere (F=femmina, M=maschio): ";
	public static final String ALTEZZA="Inserisci l'altezza (in metri): ";
	public static final String PESO="Inserisci il peso (in kilogrammi): ";
	public static final String RH="Inserisci il fattore Rh del gruppo sanguigno: ";
	public static final String GRUPPO_SANGUIGNO="Inserisci il gruppo sanguigno: ";
	public static final String VIA="Inserisci la via di residenza: via ";
	public static final String COMUNE="Inserisci il comune di residenza: ";
	public static final String PROVINCIA="Inserisci la provincia di residenza: ";
	public static final String COMUNE_NASCITA="Inserisci il comune di nascita: ";
	public static final String PROVINCIA_NASCITA="Inserisci la provincia di nascita: ";
	public static final String ANNO="Inserisci l'anno di nascita: ";
	public static final String MESE="Inserisci il mese di nascita: ";
	public static final String GIORNO="Inserisci il giorno di nascita: ";
	public static final String COD_FISC="Inserisci il codice fiscale: ";
	public static final String CAP="Inserisci il cap di residenza: ";
	public static final String MSG_TELEFONO = "Inserisci il numero di telefono: ";
	
	//ATTRIBUTI
	private static boolean finito=false;
	private static Menu myMenu=new Menu(SCELTE);
	private static int scelta;
	private static String nomeMalattiaScelta;
	
	private static String nome, cognome, fattoreRh,gruppoS,via,comune,provincia,comuneN,provinciaN, codF, telefono;
	private static char sesso;
	private static double peso,altezza;
	private static int anno,mese,giorno,cap;
	
	private static String nomeMalattia;
	private static String sintomo;
	private static String diagnosi;
	private static String esame;
	private static String terapia;
	
	private static int giornoInizio;
	private static int meseInizio;
	private static int annoInizio;
	private static int giornoFine;
	private static int meseFine;
	private static int annoFine;
	
	private static String nomeEsame;
	private static String raccomandazione;
	private static char tipoEsame;
	private static int giornoE,meseE,annoE;
	private static String ospedale;
	private static String viaEsame;
	private static String comuneEsame;
	private static String provinciaEsame;
	private static int oraE,minE;
	private static double sogliaMax; 
	private static double sogliaMin;
	
	private static File salvataggio=new File("Salvataggio.dat");
	private static CartellaSanitaria contenitore=null;
	private static boolean caricato=false;
	private static Paziente utente=null;
	private static ArrayList<Esame> esam=new ArrayList<Esame>();
	private static Esame visita;
	private static ArrayList<Malattia> malattia=new ArrayList<Malattia>();
	
	/**
	 * Metodo main
	 * Questo metodo richiama i vari metodi delle altre classi e fa iniziare il programma
	 * @param args
	 */
	public static void main(String[] args) throws EOFException{
		System.out.println(BENVENUTO);
		
		//caricamento del contenuto del file da contenitore
		if(salvataggio.exists()){
			try{
				contenitore=(CartellaSanitaria)ServizioFile.caricaSingoloOggetto(salvataggio);
				if(contenitore==null){
					System.out.println("Il contenitore è settato a null");
				}
				utente=contenitore.getUtente();
				System.out.println(utente.toStringSintetico());
				if(utente==null){
					System.out.println("Il contenitore è settato a null");
				}
				malattia=contenitore.getMalattia();
				if(malattia==null){
					System.out.println("Il contenitore è settato a null");
				}
				esam=contenitore.getEsame();
				if(esam==null){
					System.out.println("Il contenitore è settato a null");
				}
			}
			catch(ClassCastException e){
				System.out.println("Errore di cast");
			}
			finally{
				if(utente!=null&&malattia!=null&&esam!=null){
					caricato=true;
				}
			}
		}
		if (!caricato){
			System.out.println(MSG_NO_CARICAMENTO);
			utente=creaUtente();
			utente.controlloCf();
		}
		do{
			scelta=myMenu.seleziona();
			switch(scelta){
			case 1:
				System.out.println();
				visita=nuovoEsame();
				esam.add(nuovoEsame());
				visita.aggiungiEsame(esam);
				
			break;
			case 2:
				System.out.println();
				System.out.println(ELENCO_PRENOTATI);
				for(int i=0;i<esam.size();i++){
					System.out.println(esam.get(i).toStringPrenotati());
				}
				String nomeEsame=InputDati.leggiStringaNonVuota(ESAME_SCELTA);
				double esitoP=InputDati.leggiDouble(MSG_ESITO);
				String esitoD=InputDati.leggiStringa(MSG_ESITO);
				visita.aggiungiEsito(nomeEsame, esitoP,esitoD);
			break;
			case 3:
				System.out.println();
				malattia.add(nuovaMalattia());
			break;
			case 4:
				System.out.println();
				for(int i=0;i<malattia.size();i++){
					System.out.println(malattia.get(i).toStringSintetico());
				}
				nomeMalattiaScelta=InputDati.leggiStringaNonVuota(MALATTIA_SCELTA);
				for(int i=0;i<malattia.size();i++){
					System.out.println(malattia.get(i).toStringCompleto(nomeMalattiaScelta));
				}
				
			break;
			case 5:
				System.out.println();
				String cognome=utente.getCognome();
				String nome=utente.getNome();
				
				System.out.println(MSG+" "+cognome.substring(0, 1).toUpperCase()+cognome.substring(1, cognome.length())+" "+nome.substring(0, 1).toUpperCase()+nome.substring(1, nome.length()));
				
				System.out.println(CORNICE);
				System.out.println();
				System.out.println(utente.toStringCompleto());
				for(int i=0;i<malattia.size();i++){
					System.out.println(malattia.get(i).toStringSintetico());
				}
				for(int i=0;i<esam.size();i++){
					System.out.println(String.format(esam.get(i).toStringSintetico(),"/n","/n",esam.get(i).toStringPrenotati()));
				}
			break;
			default:
				//salvataggio del contenitore
				contenitore=new CartellaSanitaria(utente,malattia,esam);
				if(contenitore==null){
					System.out.println("Il contenitore è settato a null");
				}
				ServizioFile.salvaSingoloOggetto(salvataggio, contenitore);
				System.out.println();
				System.out.println("Grazie per aver utilizzato il nostro programma!");
				finito=true;
			}
		}
		while(!finito);
	}
	
	/**
	 * Metodo per creare un nuovo paziente
	 * 
	 * @return nuovo oggetto di tipo Paziente
	 */
	public static Paziente creaUtente(){
		nome=InputDati.leggiStringaNonVuota(NOME);
		cognome=InputDati.leggiStringaNonVuota(COGNOME);
		sesso=InputDati.leggiChar(SESSO);
		peso=InputDati.leggiDoubleConMinimo(PESO, 0);
		altezza=InputDati.leggiDoubleConMinimo(ALTEZZA, 0);
		anno=InputDati.leggiIntero(ANNO);
		mese=InputDati.leggiIntero(MESE, 1, 12);
		giorno=InputDati.leggiIntero(GIORNO, 1, 31);
		codF=InputDati.leggiStringaNonVuota(COD_FISC);
		fattoreRh=InputDati.leggiStringaNonVuota(RH);
		gruppoS=InputDati.leggiStringaNonVuota(GRUPPO_SANGUIGNO);
		via=InputDati.leggiStringaNonVuota(VIA);
		comune=InputDati.leggiStringaNonVuota(COMUNE);
		provincia=InputDati.leggiStringaNonVuota(PROVINCIA);
		comuneN=InputDati.leggiStringaNonVuota(COMUNE_NASCITA);
		provinciaN=InputDati.leggiStringaNonVuota(PROVINCIA_NASCITA);
		cap=InputDati.leggiIntero(CAP);
		telefono=InputDati.leggiStringaNonVuota(MSG_TELEFONO);
		
		Paziente paziente=new Paziente(nome, cognome, sesso, peso, altezza, anno, mese, giorno, codF, fattoreRh, gruppoS, via, comune, provincia, comuneN, provinciaN, cap, telefono);
		return paziente;
	}
	
	/**
	 * Metodo che permette di creare una nuova malattia
	 * 
	 * @return nuovo oggetto di tipo Malattia
	 */
	public static Malattia nuovaMalattia (){
		
		nomeMalattia=InputDati.leggiStringaNonVuota(MSG_NOME);
		giornoInizio=InputDati.leggiIntero(GIORNO_I, 1, 31);
		meseInizio=InputDati.leggiIntero(MESE_I, 1, 12);
		annoInizio=InputDati.leggiIntero(ANNO_I);
		giornoFine=InputDati.leggiIntero(GIORNO_F, 0, 31);
		meseFine=InputDati.leggiIntero(MESE_F, 0, 12);
		annoFine=InputDati.leggiIntero(ANNO_F);
		sintomo=InputDati.leggiStringa(MSG_SINTOMI);
		diagnosi=InputDati.leggiStringa(MSG_DIAGNOSI);
		esame=InputDati.leggiStringa(MSG_ESAMI);
		terapia=InputDati.leggiStringa(MSG_TERAPIA);
		Malattia malattiaRegistrata=new Malattia(nomeMalattia, giornoInizio,meseInizio,annoInizio,giornoFine,meseFine,annoFine,sintomo,diagnosi,esame,terapia);
		
		return malattiaRegistrata;
	}
	
	/**
	 * Metodo per creare un nuovo esame
	 * 
	 * @return nuovo oggetto di tipo Esame
	 */
	public static Esame nuovoEsame(){
		nomeEsame=InputDati.leggiStringaNonVuota(NOME_ESAME);
		raccomandazione=InputDati.leggiStringa(MSG_RACC);
		tipoEsame=InputDati.leggiChar(MSG_TIPO);
		if(tipoEsame!='p'&&tipoEsame!='d'&&tipoEsame!='D'&&tipoEsame!='P'){
			tipoEsame=InputDati.leggiChar(MSG_TIPO);
		}
		Character.toUpperCase(tipoEsame);
		giornoE=InputDati.leggiIntero(MSG_GIORNO, 1, 31);
		meseE=InputDati.leggiIntero(MSG_MESE, 1, 12);
		annoE=InputDati.leggiIntero(MSG_ANNO);
		oraE=InputDati.leggiIntero(MSG_ORA, 0, 23);
		minE=InputDati.leggiIntero(MSG_MINUTI, 0, 59);
		ospedale=InputDati.leggiStringaNonVuota(MSG_OSPEDALE);
		viaEsame=InputDati.leggiStringaNonVuota(MSG_VIA);
		comuneEsame=InputDati.leggiStringaNonVuota(MSG_COMUNE);
		provinciaEsame=InputDati.leggiStringaNonVuota(MSG_PROVINCIA);
		sogliaMax=InputDati.leggiDouble(SOGLIA_MAX);
		sogliaMin=InputDati.leggiDouble(SOGLIA_MIN); 
		
		Esame esame=new Esame(nomeEsame, raccomandazione, tipoEsame, giornoE, meseE, annoE, oraE, minE, ospedale, viaEsame, comuneEsame, provinciaEsame, sogliaMax, sogliaMin);
		return esame;
	}
}
