package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	
	private static final String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "borsaFiltroPeso", "borsaFiltroNome", "aiuto", "fine"};
	
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
		if(nomeComando == null)
			comando = new ComandoNonValido();
		else if(nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if(nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if(nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if(nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(elencoComandi);
		else if(nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if(nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else if(nomeComando.equals("borsaFiltroPeso"))
			comando = new ComandoGuardaBorsaPeso();
		else if(nomeComando.equals("borsaFiltroNome"))
			comando = new ComandoGuardaBorsaNome();
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		
		return comando;
	}
}
