
package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.model.Agenda;

public class HibernateDAOFactory extends DAOFactory {

	
	private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            //dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

	@Override
	public AgendaDao getAgendaDAO() {
		
		return  (AgendaDao) instantiateDAO(AgendaDao.class);
	}

	@Override
	public AtividadeDAO getAtividadeDAO() {
		
		return (AtividadeDAO) instantiateDAO(AtividadeDAO.class);
	}

	@Override
	public PostagemDAO getPostagemDAO() {
		
		return (PostagemDAO) instantiateDAO(PostagemDAO.class);
	}

	
	
	
	
}

