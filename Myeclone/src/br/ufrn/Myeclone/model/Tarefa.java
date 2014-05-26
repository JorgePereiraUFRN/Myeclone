package br.ufrn.Myeclone.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.NotFound;


@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Tarefa {

	@Id
    @GeneratedValue
	private Long id;
	
	private String horario;
	private Date data;
	private boolean cumprido;

	public String getHorario() {
		return horario;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
