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
	
	//COSTANTE
	public static final String MSG="Questa e' la cartella sanitaria del paziente";
	
	//METODI
	/**
	 * Metodo toString()
	 * Questo metodo mi rende possibile la visualizzazione della cartella sanitaria del paziente
	 */
	public String toString(){
		StringBuffer frase=new StringBuffer();
		System.out.println(MSG);
		//frase.append(String.format(Paziente.toStringCompleto(),Esame.toStringSintetico(),Malattia.toStringSintetico(),Esame.toStringPrenotati()));
		//if((Esame.toStringSintetico().equals(null))&&(Esame.toStringPrenotati().equals(null))){
			frase.append(String.format(Paziente.toStringCompleto()));
		//}
		return frase.toString();
	}
}
