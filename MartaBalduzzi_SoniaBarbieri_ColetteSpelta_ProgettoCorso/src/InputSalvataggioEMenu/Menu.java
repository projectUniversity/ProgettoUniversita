package InputSalvataggioEMenu;
import it.unibs.fp.mylib.*;

/**
 * 
 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
 * La classe e' stata cura da Spelta Colette
 *
 */
public class Menu {
	
	//COSTANTI
		public static final String CORNICE="_____________________________________________________________________";
		public static final String MSG_SCELTA="Digitare il numero dell'opzione desiderata --> ";
		public static final String MSG_ESCI="0) Salva e termina";
		public static final String CORNICE2="MENU _______________________________________________________________";
		//ATTRIBUTI
		private static String[] scelta;
		
		//COSTRUTTORE
		/**
		 * Costruttore Menu
		 * Questo costruttore riceve in ingresso il vettore contenente tutte le scelte che l'utente può fare
		 * @param _scelta
		 */
		public Menu(String [] _scelta){
			scelta=_scelta;
		}
		
		//METODI
		/**
		 * Metodo seleziona
		 * Questo metodo stampa a video tutte le scelte possibili e legge l'intero inserito dall'utente
		 * @return il numero intero che identifica la scelta dell'utente
		 */
		public int seleziona(){
			System.out.println();
			System.out.println(CORNICE2);
			for(int i=0;i<scelta.length;i++){
				System.out.println((i+1)+")"+scelta[i]);
			}
			System.out.println();
			System.out.println(MSG_ESCI);
			System.out.println(CORNICE);
			return InputDati.leggiIntero(MSG_SCELTA, 0, scelta.length);
		}

}
