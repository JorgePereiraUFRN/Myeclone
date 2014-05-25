package br.ufrn.Myeclone.controler;

import java.util.Date;

import javax.persistence.EntityManager;

import br.ufrn.Myeclone.DAO.DAOFactory;
import br.ufrn.Myeclone.DAO.HibernateDAOFactory;
import br.ufrn.Myeclone.apifb.FBConnection;
import br.ufrn.Myeclone.model.Atividade;

public class AgendarPostagem extends AcoesCommand{

	private String token;
	static final DAOFactory factory = DAOFactory.instance(Atividade.class);
	private FBConnection fb;
	private Atividade atividade;
	public AgendarPostagem(String token, String mensagem, Date data, String horario ){
		fb = new FBConnection(token);
		atividade = new Atividade();
		atividade.setAtividade("postagemfb");
		atividade.setCumprido(false);
		atividade.setData(data);
		atividade.setDescricao(mensagem);
		atividade.setHorario(horario);
	}
	@Override
	public void execute() {
		//sincronizar o projeto para isso funcionar!!!!
		EntityManager em = factory.getAtividadeDAO().getInstance();
		em.persist(atividade);
	}

}
