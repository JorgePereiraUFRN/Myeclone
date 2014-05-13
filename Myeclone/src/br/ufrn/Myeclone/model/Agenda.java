package br.ufrn.Myeclone.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;



@Entity
public class Agenda {

	private List<Atividade> atividades = new ArrayList<Atividade>();
	private List<Acao> acoes = new ArrayList<Acao>();

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}

}
