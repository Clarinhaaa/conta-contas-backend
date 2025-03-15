package br.com.projetofinal.api.dao;

import java.util.List;

import br.com.projetofinal.api.dao.util.GetEntityManager;
import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.CategoriaModel;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class CategoriaDao implements InterfaceDao<CategoriaModel> {
    EntityManager em = GetEntityManager.getConnectionJPA();

    public void insert(CategoriaModel cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    public List<CategoriaModel> getAll() {
        return em.createQuery("SELECT c FROM Categoria c", CategoriaModel.class).getResultList();
    }

    public CategoriaModel getById(int id) {
        return em.find(CategoriaModel.class, id);
    }

    public void update(CategoriaModel cat) {
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }

    @Transactional
    public void delete(CategoriaModel cat) {
        if(em.contains(cat)) {
            em.remove(cat);
        } else {
            CategoriaModel generatedCat = em.merge(cat);
            em.remove(generatedCat);
        }
    }
}
