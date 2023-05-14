package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);

	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;

		Iterator<Attrezzo> iter = this.attrezzi.iterator();

		while(iter.hasNext()) {
			a = iter.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;

		Iterator<Attrezzo> iter = this.attrezzi.iterator();
		while(iter.hasNext())
			peso += iter.next().getPeso();

		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo trovato = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		
		while(it.hasNext()) {
			trovato = it.next();
			if(trovato.getNome().equals(nomeAttrezzo)) 
				it.remove();
		}
		return trovato;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			Iterator<Attrezzo> iter = this.attrezzi.iterator();
			while(iter.hasNext()) {
				s.append("\n");
				s.append(iter.next().toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		ComparatorePerPeso comp = new ComparatorePerPeso();
		List<Attrezzo>listaOrdinata = new ArrayList<Attrezzo>();
		listaOrdinata.addAll(this.attrezzi);
		Collections.sort(listaOrdinata,comp);
		return listaOrdinata;
	}
	
	
	
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		ComparatorePerNome cmp = new ComparatorePerNome();
		SortedSet<Attrezzo> attrezziOrdinatiNome = new TreeSet<Attrezzo>(cmp);
		attrezziOrdinatiNome.addAll(this.attrezzi);
		return attrezziOrdinatiNome;
	}
	
}