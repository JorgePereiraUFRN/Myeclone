package br.ufrn.Myeclone.DAO;

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
	AgendaDaoInterface getAgendaDaoInterface() {
		// TODO Auto-generated method stub
		//return instantiateDAO(AgendaDao.class);
	}
	
	
	
}
