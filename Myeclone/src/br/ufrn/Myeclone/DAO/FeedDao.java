/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.model.Feed;
import java.io.Serializable;

/**
 *
 * @author jorge
 */
public class FeedDao extends GenericHibernateDAO<Feed, Long> implements FeedDaoInterface{
    
    @Override
	public Feed save(Feed entity) throws DAOException {

		try {

			try {
				getInstance().getTransaction().begin();
				getInstance().persist(entity);
				getInstance().getTransaction().commit();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
