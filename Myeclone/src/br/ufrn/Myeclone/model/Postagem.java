package br.ufrn.Myeclone.model;

import javax.persistence.Entity;

@Entity
public class Postagem extends Atividade{

	public String getIdDest() {
		return idDest;
	}
	public void setIdDest(String idDest) {
		this.idDest = idDest;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	private String idDest;
	private String token;
}
