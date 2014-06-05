package br.ufrn.Myeclone.controler.Service;

import java.util.List;

import br.ufrn.Myeclone.DAO.AtividadesDaoInterface;
import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.Exceptions.ObjetoNuloException;
import br.ufrn.Myeclone.Exceptions.ServiceException;
import br.ufrn.Myeclone.model.Atividade;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtividadesService extends Service<Atividade> {

	AtividadesDaoInterface AtividadeDAO;

	public AtividadesService() {
		AtividadeDAO = factory.getAtividadeDAO();
	}

	private boolean validarAtividade(Atividade atividade)
			throws ObjetoNuloException, ValorNuloException {

		if (atividade == null) {
			throw new ObjetoNuloException("atividade is null");
		}

		if (atividade.getAtividade().trim().equals("")) {
			throw new ValorNuloException("atividade.atividade is null");
		}

		if (atividade.getData() == null) {
			throw new ValorNuloException("atividade.data is null");
		}

		if (atividade.getHorario() == null) {
			throw new ValorNuloException("atividade.horario is null");
		}

		return true;

	}

	@Override
	public Atividade create(Atividade entity) throws ServiceException {

		try {
			if (validarAtividade(entity)) {

				try {
					return AtividadeDAO.save(entity);
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
	public Atividade update(Atividade entity) throws ServiceException {
		
		try {
			if (validarAtividade(entity) && entity.getId() != null) {

				try {
					return AtividadeDAO.update(entity);
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
	public void destroy(Atividade entity) throws ServiceException {
            
		// TODO Auto-generated method stub

	}

	@Override
	public Atividade retrieve(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atividade> list() throws ServiceException {
		
		try {
			return AtividadeDAO.findAll(Atividade.class);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
        
        public List<Atividade> listByName(String name) throws ServiceException {
            try {
                return AtividadeDAO.listByName(name);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
            
        }
        
        
        public List<Atividade> listByHora(Time inicio, Time fim) throws ServiceException {
            try {
                return AtividadeDAO.listByHour(inicio, fim);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
            
        }

}
