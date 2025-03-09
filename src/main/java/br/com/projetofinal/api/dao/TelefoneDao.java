package br.com.projetofinal.api.dao;

import java.util.List;

import br.com.projetofinal.api.dao.util.GetEntityManager;
import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.TelefoneModel;
import jakarta.persistence.EntityManager;

public class TelefoneDao implements InterfaceDao<TelefoneModel> {
    EntityManager em = GetEntityManager.getConnectionJPA();
    
    public void insert(TelefoneModel tel) {
        em.getTransaction().begin();
        em.persist(tel);
        em.getTransaction().commit();
    }

    public List<TelefoneModel> getAll() {
        return em.createQuery("SELECT t FROM Telefone t", TelefoneModel.class).getResultList();
    }

    public TelefoneModel getById(int id) {
        return em.find(TelefoneModel.class, id);
    }

    public void update(TelefoneModel tel) {
        em.getTransaction().begin();
        em.merge(tel);
        em.getTransaction().commit();
    }

    public void delete(TelefoneModel tel) {
        em.getTransaction().begin();
        em.remove(tel);
        em.getTransaction().commit();
    }
}
