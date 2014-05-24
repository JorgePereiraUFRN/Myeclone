package br.ufrn.Myeclone.controler.Service;

import java.util.List;

import br.ufrn.Myeclone.Exceptions.ServiceException;



public interface ServiceInterface<E> {
       
        public E create(E entity) throws ServiceException;
        public E update(E entity)throws ServiceException;
        public void destroy(E entity)throws ServiceException;
        public E retrieve(Long id)throws ServiceException;
        public List<E> list()throws ServiceException;

}

