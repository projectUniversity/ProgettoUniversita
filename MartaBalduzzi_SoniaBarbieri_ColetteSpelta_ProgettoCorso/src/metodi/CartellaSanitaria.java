package metodi;

import paziente_esami.*;
import malattia_salvataggio.*;
public class CartellaSanitaria {

	/**
	 * 
	 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
	 * La classe e' stata curata da Spelta Colette
	 *
	 */
	
	
	//METODI
	public String toString(){
		StringBuffer frase=new StringBuffer();
		frase.append(String.format(Paziente.toStringCompleto(),/*esami*/Malattia.toStringSintetico()));
		return frase.toString();
	}
}
