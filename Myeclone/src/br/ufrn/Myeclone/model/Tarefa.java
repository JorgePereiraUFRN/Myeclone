package br.ufrn.Myeclone.model;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Tarefa {

	private Long id;
	private String horario;
	private Date data;
	private Boolean cumprido;

	public String getHorario() {
		return horario;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getCumprido() {
		return cumprido;
	}


	public void setCumprido(Boolean cumprido) {
		this.cumprido = cumprido;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isCumprido() {
		return cumprido;
	}

	public void setCumprido(boolean cumprido) {
		this.cumprido = cumprido;
	}

}
