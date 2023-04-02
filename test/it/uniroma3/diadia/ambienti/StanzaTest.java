package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza vuota;
	private Stanza stanzaNonVuota;
	private Attrezzo libro;

	@Before
	public void setUp() {
		this.vuota = new Stanza("Stanza vuota");
		this.stanzaNonVuota = new Stanza("Stanza non vuota");
		this.libro = new Attrezzo("libro",2);
		this.stanzaNonVuota.addAttrezzo(libro);
	}

	@Test
	public void testAddAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("lanterna"));
		this.vuota.addAttrezzo(new Attrezzo("osso",1));
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}

	@Test
	public void testHasAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("lanterna"));
	}

	@Test
	public void testGetAttrezzo() {
		assertEquals(this.libro, this.stanzaNonVuota.getAttrezzo("libro"));
	}

	@Test
	public void testRemoveAttrezzo() {
		assertTrue(this.stanzaNonVuota.removeAttrezzo(libro));		//perchè removeAttrezzo restituisce true se va a buon fine
		assertFalse(this.stanzaNonVuota.hasAttrezzo("libro"));
	}

}
