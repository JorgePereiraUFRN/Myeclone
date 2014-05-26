package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.model.Atividade;
import java.util.List;

public interface AtividadesDaoInterface extends GenericDaoInterface<Atividade, Long> {

    
    public List<Atividade> listByName(String atividade) throws DAOException;
}
