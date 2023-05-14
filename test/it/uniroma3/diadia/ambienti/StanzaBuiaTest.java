package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	Stanza stanza1 = new StanzaBuia("Stanza buia", "lanterna");
	Attrezzo lanterna = new Attrezzo("lanterna", 5);
	Attrezzo osso = new Attrezzo("osso", 5);


	@Test
	public void testHasAttrezzoLucente() {
		this.stanza1.addAttrezzo(lanterna);
		assertTrue(this.stanza1.hasAttrezzo("lanterna"));
	}

	@Test
	public void testNotHasAttrezzoLucente() {
		this.stanza1.addAttrezzo(osso);
		assertFalse(this.stanza1.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testGetDescrizioneBuio() {
		assertEquals("Qui c'è un buio pesto...", this.stanza1.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneNormale() {
		this.stanza1.addAttrezzo(lanterna);
		assertEquals("L'attrezzo " + lanterna.getNome()+ "ha illuminato la stanza", this.stanza1.getDescrizione());
	}


}
