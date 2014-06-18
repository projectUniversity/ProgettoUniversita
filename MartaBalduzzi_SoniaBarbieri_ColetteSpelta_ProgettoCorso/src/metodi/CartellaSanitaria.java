package metodi;

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
	//METODI
	/**
	 * Metodo toString()
	 * Questo metodo mi rende possibile la visualizzazione della cartella sanitaria del paziente
	 */
	public String toString(){
		StringBuffer frase=new StringBuffer();
		String cognome=Paziente.getCognome();
		String nome=Paziente.getNome();
		
		System.out.println(MSG+cognome.substring(0, 1).toUpperCase()+cognome.substring(1, cognome.length())+" "+nome.substring(0, 1).toUpperCase()+nome.substring(1, nome.length()));
		System.out.println(CORNICE);
		System.out.println();
		try{
			frase.append(String.format(Paziente.toStringCompleto(),"/n",Esame.toStringSintetico(),"/n",Malattia.toStringSintetico(),"/n",Esame.toStringPrenotati()));
		}
		catch(NullPointerException e){
			try{
			Esame.toStringPrenotati();
			Esame.toStringSintetico();
		}
			catch(NullPointerException ex){
				frase.append(String.format(Paziente.toStringCompleto()));
			}
		}
		
		return frase.toString();
	}
}
