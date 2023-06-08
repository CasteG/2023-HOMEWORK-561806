package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	Borsa borsa;

	@Before
	public void setUp() {
		this.borsa = new Borsa();
	}
	
	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiABorsa();
		assertEquals(attrezzo,this.borsa.getAttrezzo("Lanterna"));
	}
	
	@Test
	public void testAttrezzoInesistente() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiABorsa();
		assertNotEquals(attrezzo,this.borsa.getAttrezzo("Spada"));
	}
	
	@Test
	public void testAttrezzoNUll() {
		assertFalse(this.borsa.hasAttrezzo("Lanterna"));
	}
	
	@Test
	public void testRemoveAttrezzoEsistente() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiABorsa();
		this.borsa.removeAttrezzo(attrezzo.getNome());
		assertFalse(this.borsa.hasAttrezzo(attrezzo.getNome()));
		}
	
	@Test 
	public void testRemoveAltroAttrezzo() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiABorsa();
		Attrezzo attrezzoDaRimuovere = new Attrezzo("Osso", 2);
		this.borsa.addAttrezzo(attrezzoDaRimuovere);
		this.borsa.removeAttrezzo(attrezzoDaRimuovere.getNome());
		assertEquals(attrezzo, this.borsa.getAttrezzo(attrezzo.getNome()));
	}
	
	@Test 
	public void testAddAttrezzoTroppoPesante() {
		new Attrezzo("Osso", this.borsa.getPesoMax()+1);
		assertFalse(this.borsa.hasAttrezzo("Osso"));
	}
	
	
	
	/**
	 * metodo di utilità
	 */
	private Attrezzo creaAttrezzoEAggiungiABorsa() {
		Attrezzo attrezzo = new Attrezzo("Lanterna", 4);
		this.borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoRaggruppatoConSingoloAttrezzo_BorsaVuota() {
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoRaggruppatoConSingoloAttrezzo_Singleton() {
		Attrezzo attrezzo = new Attrezzo("attrezzo",1);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(Collections.singletonMap(1, Collections.singleton(attrezzo)), this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoRaggruppatoConSingoloAttrezzo_Singleton_DueAttrezzi() {
		int stessoPeso = 1;
		Attrezzo attrezzo = new Attrezzo("attrezzo",stessoPeso);
		Attrezzo attrezzoStessoPeso = new Attrezzo("attrezzo stesso peso", stessoPeso);
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzoStessoPeso);
		assertEquals(Collections.singletonMap(stessoPeso, new HashSet<>(Arrays.asList(attrezzo,attrezzoStessoPeso))), this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testAttrezziConStessoPesoNomeDiverso() {
	Attrezzo attrezzo = new Attrezzo("ascia", 1);
	Attrezzo attrezzoStessopesoFuoriordine = new Attrezzo("lanterna", 1);
	this.borsa.addAttrezzo(attrezzoStessopesoFuoriordine);
	this.borsa.addAttrezzo(attrezzo);
	assertEquals(Arrays.asList(attrezzo,attrezzoStessopesoFuoriordine), this.borsa.getContenutoOrdinatoPerPeso());
	}

}
