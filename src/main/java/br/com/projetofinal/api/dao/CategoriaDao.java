package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.CategoriaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaDao implements InterfaceDao<CategoriaModel> {
    @PersistenceContext
    private EntityManager em;

    public List<CategoriaModel> getAll() {
        return em.createQuery("SELECT c FROM Categoria c", CategoriaModel.class).getResultList();
    }

    public CategoriaModel getById(int id) {
        return em.find(CategoriaModel.class, id);
    }

    @Transactional
    public void insert(CategoriaModel cat) {
        em.persist(cat);
    }

    @Transactional
    public void update(CategoriaModel cat) {
        em.merge(cat);
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
