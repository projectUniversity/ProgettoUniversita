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
	 * Questa classe è usata come contenitore per il salvataggio degli oggetti nel file
	 *	
	 * */
	
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
	/**
	 * Metodo getUtente
	 * Questo metodo restituisce l'oggetto di tipo Paziente salvato nel file
	 * @return paziente
	 */
	public Paziente getUtente(){
		return utente;
	}
	
	/**
	 * Metodo getMalattia
	 * Questo metodo restituisce l'oggetto di tipo ArrayList<Malattia> salvato nel file
	 * @return malattia
	 */
	public ArrayList<Malattia> getMalattia(){
		return malattia;
	}
	
	/**
	 * Metodo getEsame
	 * Questo metodo restituisce l'oggetto di tipo ArrayList<Esame> salvato nel file
	 * @return esame
	 */
	public ArrayList<Esame> getEsame(){
		return esame;
	}
}
