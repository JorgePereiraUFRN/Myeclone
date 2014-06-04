package br.ufrn.Myeclone.DAO;
import java.sql.Time;
import java.util.List;

import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.model.Atividade;
import java.sql.Time;

public interface AtividadesDaoInterface extends GenericDaoInterface<Atividade, Long> {


    
    public List<Atividade> listByName(String atividade) throws DAOException;
    
    public List<Atividade> listByHour(Time inicio, Time fim) throws  DAOException;
}
