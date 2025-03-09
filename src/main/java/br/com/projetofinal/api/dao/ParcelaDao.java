package br.com.projetofinal.api.dao;

import java.util.List;

import br.com.projetofinal.api.dao.util.GetEntityManager;
import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.ParcelaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ParcelaDao implements InterfaceDao<ParcelaModel> {
    EntityManager em = GetEntityManager.getConnectionJPA();

    public void insert(ParcelaModel par) {
        em.getTransaction().begin();
        em.persist(par);
        em.getTransaction().commit();
    }

    public List<ParcelaModel> getAll() {
        return em.createQuery("SELECT p FROM Parcela p", ParcelaModel.class).getResultList();
    }

    public ParcelaModel getById(int id) {
        return em.find(ParcelaModel.class, id);
    }

    public List<ParcelaModel> getByConta(int idConta) {
        TypedQuery<ParcelaModel> query = em.createQuery(
                "SELECT p FROM Parcela p JOIN p.contaParela WHERE p.contaParcela.idConta = :id", ParcelaModel.class);
        query.setParameter("id", idConta);
        return query.getResultList();
    }

    public void update(ParcelaModel par) {
        em.getTransaction().begin();
        em.merge(par);
        em.getTransaction().commit();
    }

    public void delete(ParcelaModel par) {
        em.getTransaction().begin();
        em.remove(par);
        em.getTransaction().commit();
    }
}
