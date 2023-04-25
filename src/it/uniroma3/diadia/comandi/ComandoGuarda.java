package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		partita.getStanzaCorrente().toString();
		io.mostraMessaggio("Cfu rimasti: " + partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		//non ha parametri
		
	}

}
