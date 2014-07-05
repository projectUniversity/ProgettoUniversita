package mainETest;

import static org.junit.Assert.*;

import org.junit.Test;

import paziente_esami.Esame;
import malattia_salvataggio.Malattia;
import paziente_esami.Paziente;
import it.unibs.fp.mylib.*;

/**
 * Classe di test per i metodi di utilità
 * 
 * @author Marta Balduzzi, Sonia Barbieri, Colette Spelta
 * 
 * Classe curata da Balduzzi Marta
 *
 */

public class TestUtilita 
{
	
	@Test
	public void controlloCfTest() throws Exception
	{
		boolean codF1 = new Paziente("Pietro", "Rossi", 'M', 57, 1.78, 1986, 5, 23, "ABCDEF12G34H567I", "Positivo", "AB", "Via primo maggio", "Breno", "Brescia", "Lovere", "Bergamo", 25043, "0364123456").controlloCf();
		assertEquals(true, codF1);
		
		boolean codF2 = new Paziente("Pietro", "Rossi", 'M', 57, 1.78, 1986, 5, 23, "ABC", "Positivo", "AB", "Via primo maggio", "Breno", "Brescia", "Lovere", "Bergamo", 25043, "0364123456").controlloCf();
		assertEquals(false, codF2);
	}
	
	@Test
	public void nuovaMalattiaTest() throws Exception
	{
		Malattia malattia = new Malattia("Appendicite", 23, 5, 2014, 14, 6, 2014, "Forti dolori addominali", "Appendicite acuta", "Radiografia", "Operazione chirurgica di rimozione");
		assertEquals(malattia, malattia); //Data una malattia con certi parametri, io mi aspetto di ricevere in uscita la medesima malattia (Spiegazione pratica)
	}
	
	@Test
	public void nuovoEsameTest() throws Exception
	{
		Esame esame = new Esame("Radiografia", "Nessuna", 'D', 12, 12, 2014, 14, 30, "Ospedale Civile di Brescia", "Via Biseo", "Brescia", "Brescia", 0, 0);
		assertEquals(esame, esame);
	}
	
	@Test
	public void creaUtenteTest() throws Exception
	{
		Paziente utente = new Paziente("Pietro", "Rossi", 'M', 57, 1.78, 1986, 5, 23, "ABCDEF12G34H567I", "Positivo", "AB", "Via primo maggio", "Breno", "Brescia", "Lovere", "Bergamo", 25043, "0364123456");
		assertEquals(utente, utente);
	}
}
