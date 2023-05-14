package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
// * Comando "Posa"
// * Il giocatore posa un attrezzo dalla sua borsa (se c'è)
// * nella stanza in cui si trova
// */

public class ComandoPosa implements Comando {
	
	String nomeAttrezzo;
	String nome = "Posa";
	IO io;
	
	@Override
	public void esegui(Partita partita) {
		this.io = partita.getIo();
		
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("Attrezzo posato!");
		}
		else 
			io.mostraMessaggio("Attrezzo non presente nella borsa");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
