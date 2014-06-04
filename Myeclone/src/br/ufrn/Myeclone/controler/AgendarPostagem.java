package br.ufrn.Myeclone.controler;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.ufrn.Myeclone.DAO.AtividadesDaoInterface;
import br.ufrn.Myeclone.DAO.DAOFactory;
import br.ufrn.Myeclone.DAO.HibernateDAOFactory;
import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.apifb.FBConnection;
import br.ufrn.Myeclone.model.Atividade;
import java.sql.Time;

public class AgendarPostagem extends AcoesCommand{

	private String token;
	AtividadesDaoInterface atividadeDAO;
	//static final DAOFactory factory = DAOFactory.instance(Atividade.class);
	protected static final DAOFactory factory = DAOFactory.instance(HibernateDAOFactory.class);
	private FBConnection fb;
	private Atividade atividade;
	public AgendarPostagem(String token, String mensagem, Date data, Time horario ){
		atividadeDAO = factory.getAtividadeDAO();
		//fb = new FBConnection(token); 	
		atividade = new Atividade();
		atividade.setAtividade("postagemfb");
		atividade.setCumprido(false);
		atividade.setData(data);
		atividade.setDescricao(mensagem);
		atividade.setHorario(horario);
	}
	
	@Override
	public void execute(){
			try {
				atividadeDAO.save(atividade);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}

	public static void main(String args[]){
		
		Calendar c = Calendar.getInstance();
		c.set(2014, 5, 25);
		AgendarPostagem agenda = new AgendarPostagem("CAAB3hpwGrPgBAGxmMHSZC5Myi4aozmhui7kT0f0v7e9w3PSpTFgLJlDIreM3VxJjubH4hsUh8WrRD8J9js1FnqmjBRE58tRoZABbzLhkKce6pbPWKrP7ZAAO2XUnYPDkQjq1aE7XLO7Go4uayilkHDQlZBoWZBDlZCnhC9jZCHCTdrlcycLeh4J3bJYl0fP9ZCUZD", "Testando RestFB", c.getTime(), new Time(22, 30, 00));
		agenda.execute();
	}
	
}
