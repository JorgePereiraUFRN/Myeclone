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
import br.ufrn.Myeclone.apifb.FBConnection;
import br.ufrn.Myeclone.controler.AgendarPostagem;
import br.ufrn.Myeclone.model.Atividade;
import br.ufrn.Myeclone.model.Postagem;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		
		try {
			if (validarPostagem(entity) && entity.getId() != null) {

				try {
					return postagemDAO.update(entity);
				} catch (DAOException e) {
					
					throw new ServiceException("Erro ao alterar no BD "+e.getMessage());
				}

			}
		} catch (ObjetoNuloException | ValorNuloException e) {
			
			throw new ServiceException(e.getMessage());
		}

		return null;
	}

	@Override
	public void destroy(Postagem entity) throws ServiceException {
            try {
                postagemDAO.delete(entity);
            } catch (DAOException ex) {
                throw new ServiceException("Erro ao deletar a postagem");
            }

	}

	@Override
	public Postagem retrieve(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public List<Postagem> list() throws ServiceException {		
		try {
                    return postagemDAO.findAll(Postagem.class);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public static void main(String args[]){
		Postagem p = new Postagem();

		Calendar c = Calendar.getInstance();
		c.set(2014, 5, 25);
		p.setToken("CAAB3hpwGrPgBAGxmMHSZC5Myi4aozmhui7kT0f0v7e9w3PSpTFgLJlDIreM3VxJjubH4hsUh8WrRD8J9js1FnqmjBRE58tRoZABbzLhkKce6pbPWKrP7ZAAO2XUnYPDkQjq1aE7XLO7Go4uayilkHDQlZBoWZBDlZCnhC9jZCHCTdrlcycLeh4J3bJYl0fP9ZCUZD");
		p.setDescricao("Testando RestFB");
		p.setHorario(new Time(22, 30, 0));
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
        public List<Postagem> listByHora(Time inicio, Time fim) throws ServiceException {
            try {
                return postagemDAO.listByHour(inicio, fim);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
            
        }
        
        public void postar(String mensagem){
            FBConnection fb = new FBConnection("131420027006200 ", "e0a0e740a7b895596c1c7beb4aa33dfd", "CAAB3hpwGrPgBAPiKnJQMqi8aQB1ZBsuHd453deFeHZAIjjA3PzqZCtdPk1C8F8QJ6MTkkcKLlBZC3Rm2BZBFR3KCm8h7h6qbQRDRznPSigBPGN3loS4KGTUrxenAE5ey0B9nUeMbPxZCASiw84gceUBcKVXJGYLL4nUd6ufL4hsLO7vRbaVGJqjaf1IexcPjHHRTepSHmnYAZDZD");
            fb.enviarMensagem(mensagem);
        }
}
		
		
	


	
