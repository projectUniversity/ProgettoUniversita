package metodi;

import java.io.File;

import it.unibs.fp.mylib.ServizioFile;
import paziente_esami.*;
import malattia_salvataggio.*;
public class CartellaSanitaria {

	/**
	 * 
	 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
	 * La classe e' stata curata da Spelta Colette
	 *Questa classe non presenta il costruttore perché non è necessario
	 */
	
	//COSTANTI
	public static final String MSG="Questa e' la cartella sanitaria del paziente:";
	public static final String CORNICE="_____________________________________________";
	
	//ATTRIBUTI
	private static File salvataggioMalattia=new File("SalvataggioMalattia.dat");
	private static File salvataggioEsame=new File("SalvataggioEsame.dat");
	private static File salvataggioUtente=new File("SalvataggioUtente.dat");
	
	//METODI
	/**
	 * Metodo toString()
	 * Questo metodo mi rende possibile la visualizzazione della cartella sanitaria del paziente
	 */
	public String toString(){
		StringBuffer frase=new StringBuffer();
		Paziente utente=null;
		Esame esame=null;
		Malattia malattia=null;
		
		try{
			String cognome=utente.getCognome();
			String nome=utente.getNome();
			System.out.println(MSG+cognome.substring(0, 1).toUpperCase()+cognome.substring(1, cognome.length())+" "+nome.substring(0, 1).toUpperCase()+nome.substring(1, nome.length()));
		}
		catch(NullPointerException exLet){
			utente=(Paziente)ServizioFile.caricaSingoloOggetto(salvataggioUtente);
			esame=(Esame)ServizioFile.caricaSingoloOggetto(salvataggioEsame);
			malattia=(Malattia)ServizioFile.caricaSingoloOggetto(salvataggioMalattia);
			String cognomeL=utente.getCognome();
			String nomeL=utente.getNome();
			System.out.println(MSG+cognomeL.substring(0, 1).toUpperCase()+cognomeL.substring(1, cognomeL.length())+" "+nomeL.substring(0, 1).toUpperCase()+nomeL.substring(1, nomeL.length()));
		}
		System.out.println(CORNICE);
		System.out.println();
		frase.append(String.format(utente.toStringCompleto(),"/n",esame.toStringSintetico(),"/n",malattia.toStringSintetico(),"/n",esame.toStringPrenotati()));
		
		return frase.toString();
	}
}
