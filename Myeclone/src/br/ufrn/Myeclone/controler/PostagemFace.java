package br.ufrn.Myeclone.controler;

import java.util.Date;

import br.ufrn.Myeclone.DAO.DAOFactory;
import br.ufrn.Myeclone.apifb.FBConnection;
import br.ufrn.Myeclone.model.Atividade;

public class PostagemFace extends AcoesCommand{
	static final DAOFactory factory = DAOFactory.instance(Atividade.class);
	private String token;
	FBConnection fb;
	private Atividade atividade;
	public PostagemFace(Atividade atividade){
		fb = new FBConnection(token);
		this.atividade = atividade;
	}
	@Override
	public void execute() {
		//factory.getAtividadeDAO().findById(Atividade.class, 1);
	}

}
