package metodi;

import java.io.EOFException;
import java.io.File;
import java.io.Serializable;

import it.unibs.fp.mylib.ServizioFile;
import paziente_esami.*;
import malattia_salvataggio.*;
public class CartellaSanitaria implements Serializable {

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
	
	private static String nome, cognome, fattoreRh,gruppoS,via,comune,provincia,comuneN,provinciaN, codF, telefono;
	private static char sesso;
	private static double peso,altezza;
	private static int anno,mese,giorno,cap, ora, minuti;
	
	private static String nomeMalattia;
	private static String sintomo;
	private static String diagnosi;
	private static String esame;
	private static String terapia;
	
	private static int giornoInizio;
	private static int meseInizio;
	private static int annoInizio;
	private static int giornoFine;
	private static int meseFine;
	private static int annoFine;
	
	private static String nomeEsame;
	private static String raccomandazione;
	private static char tipoEsame;
	private static int giornoE,meseE,annoE;
	private static String ospedale;
	private static String viaEsame;
	private static String comuneEsame;
	private static String provinciaEsame;
	private static int oraE,minE;
	private static double sogliaMax; 
	private static double sogliaMin;
	private static Paziente utente=null;
	private static Esame esameR=null;
	private static Malattia malattia=null;
	
	//METODI
	/**
	 * Metodo toString()
	 * Questo metodo mi rende possibile la visualizzazione della cartella sanitaria del paziente
	 */
	public String toString(){
		StringBuffer frase=new StringBuffer();
		
		utente=(Paziente)ServizioFile.caricaSingoloOggetto(salvataggioUtente);
		nome=utente.getNome();
		cognome=utente.getCognome();
		fattoreRh=utente.getFattoreRh();
		gruppoS=utente.getGruppoSanguigno();
		via=utente.getViaCasa();
		comune=utente.getComuneCasa();
		comuneN=utente.getComuneNascita();
		provincia=utente.getProvinciaCasa();
		provinciaN=utente.getProvinciaNascita();
		peso=utente.getPeso();
		codF=utente.getCodiceFiscale();
		telefono=utente.getTelefono();
		sesso=utente.getSesso();
		altezza=utente.getAltezza();
		anno=utente.getAnno();
		mese=utente.getMese();
		giorno=utente.getGiorno();
		cap=utente.getCapCasa();
		
		esameR=(Esame)ServizioFile.caricaSingoloOggetto(salvataggioEsame);
		nomeEsame=esameR.getNomeEsame();
		raccomandazione=esameR.getRaccomandazione();
		tipoEsame=esameR.getTipoEsame();
		giornoE=esameR.getGiorno();
		meseE=esameR.getMese();
		annoE=esameR.getAnno();
		ospedale=esameR.getOspedale();
		viaEsame=esameR.getViaEsame();
		comuneEsame=esameR.getComuneEsame();
		provinciaEsame=esameR.getProvinciaEsame();
		minE=esameR.getMinuti();
		oraE=esameR.getOra();
		sogliaMin=esameR.getSogliaMin();
		sogliaMax=esameR.getSogliaMax();
		
		malattia=(Malattia)ServizioFile.caricaSingoloOggetto(salvataggioMalattia);
		malattia.getNomeMalattia();
		malattia.getTerapia();
		malattia.getDiagnosi();
		malattia.getAnnoFine();
		malattia.getAnnoInizio();
		malattia.getEsame();
		malattia.getGiornoFine();
		malattia.getGiornoInizio();
		malattia.getMeseFine();
		malattia.getMeseInizio();
		malattia.getSintomo();
		
		//String cognome=utente.getCognome();
		//String nome=utente.getNome();
		System.out.println(MSG+cognome.substring(0, 1).toUpperCase()+cognome.substring(1, cognome.length())+" "+nome.substring(0, 1).toUpperCase()+nome.substring(1, nome.length()));
		
		System.out.println(CORNICE);
		System.out.println();
		frase.append(String.format(utente.toStringCompleto(),"/n",esameR.toStringSintetico(),"/n",malattia.toStringSintetico(),"/n",esameR.toStringPrenotati()));
		
		return frase.toString();
	}
}
