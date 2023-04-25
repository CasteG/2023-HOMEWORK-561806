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
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			io.mostraMessaggio("Attrezzo preso!");
		}
		else
			io.mostraMessaggio("Attrezzo non presente in questa stanza o borsa troppo piena");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

}
