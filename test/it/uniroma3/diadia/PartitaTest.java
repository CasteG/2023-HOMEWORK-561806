package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partitaTest;
	private IOConsole ioConsole;
	
	@Before
	public void setUp() {
		this.ioConsole = new IOConsole();
		this.partitaTest = new Partita(ioConsole);
	}

	@Test
	public void testVinta() {
		this.partitaTest.setStanzaCorrente(this.partitaTest.getLabirinto().getStanzaVincente());
		assertTrue(this.partitaTest.vinta());
	}
	
	@Test
	public void testVintaSeStanzaCorrenteDiversaDaVincente() {
		this.partitaTest.setStanzaCorrente(new Stanza("N1"));
		assertFalse(this.partitaTest.vinta());
	}
	
	@Test
	public void testVintaSeAppenaIniziata() {
		assertFalse(this.partitaTest.vinta());
	}
	

	@Test
	public void testIsFinitaSeCfuTerminati() {
		this.partitaTest.getGiocatore().setCfu(0);
		assertTrue(this.partitaTest.isFinita());
	}
	
	@Test
	public void testIsFinitaSeVinta() {
		this.partitaTest.setStanzaCorrente(this.partitaTest.getLabirinto().getStanzaVincente());		
		assertTrue(this.partitaTest.isFinita());
	}
	
	@Test
	public void testIsFinitaSeAppenaIniziata() {
		assertFalse(this.partitaTest.isFinita());
	}
	
}
