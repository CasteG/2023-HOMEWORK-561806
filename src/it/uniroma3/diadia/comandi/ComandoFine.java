package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private IO io;

	@Override
	public void esegui(Partita partita) {
			partita.setFinita();
			io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		}

	@Override
	public void setParametro(String parametro) {
		//non ha parametri
		
	}
}

