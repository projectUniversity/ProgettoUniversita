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
	public static final String GRUPPO_SANGUIGNO="Inserisci il gruppo sanguigno del sangue: ";
	public static final String VIA="Inserisci la via di residenza: ";
	public static final String COMUNE="Inserisci il comune di residenza: ";
	public static final String PROVINCIA="Inserisci la provincia di residenza: ";
	public static final String COMUNE_NASCITA="Inserisci il comune di nascita: ";
	public static final String PROVINCIA_NASCITA="Inserisci la provincia di nascita: ";
	public static final String ANNO="Inserisci l'anno di nascita: ";
	public static final String MESE="Inserisci il mese di nascita: ";
	public static final String GIORNO="Inserisci il giorno di nascita: ";
	public static final String COD_FISC="Inserisci il codice fiscale: ";
	public static final String CAP="Inserisci il cap di residenza: ";
	public static final String MALATTIA_SCELTA="Digitare il nome della malattia per visualizzare i dettagli";
	
	//ATTRIBUTI
	private static boolean finito=false;
	private static Menu myMenu=new Menu(SCELTE);
	private static int scelta;
	private static int scelta2;
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
				new Paziente(InputDati.leggiStringaNonVuota(NOME),InputDati.leggiStringaNonVuota(COGNOME),InputDati.leggiChar(SESSO),InputDati.leggiDoubleConMinimo(PESO, 0),InputDati.leggiDoubleConMinimo(ALTEZZA, 0),InputDati.leggiIntero(ANNO),InputDati.leggiIntero(MESE, 1, 12),InputDati.leggiIntero(GIORNO, 1, 31),InputDati.leggiStringaNonVuota(COD_FISC),InputDati.leggiStringaNonVuota(RH),InputDati.leggiStringaNonVuota(GRUPPO_SANGUIGNO),InputDati.leggiStringaNonVuota(VIA),InputDati.leggiStringaNonVuota(COMUNE),InputDati.leggiStringaNonVuota(PROVINCIA),InputDati.leggiStringaNonVuota(COMUNE_NASCITA),InputDati.leggiStringaNonVuota(PROVINCIA_NASCITA),InputDati.leggiIntero(CAP));
			break;
			case 2:
				System.out.println();
				//metodi nella classe del salva
			break;
			case 3:
				System.out.println();
				for(int i=0;i<ESITO.length;i++){
					System.out.println((i+1)+")"+ESITO[i]);
				}
				System.out.println(CORNICE);
				scelta2=InputDati.leggiIntero(MSG_SCELTA, 0, ESITO.length);
				switch(scelta2){
				case 1:
					//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
					System.out.println("Hai selezionato l'opzione per inserire l'esito di un esame periodico");
				break;
				case 2:
					//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
					System.out.println("Hai selezionato l'opzione per inserire l'esito di un esame diagnostico");
				break;
				}
			break;
			case 4:
				System.out.println();
				//uso file
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
