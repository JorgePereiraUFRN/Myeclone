package br.ufrn.Myeclone.DAO;

import java.io.Serializable;
import java.util.List;

import br.ufrn.Myeclone.Exceptions.DAOException;



public interface GenericDaoInterface<T, ID extends Serializable> {
	
	T findById(Class<T> classe, ID id) throws DAOException;
	 
    List<T> findAll(Class<T> classe)throws DAOException;
 
    T save(T entity)throws DAOException;
 
    T update(T entity)throws DAOException;
        
    void delete(T entity)throws DAOException;
}
