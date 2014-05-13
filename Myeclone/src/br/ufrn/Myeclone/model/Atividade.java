package br.ufrn.Myeclone.model;

import javax.persistence.Entity;

import br.ufrn.Myeclone.enuns.RepetirAlerta;

@Entity
public class Atividade extends Tarefa {

	private String atividade;
	private String descricao;
	private Integer antecedenciaAlerta;
	private RepetirAlerta repetirAlerta;
	private Integer tempoEstimado;
	private Boolean Recorrente;

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAntecedenciaAlerta() {
		return antecedenciaAlerta;
	}

	public void setAntecedenciaAlerta(Integer antecedenciaAlerta) {
		this.antecedenciaAlerta = antecedenciaAlerta;
	}

	public RepetirAlerta getRepetirAlerta() {
		return repetirAlerta;
	}

	public void setRepetirAlerta(RepetirAlerta repetirAlerta) {
		this.repetirAlerta = repetirAlerta;
	}

	public Integer getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(Integer tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public Boolean getRecorrente() {
		return Recorrente;
	}

	public void setRecorrente(Boolean recorrente) {
		Recorrente = recorrente;
	}

}
