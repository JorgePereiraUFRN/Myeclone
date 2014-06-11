package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.model.Atividade;
import br.ufrn.Myeclone.model.Postagem;
import java.sql.Time;
import java.util.List;

public interface PostagemDaoInterface extends GenericDaoInterface<Postagem, Long> {
public List<Postagem> listByHour(Time inicio, Time fim) throws DAOException; 
}
