package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private IO io;
	private String nome = "Fine";
	

	@Override
	public void esegui(Partita partita) {
			partita.setFinita();
			partita.getIo().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		}

	@Override
	public void setParametro(String parametro) {
		//non ha parametri
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
}

