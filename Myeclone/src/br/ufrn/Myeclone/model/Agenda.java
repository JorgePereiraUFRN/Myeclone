package br.ufrn.Myeclone.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
public class Agenda {
	
	@Id
    @GeneratedValue
	private Long id;

	@OneToMany ( cascade = CascadeType.MERGE )
    @JoinTable(name="AtividadeAgenda",joinColumns=@JoinColumn(name="agenda_id"),inverseJoinColumns=@JoinColumn(name="atividade_id"))
	private List<Atividade> atividades = new ArrayList<Atividade>();
	
	@OneToMany ( cascade = CascadeType.MERGE )
    @JoinTable(name="AtividadeAgenda",joinColumns=@JoinColumn(name="agenda_id"),inverseJoinColumns=@JoinColumn(name="acoes_id"))
	private List<Acao> acoes = new ArrayList<Acao>();
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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
