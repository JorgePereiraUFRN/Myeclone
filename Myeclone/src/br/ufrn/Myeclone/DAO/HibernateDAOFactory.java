package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.model.Agenda;

public class HibernateDAOFactory extends DAOFactory {

    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO) daoClass.newInstance();
            //dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

<<<<<<< HEAD
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
=======
    @Override
    public AgendaDao getAgendaDAO() {

        return (AgendaDao) instantiateDAO(AgendaDao.class);
    }

    @Override
    public AtividadeDAO getAtividadeDAO() {

        return (AtividadeDAO) instantiateDAO(AtividadeDAO.class);
    }
>>>>>>> ea5ae018201e54d246c341612feca6896e5b056d

    @Override
    public PostagemDAO getPostagemDAO() {

        return (PostagemDAO) instantiateDAO(PostagemDAO.class);
    }

    @Override
    public FeedDao getFeedDao() {
        return (FeedDao) instantiateDAO(FeedDao.class);
    }

}
