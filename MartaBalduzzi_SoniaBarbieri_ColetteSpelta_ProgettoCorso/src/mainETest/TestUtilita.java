package mainETest;

import static org.junit.Assert.*;
import org.junit.Test.*;

import it.unibs.fp.mylib.*;

/**
 * Classe di test per i metodi di utilità
 * 
 * @author Marta Balduzzi, Sonia Barbieri, Colette Spelta
 * 
 * Classe curata da Marta Balduzzi
 *
 */

public class TestUtilita 
{
	@TestUtilita
	public void leggiInteroTest() throws Exception 
	{
		int x;
		x = InputDati.leggiIntero("Digita 20 e premi invio");
		assertEquals(20,x,0.1);
		x = InputDati.leggiIntero("Digita una lettera/simbolo e premi invio, poi digita 20 e premi invio");
		assertEquals(20,x,0.1);
	}
	
	@TestUtilita
	public void leggiStringaTest() throws Exception 
	{
		String stringa;
		stringa=InputDati.leggiStringa("Digita ciao e premi invio");
		assertEquals("ciao",stringa);
	}
	
	@TestUtilita
	public void leggiDoubleTest() throws Exception 
	{
		double x;
		x = InputDati.leggiDouble("Digita 0,210 e premi invio");
		assertEquals(0.210,x,0.001);
		x = InputDati.leggiDouble("Digita una lettera/simbolo e premi invio, poi digita 0,210 e premi invio");
		assertEquals(0.210,x,0.001);
	}
	
	@TestUtilita
	public void leggiInteroMaxMinTest() throws Exception
	{
		int x;
		x = InputDati.leggiIntero("Digita 10 e premi invio, poi digita 4 e premi invio",0,5);
		assertEquals(4,x,0.001);
	}
	
	@TestUtilita
	public void leggiStringaNonVuotaTest() throws Exception
	{
		String stringa;
		stringa = InputDati.leggiStringaNonVuota("Premi invio poi digita ciao e premi invio");
		assertEquals("ciao", stringa);
	}

}
