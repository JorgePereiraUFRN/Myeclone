package br.ufrn.Myeclone.controler.Service;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrn.Myeclone.DAO.AtividadeDAO;
import br.ufrn.Myeclone.DAO.AtividadesDaoInterface;
import br.ufrn.Myeclone.DAO.PostagemDAO;
import br.ufrn.Myeclone.DAO.PostagemDaoInterface;
import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.Exceptions.ObjetoNuloException;
import br.ufrn.Myeclone.Exceptions.ServiceException;
import br.ufrn.Myeclone.controler.AgendarPostagem;
import br.ufrn.Myeclone.model.Atividade;
import br.ufrn.Myeclone.model.Postagem;

public class PostagemService extends Service<Postagem> {

	PostagemDaoInterface postagemDAO;

	public PostagemService() {
		postagemDAO = factory.getPostagemDAO();
	}

	
	private boolean validarPostagem(Postagem postagem)
			throws ObjetoNuloException, ValorNuloException {

		if (postagem == null) {
			throw new ObjetoNuloException("postagem is null");
		}

		if (postagem.getAtividade().trim().equals("")) {
			throw new ValorNuloException("postagem.atividade is null");
		}

		if (postagem.getData() == null) {
			throw new ValorNuloException("postagem.data is null");
		}

<<<<<<< HEAD
=======
		if (postagem.getHorario() == null) {
			throw new ValorNuloException("postagem.horario is null");
		}

>>>>>>> ea5ae018201e54d246c341612feca6896e5b056d
		return true;

	}

	
	@Override
	public Postagem create(Postagem entity) throws ServiceException {

		try {
			if (validarPostagem(entity)) {

				try {
					return postagemDAO.save(entity);
				} catch (DAOException e) {
					
					throw new ServiceException("Erro ao salvar no BD "+e.getMessage());
				}

			}
		} catch (ObjetoNuloException | ValorNuloException e) {
			
			throw new ServiceException(e.getMessage());
		}

		return null;
	}

	@Override
	public Postagem update(Postagem entity) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(Postagem entity) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Postagem retrieve(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public List<Postagem> list() throws ServiceException {		
		try {
                    return postagemDAO.findAll(Postagem.class);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
=======
	public List<Postagem> list() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
>>>>>>> ea5ae018201e54d246c341612feca6896e5b056d
	}

	public static void main(String args[]){
		Postagem p = new Postagem();

		Calendar c = Calendar.getInstance();
		c.set(2014, 5, 25);
		p.setToken("CAAB3hpwGrPgBAGxmMHSZC5Myi4aozmhui7kT0f0v7e9w3PSpTFgLJlDIreM3VxJjubH4hsUh8WrRD8J9js1FnqmjBRE58tRoZABbzLhkKce6pbPWKrP7ZAAO2XUnYPDkQjq1aE7XLO7Go4uayilkHDQlZBoWZBDlZCnhC9jZCHCTdrlcycLeh4J3bJYl0fP9ZCUZD");
		p.setDescricao("Testando RestFB");
<<<<<<< HEAD
		p.setHorario(new Time(22, 30, 0));
=======
		p.setHorario(new Time(22, 30, 00));
>>>>>>> ea5ae018201e54d246c341612feca6896e5b056d
		p.setAtividade("postagemfb");
		p.setCumprido(false);
		p.setData(c.getTime());
		PostagemService ps = new PostagemService();
		try {
			ps.create(p);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
		
		
	


	
