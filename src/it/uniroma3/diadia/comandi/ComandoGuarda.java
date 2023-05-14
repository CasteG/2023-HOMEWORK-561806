package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private String nome = "Guarda";

	@Override
	public void esegui(Partita partita) {
		partita.getIo().mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().toString());	
		partita.getIo().mostraMessaggio("" + partita.getGiocatore().getBorsa().toString());
		partita.getIo().mostraMessaggio("Cfu rimasti: " + partita.getGiocatore().getCfu());
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
