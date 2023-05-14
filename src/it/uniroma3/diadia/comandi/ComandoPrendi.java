package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Comando "Prendi"
 * Il giocatore prende un attrezzo da una stanza (se c'è)
 * e lo inserisce nella propria borsa
 * @param nome dell'attrezzo da prendere
 */
public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	private String nome = "Prendi";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		this.io = partita.getIo();
		
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Boolean preso = null;
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			preso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			if(preso==true) {
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				io.mostraMessaggio("Attrezzo preso!");
			}
			else 
				io.mostraMessaggio("Borsa troppo piena");
				
		}
		else
			io.mostraMessaggio("Attrezzo non presente in questa stanza");
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
