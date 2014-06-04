/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.Myeclone.controler.Service;

import br.ufrn.Myeclone.DAO.FeedDaoInterface;
import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.Exceptions.ObjetoNuloException;
import br.ufrn.Myeclone.Exceptions.ServiceException;
import br.ufrn.Myeclone.model.Feed;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class FeedService extends Service<Feed>{
    
    private FeedDaoInterface feedDao = factory.getFeedDao();
    
    public boolean validarFeed(Feed feed) throws ObjetoNuloException{
        
        if(feed == null){
            throw  new ObjetoNuloException("Feed is null");
        }
        if(feed.getDescription().equals("")){
            throw  new ObjetoNuloException("Feed.description is null");
        }
        if(feed.getLink().equals("")){
            throw  new ObjetoNuloException("Feed.link is null");
        }
        if(feed.getTitle().equals("")){
            throw  new ObjetoNuloException("Feed.title is null");
        }
        
        
        return true;
    }

    @Override
    public Feed create(Feed entity) throws ServiceException {
        try {
            if(validarFeed(entity)){
                try {
                    return feedDao.save(entity);
                } catch (DAOException ex) {
                    throw new ServiceException("erro\n"+ex.getMessage());
                }
            }
        } catch (ObjetoNuloException ex) {
            throw new ServiceException("erro\n"+ex.getMessage());
        }
        
        return  null;
    }

    @Override
    public Feed update(Feed entity) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Feed entity) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Feed retrieve(Long id) throws ServiceException {
        try {
            return feedDao.findById(Feed.class, id);
        } catch (DAOException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Feed> list() throws ServiceException {
        try {
            return feedDao.findAll(Feed.class);
        } catch (DAOException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
    
}
