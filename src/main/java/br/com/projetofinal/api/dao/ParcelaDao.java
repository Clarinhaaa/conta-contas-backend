package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.ParcelaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ParcelaDao implements InterfaceDao<ParcelaModel> {
    @PersistenceContext
    private EntityManager em;

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

    @Transactional
    public void insert(ParcelaModel par) {
        em.persist(par);
    }

    @Transactional
    public void update(ParcelaModel par) {
        em.merge(par);
    }

    @Transactional
    public void delete(ParcelaModel par) {
        if(em.contains(par)) {
            em.remove(par);
        } else {
            ParcelaModel generatedPar = em.merge(par);
            em.remove(generatedPar);
        }
    }
}
