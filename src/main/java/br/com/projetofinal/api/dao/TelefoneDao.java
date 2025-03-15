package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.TelefoneModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class TelefoneDao implements InterfaceDao<TelefoneModel> {
    @PersistenceContext
    private EntityManager em;

    public List<TelefoneModel> getAll() {
        return em.createQuery("SELECT t FROM Telefone t", TelefoneModel.class).getResultList();
    }

    public TelefoneModel getById(int id) {
        return em.find(TelefoneModel.class, id);
    }

    @Transactional
    public void insert(TelefoneModel tel) {
        em.persist(tel);
    }

    @Transactional
    public void update(TelefoneModel tel) {
        em.merge(tel);
    }

    @Transactional
    public void delete(TelefoneModel tel) {
        if(em.contains(tel)) {
            em.remove(tel);
        } else {
            TelefoneModel generatedTel = em.merge(tel);
            em.remove(generatedTel);
        }
    }
}
