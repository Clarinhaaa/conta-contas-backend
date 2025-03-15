package br.com.projetofinal.api.dao;

import java.util.List;

import br.com.projetofinal.api.dao.util.GetEntityManager;
import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.ContaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public class ContaDao implements InterfaceDao<ContaModel> {
    EntityManager em = GetEntityManager.getConnectionJPA();

    public void insert(ContaModel con) {
        em.getTransaction().begin();
        em.persist(con);
        em.getTransaction().commit();
    }

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

    public void update(ContaModel con) {
        em.getTransaction().begin();
        em.merge(con);
        em.getTransaction().commit();
    }

    @Transactional
    public void delete(ContaModel con) {
        if(em.contains(con)) {
            em.remove(con);
        } else {
            ContaModel generatedCon = em.merge(con);
            em.remove(generatedCon);
        }
    }
}
