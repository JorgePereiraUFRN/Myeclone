package br.ufrn.Myeclone.DAO;

import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.model.Atividade;
import java.util.List;
import javax.persistence.Query;

public class AtividadeDAO extends GenericHibernateDAO<Atividade, Long> implements AtividadesDaoInterface {

    @Override
    public List<Atividade> listByName(String atividade) throws DAOException {
        List<Atividade> list = null;
        try {

            Query q = getInstance().createQuery(
                    "select o from " + Atividade.class.getSimpleName() + " o WHERE o.atividade LIKE :atividade ORDER BY o.cumprido");
            q.setParameter("atividade", "%"+atividade+"%");
            list = q.getResultList();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return list;
    }

}
