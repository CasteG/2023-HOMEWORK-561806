package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSbloccante;


	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata)) 
			if(!super.hasAttrezzo(this.attrezzoSbloccante))
				return this;

		return super.getStanzaAdiacente(direzione);
	}

	@Override 
	public String getDescrizione() {
		String bloccata = "Questa direzione è bloccata: puoi accedervi solo se hai l'attrezzo sbloccante";
		return bloccata;
	}
}
