package mainETest;

import InputSalvataggioEMenu.Menu;

/**
 * 
 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
 * La classe e' stata curata da Spelta Colette
 *
 */
public class MainProgetto {
	
	/**
	 *COSTANTI 
	 */
	public static final String[] scelte={"Inserisci i dati dell'utente","Prenota un nuovo esame","Inserisci l'esito di un esame","Inserisci una nuova malattia","Visualizza una malattia a scelta","Visualizza la cartella sanitaria"};
	public static final String BENVENUTO="Benvenuto nel programma della cartella sanitaria";
	
	/**
	 * ATTRIBUTI
	 */
	private static boolean finito=false;
	private static Menu myMenu=new Menu(scelte);
	private static int scelta;
	
	/**
	 * METODI
	 */
	public static void main(String[] args){
		System.out.println(BENVENUTO);
		do{
			scelta=myMenu.seleziona();
			switch(scelta){
			case 1:
				System.out.println();
				//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
				System.out.println("Hai selezionato l'opzione per inserire i dati dell'utente");
			break;
			case 2:
				System.out.println();
				//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
				System.out.println("Hai selezionato l'opzione per la prenotazione di un esame");
			break;
			case 3:
				System.out.println();
				//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
				System.out.println("Hai selezionato l'opzione per inserire l'esito di un esame");
			break;
			case 4:
				System.out.println();
				//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
				System.out.println("Hai selezionato l'opzione per inserire una malattia");
			break;
			case 5:
				System.out.println();
				//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
				System.out.println("Hai selezionato l'opzione per scegliere la malattia da visualizzare");
			break;
			case 6:
				System.out.println();
				//Queste stringhe verranno tolte, mi servono solo per controllare il funzionamento
				System.out.println("Hai selezionato l'opzione per visualizzare la cartella sanitaria");
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
