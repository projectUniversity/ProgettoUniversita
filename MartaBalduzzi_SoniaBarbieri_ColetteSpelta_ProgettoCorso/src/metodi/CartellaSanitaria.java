package metodi;


import java.io.Serializable;
import java.util.ArrayList;

import paziente_esami.*;
import malattia_salvataggio.*;

public class CartellaSanitaria implements Serializable {

	/**
	 * 
	 * @author Balduzzi Marta, Barbieri Sonia e Spelta Colette
	 * La classe e' stata curata da Spelta Colette
	 *Questa classe non presenta il costruttore perché non è necessario
	 */
	
	//ATTRIBUTI
	private ArrayList<Malattia> malattia=null;
	private ArrayList<Esame> esame=null;
	private Paziente utente=null;

	//COSTRUTTORE
	public CartellaSanitaria(Paziente _utente, ArrayList<Malattia> _malattia, ArrayList<Esame> _esame) {
		utente=_utente;
		malattia=_malattia;
		esame=_esame;
	}
	
	//METODI
	public Paziente getUtente(){
		return utente;
	}
	
	public ArrayList<Malattia> getMalattia(){
		return malattia;
	}
	
	public ArrayList<Esame> getEsame(){
		return esame;
	}
}
