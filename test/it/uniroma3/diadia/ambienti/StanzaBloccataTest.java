package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	static final String direzioneBloccata = "nord";
	private Stanza stanzaBloccata = new StanzaBloccata("Stanza bloccata", direzioneBloccata, "chiave");
	private Attrezzo chiave = new Attrezzo("chiave", 2);
	private Stanza stanzaAdiacenteDirBloccata = new Stanza("Stanza adiacente dir bloccata");
	private Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
	
	
	@Before
	public void setUp() {
		this.stanzaBloccata.impostaStanzaAdiacente(direzioneBloccata, stanzaAdiacenteDirBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
	}

	@Test
	public void testHasAttrezzo() {
		this.stanzaBloccata.addAttrezzo(chiave);
		assertTrue(this.stanzaBloccata.hasAttrezzo("chiave"));
	}
	
	@Test
	public void testNotHasAttrezzo() {
		assertFalse(this.stanzaBloccata.hasAttrezzo("chiave"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSeBloccata() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacenteSeSbloccata() {
		this.stanzaBloccata.addAttrezzo(chiave);
		assertEquals(this.stanzaAdiacenteDirBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSeDirezioneNonBloccata() {
		this.stanzaBloccata.addAttrezzo(chiave);
		assertEquals(this.stanzaAdiacente, this.stanzaBloccata.getStanzaAdiacente("sud"));
	}

}
