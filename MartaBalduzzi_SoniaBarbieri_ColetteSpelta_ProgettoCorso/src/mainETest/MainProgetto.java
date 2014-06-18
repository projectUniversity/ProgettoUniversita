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
				//Paziente.controlloCf();
			break;
			case 2:
				System.out.println();
				file.scritturaEsame();
			break;
			case 3:
				System.out.println();
				file.letturaEsame();
				System.out.println(Esame.toStringPrenotati());
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
}
