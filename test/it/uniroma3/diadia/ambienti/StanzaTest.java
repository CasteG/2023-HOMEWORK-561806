package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;

	@Before 
	public void setUp() {
		this.stanza = new Stanza("testStanza");
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		Stanza adiacente = newStanzaESetAdiacente(this.stanza, "StanzaAdiacente", "nord");
		assertEquals(adiacente, this.stanza.getStanzaAdiacente("nord"));
	}


	
	private void assertNotContains(Set<String> set, String nuovaDirezione) {
		boolean contiene = false;
		for(String direzione: set)
			if(direzione!=null && direzione.equals(nuovaDirezione))
				contiene = true;
		assertFalse(contiene);
	}
	
	@Test
	public void testAddrezzoSingolo() {
		Attrezzo attrezzo = new Attrezzo("Lanterna", 5);
		this.stanza.addAttrezzo(attrezzo);
		assertEquals(attrezzo, this.stanza.getAttrezzo("Lanterna"));
	}
	
	@Test 
	public void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("Lanterna"));
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		Attrezzo attrezzo = new Attrezzo("Lanterna", 5);
		this.stanza.addAttrezzo(attrezzo);
		assertFalse(this.stanza.hasAttrezzo("Inesistente"));
	}
	
}
