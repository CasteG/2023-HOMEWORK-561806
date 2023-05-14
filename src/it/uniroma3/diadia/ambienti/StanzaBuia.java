package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzoLucente;

	public StanzaBuia(String nome, String attrezzoLucente) {
		super(nome);
		this.attrezzoLucente = attrezzoLucente;
	}

	@Override
	public String getDescrizione() {
		String descrizioneBuio = "Qui c'è un buio pesto...";
		if(!this.hasAttrezzo(attrezzoLucente)) {
			return descrizioneBuio;
		}
		String descrizioneNonBuio = "L'attrezzo " + this.attrezzoLucente + "ha illuminato la stanza";
		return descrizioneNonBuio;
	}

}
