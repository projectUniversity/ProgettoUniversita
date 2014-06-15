package metodi;

import paziente_esami.Paziente;

public class CartellaSanitaria {

	/**
	 * 
	 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
	 * La classe e' stata curata da Spelta Colette
	 *
	 */
	
	//ATTRIBUTI
	
	
	//METODI
	public String toString(){
		StringBuffer frase=new StringBuffer();
		frase.append(String.format(Paziente.toStringCompleto()));
		return frase.toString();
	}
}
