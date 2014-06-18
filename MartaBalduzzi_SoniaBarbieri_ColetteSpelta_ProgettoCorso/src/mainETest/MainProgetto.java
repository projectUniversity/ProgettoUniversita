package mainETest;

import java.util.ArrayList;

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
	public static final String[] SCELTE={"Inserimento dei dati del paziente","Prenotazione di un nuovo esame","Inserimento dell'esito di un esame","Inserimento di una nuova malattia","Visualizzazione dei dettagli di una malattia a scelta","Visualizzazione della cartella sanitaria"};
	public static final String BENVENUTO="Benvenuto nel programma della cartella sanitaria";
	public static final String[] ESITO={"Inserimento esito di un esame periodico","Inserimento esito di un esame diagnostico"};
	public static final String COD_FISC="Inserisci il codice fiscale: ";
	public static final String MALATTIA_SCELTA="Digitare il nome della malattia per visualizzare i dettagli";
	
	/*public static final String NOME="Inserisci il nome: ";
	public static final String COGNOME="Inserisci il cognome: ";
	public static final String SESSO="Inserisci il genere (F=femmina, M=maschio): ";
	public static final String ALTEZZA="Inserisci l'altezza (in metri): ";
	public static final String PESO="Inserisci il peso (in kilogrammi): ";
	public static final String RH="Inserisci il fattore Rh del gruppo sanguigno: ";
	public static final String GRUPPO_SANGUIGNO="Inserisci il gruppo sanguigno: ";
	public static final String VIA="Inserisci la via di residenza:via ";
	public static final String COMUNE="Inserisci il comune di residenza: ";
	public static final String PROVINCIA="Inserisci la provincia di residenza: ";
	public static final String COMUNE_NASCITA="Inserisci il comune di nascita: ";
	public static final String PROVINCIA_NASCITA="Inserisci la provincia di nascita: ";
	public static final String ANNO="Inserisci l'anno di nascita: ";
	public static final String MESE="Inserisci il mese di nascita: ";
	public static final String GIORNO="Inserisci il giorno di nascita: ";
	public static final String COD_FISC="Inserisci il codice fiscale: ";
	public static final String CAP="Inserisci il cap di residenza: ";
	public static final String MSG_TELEFONO = "Inserisci il numero di telefono: ";*/
	
	//ATTRIBUTI
	private static boolean finito=false;
	private static Menu myMenu=new Menu(SCELTE);
	private static int scelta;
	private static String nomeMalattia;
	private static CartellaSanitaria cartSan=new CartellaSanitaria();
	private static SalvaELeggi file=new SalvaELeggi();
	private static ArrayList <String> malattia;
	
	/*private static String nome, cognome, fattoreRh,gruppoS,via,comune,provincia,comuneN,provinciaN, codF, telefono;
	private static char sesso;
	private static double peso,altezza;
	private static int anno,mese,giorno,cap, ora, minuti;*/
	
	/**
	 * Metodo main
	 * Questo metodo richiama i vari metodi delle altre classi e fa iniziare il programma
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(BENVENUTO);
		do{
			scelta=myMenu.seleziona();
			switch(scelta){
			case 1:
				System.out.println();
				//Paziente utente=creaUtente();
				file.scritturaUtente();
			//	Paziente.controlloCf();
			break;
			case 2:
				System.out.println();
				file.scritturaEsame();
				//new Esame(InputDati.leggiStringaNonVuota("Inserisci l'esame"),InputDati.leggiStringaNonVuota("Raccomandazioni"),InputDati.leggiChar("tipo esame"),InputDati.leggiIntero("giorno"),InputDati.leggiIntero("mese"),InputDati.leggiIntero("anno"),InputDati.leggiIntero("ora"),InputDati.leggiIntero("min"),InputDati.leggiStringaNonVuota("ospedale"),InputDati.leggiStringaNonVuota("via ospedale"),InputDati.leggiStringaNonVuota("comune ospedale"),InputDati.leggiStringaNonVuota("provincia ospedale"),InputDati.leggiDouble("soglia max"),InputDati.leggiDouble("soglia min"),InputDati.leggiStringaNonVuota("prenotato"));
			break;
			case 3:
				System.out.println();
				file.letturaEsame();
				System.out.println(Esame.toStringPrenotati());
				//String nomeEsame=InputDati.leggiStringaNonVuota(MALATTIA_SCELTA);
				//Esame.aggiungiEsitoDiagnostico(nomeEsame, InputDati.leggiStringaNonVuota("Inserisci l'esito"));
				file.inserisciEsito();
			break;
			case 4:
				System.out.println();
				file.scritturaMalattia();
			break;
			case 5:
				System.out.println();
				file.letturaMalattia();
				malattia=Malattia.aggiungiMalattia();
				for(int i=0;i<malattia.size();i++){
					System.out.println((i+1)+")"+malattia.get(i));
				}
				nomeMalattia=InputDati.leggiStringaNonVuota(MALATTIA_SCELTA);
				Malattia.toStringCompleto(nomeMalattia);
			break;
			case 6:
				System.out.println();
				file.letturaEsame();
				file.letturaMalattia();
				file.letturaUtente();
				System.out.println(cartSan.toString());
			break;
			default:
				System.out.println();
				System.out.println("Grazie per aver utilizzato il nostro programma!");
				finito=true;
			}
		}
		while(!finito);
	}
	
	/*public static Paziente creaUtente()
	{
		nome = InputDati.leggiStringaNonVuota(NOME);
		cognome = InputDati.leggiStringaNonVuota(COGNOME);
		sesso = InputDati.leggiChar(SESSO);
		peso = InputDati.leggiDoubleConMinimo(PESO, 0);
		altezza = InputDati.leggiDoubleConMinimo(ALTEZZA, 0);
		anno = InputDati.leggiIntero(ANNO);
		mese = InputDati.leggiIntero(MESE, 1, 12);
		giorno = InputDati.leggiIntero(GIORNO, 1, 31);
		codF = InputDati.leggiStringaNonVuota(COD_FISC);
		fattoreRh = InputDati.leggiStringaNonVuota(RH);
		gruppoS = InputDati.leggiStringaNonVuota(GRUPPO_SANGUIGNO);
		via = InputDati.leggiStringaNonVuota(VIA);
		comune = InputDati.leggiStringaNonVuota(COMUNE);
		provincia = InputDati.leggiStringaNonVuota(PROVINCIA);
		comuneN = InputDati.leggiStringaNonVuota(COMUNE_NASCITA);
		provinciaN = InputDati.leggiStringaNonVuota(PROVINCIA_NASCITA);
		cap = InputDati.leggiIntero(CAP);
		telefono = InputDati.leggiStringaNonVuota(MSG_TELEFONO);
		
		return new Paziente(nome, cognome, sesso, peso, altezza, anno, mese, giorno, codF, fattoreRh, gruppoS, via, comune, provincia, comuneN, provinciaN, cap, telefono);
	}*/
}
