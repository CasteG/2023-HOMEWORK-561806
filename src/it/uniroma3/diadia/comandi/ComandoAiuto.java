package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando {
	
	private String[] elencoComandi;
	private IO io;
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
	}

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< this.elencoComandi.length; i++) 
			this.io.mostraMessaggio(this.elencoComandi[i]+" ");
	}

	@Override
	public void setParametro(String parametro) {
		//non ha parametri
	}

}
