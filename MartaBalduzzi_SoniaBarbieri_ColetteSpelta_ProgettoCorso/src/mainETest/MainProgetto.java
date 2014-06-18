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
	public static final String CORNICE="*******************************************************************";
	public static final String MSG_SCELTA="Digitare il numero dell'opzione desiderata --> ";
	public static final String NOME="Inserisci il nome: ";
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
	public static final String TEL="Inserisci il numero di telefono del paziente: ";
	public static final String MALATTIA_SCELTA="Digitare il nome della malattia per visualizzare i dettagli";
	
	//ATTRIBUTI
	private static boolean finito=false;
	private static Menu myMenu=new Menu(SCELTE);
	private static int scelta;
	private static String nomeMalattia;
	private static CartellaSanitaria cartSan=new CartellaSanitaria();
	private static SalvaELeggi file=new SalvaELeggi();
	private static ArrayList <String> malattia;
	
	
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
				file.scritturaUtente();
				System.out.println(Paziente.controlloCf());
				
			break;
			case 2:
				System.out.println();
				file.scritturaEsame();
			break;
			case 3:
				System.out.println();
				System.out.println(Esame.toStringPrenotati());
				file.inserisciEsito();
			break;
			case 4:
				System.out.println();
				file.scritturaMalattia();
			break;
			case 5:
				System.out.println();
				malattia=Malattia.aggiungiMalattia();
				for(int i=0;i<malattia.size();i++){
					System.out.println((i+1)+")"+malattia.get(i));
				}
				nomeMalattia=InputDati.leggiStringaNonVuota(MALATTIA_SCELTA);
				Malattia.toStringCompleto(nomeMalattia);
			break;
			case 6:
				System.out.println();
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
}
