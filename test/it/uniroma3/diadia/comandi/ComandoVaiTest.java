package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	private Comando comandoVai;
	private Partita partita;
	private Stanza stanzaPartenza;
	private IO io;

	@Before
	public void setUp() throws Exception {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita = new Partita(io);
		this.stanzaPartenza =new Stanza("Partenza");
		this.partita.setStanzaCorrente(this.stanzaPartenza);
	}
	

	@Test
	public void testVaiStanzaNonPresente() {
		this.comandoVai.setParametro("nord");
		this.comandoVai.esegui(this.partita);
		assertEquals("Partenza", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiStanzaPresente() {
		Stanza destinazione = new Stanza("Destinazione");
		this.stanzaPartenza.impostaStanzaAdiacente("nord",destinazione);
		this.comandoVai.setParametro("nord");
		this.comandoVai.esegui(partita);
		assertEquals("Destinazione", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresenteDirezioneSbagliata() {
		Stanza destinazione = new Stanza("Destinazione");
		this.stanzaPartenza.impostaStanzaAdiacente("nord",destinazione);
		this.comandoVai.setParametro("est");
		this.comandoVai.esegui(partita);
		assertEquals("Partenza", this.partita.getStanzaCorrente().getNome());
	}
	

}
