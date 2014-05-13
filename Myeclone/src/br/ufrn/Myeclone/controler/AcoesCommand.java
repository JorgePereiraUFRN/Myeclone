package br.ufrn.Myeclone.controler;

import br.ufrn.Myeclone.model.Tarefa;

public abstract class AcoesCommand {
	
	private final Tarefa tarefa = new Tarefa();
	
	public abstract void execute();

}
