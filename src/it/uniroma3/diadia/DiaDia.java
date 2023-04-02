package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole ioconsole;

	public DiaDia(IOConsole ioconsole) {
		this.partita = new Partita();
		this.ioconsole = ioconsole;
	}

//	public void gioca() {
//		String istruzione; 
//		Scanner scannerDiLinee;
//
//		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
//		scannerDiLinee = new Scanner(this.ioconsole.leggiRiga());		
//		do		
//			istruzione = scannerDiLinee.nextLine();
//		while (!processaIstruzione(istruzione));
//	}   
	
	public void gioca() {
		String istruzione; 

		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		String nome = comandoDaEseguire.getNome();		//extract local variable
		
		if(nome==null)
			ioconsole.mostraMessaggio("Digita un comando");
		else {
			if ("fine".equals(nome)) {	//con equals conviene sempre mettere prima la stringa (per evitare NullPointerException)
				this.fine(); 
				return true;
			} else if ("vai".equals(nome))
				this.vai(comandoDaEseguire.getParametro());
			else if ("aiuto".equals(nome))
				this.aiuto();
			else if ("prendi".equals(nome))
				this.prendi(comandoDaEseguire.getParametro());
			else if ("posa".equals(nome))
				this.posa(comandoDaEseguire.getParametro());
			else
				ioconsole.mostraMessaggio("Comando sconosciuto");
			if (this.partita.vinta()) {
				ioconsole.mostraMessaggio("Hai vinto!");
				return true;
			} else
				return false;
		}
		return false;
 }
		
	
	
	

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioconsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Prendi"
	 * Il giocatore prende un attrezzo da una stanza (se c'è)
	 * e lo inserisce nella propria borsa
	 * @param nome dell'attrezzo da prendere
	 */
	private void prendi(String nomeAttrezzo) {
		if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			ioconsole.mostraMessaggio("Attrezzo preso!");
		}
		else
			ioconsole.mostraMessaggio("Attrezzo non presente in questa stanza o borsa troppo piena");
	}
	
	
	/**
	 * Comando "Posa"
	 * Il giocatore posa un attrezzo dalla sua borsa (se c'è)
	 * nella stanza in cui si trova
	 */
	private void posa(String nomeAttrezzo) {
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			ioconsole.mostraMessaggio("Attrezzo posato!");
		}
		else 
			ioconsole.mostraMessaggio("Attrezzo non presente nella borsa");
	}
	
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole ioconsole = new IOConsole();
		DiaDia gioco = new DiaDia(ioconsole);
		gioco.gioca();
	}
}