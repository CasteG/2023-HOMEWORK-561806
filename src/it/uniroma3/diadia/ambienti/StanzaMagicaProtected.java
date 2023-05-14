package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

//    PER FAR COMPILARE CAMBIA LA VISIBILITà DELLE VARIABILI "ATTREZZI" E 
//    "NUMEROATTREZZI" DELLA CLASSE STANZA A PROTECTED!!

	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.numeroAttrezzi++;
		if (this.numeroAttrezzi>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		if(this.numeroAttrezzi<this.attrezzi.length) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			return true;
		}
		else
			return false;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
				pesoX2);
		return attrezzo;
	}

}
