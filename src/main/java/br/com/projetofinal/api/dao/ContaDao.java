package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.ContaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ContaDao implements InterfaceDao<ContaModel> {
    @PersistenceContext
    private EntityManager em;

    public List<ContaModel> getAll() {
        return em.createQuery("SELECT c FROM Conta c", ContaModel.class).getResultList();
    }

    public ContaModel getById(int id) {
        return em.find(ContaModel.class, id);
    }

    public List<ContaModel> getByUsuario(int idUsuario) {
        TypedQuery<ContaModel> query = em.createQuery(
                "SELECT c FROM Conta c JOIN c.usuarioConta WHERE c.usuarioConta.idUsuario = :id", ContaModel.class);
        query.setParameter("id", idUsuario);
        return query.getResultList();
    }

    @Transactional
    public void insert(ContaModel con) {
        em.persist(con);
    }

    @Transactional
    public void update(ContaModel con) {
        em.merge(con);
    }

    @Transactional
    public void delete(ContaModel con) {
        if (em.contains(con)) {
            em.remove(con);
        } else {
            ContaModel generatedCon = em.merge(con);
            em.remove(generatedCon);
        }
    }
}
