package br.ufrn.Myeclone.controler.Service;

import br.ufrn.Myeclone.DAO.DAOFactory;
import br.ufrn.Myeclone.DAO.HibernateDAOFactory;

public abstract class Service<E> implements ServiceInterface<E> {

    
    protected static final DAOFactory factory = DAOFactory.instance(HibernateDAOFactory.class);
   
    public Service() {
    }
           
   
}

