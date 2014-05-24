package br.ufrn.Myeclone.controler;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.Myeclone.model.Agenda;

public class FachadaEclone {

	List<AcoesCommand> acoesCommand = new ArrayList<AcoesCommand>();
	private Agenda agenda;

	public List<AcoesCommand> getAcoesCommand() {
		return acoesCommand;
	}

	public void setAcoesCommand(List<AcoesCommand> acoesCommand) {
		this.acoesCommand = acoesCommand;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	public void executarAcoesProgramadas() {

		for (AcoesCommand acao : acoesCommand) {
			acao.execute();
		}
	}

}
