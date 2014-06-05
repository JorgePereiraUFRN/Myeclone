package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.model.Atividade;
import br.ufrn.Myeclone.model.Postagem;
import java.sql.Time;
import java.util.List;
import javax.persistence.Query;

public class PostagemDAO extends GenericHibernateDAO<Postagem, Long> implements PostagemDaoInterface{

    public List<Postagem> listByHour(Time inicio, Time fim) throws DAOException {
     List<Postagem> list = null;
        try {
            Query q = getInstance().createQuery(
                    "select o from " + Postagem.class.getSimpleName() + " o WHERE o.horario BETWEEN :inicio and :fim");
            q.setParameter("inicio", inicio);
            q.setParameter("fim", fim);
            list = q.getResultList();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return list;
    }
}
