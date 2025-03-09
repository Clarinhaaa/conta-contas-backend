package br.com.projetofinal.api.dao;

import java.util.List;

import br.com.projetofinal.api.dao.util.GetEntityManager;
import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.UsuarioModel;
import jakarta.persistence.EntityManager;

public class UsuarioDao implements InterfaceDao<UsuarioModel> {
    EntityManager em = GetEntityManager.getConnectionJPA();
    
    public void insert(UsuarioModel usu) {
        em.getTransaction().begin();
        em.persist(usu);
        em.getTransaction().commit();
    }

    public List<UsuarioModel> getAll() {
        return em.createQuery("SELECT u FROM Usuario u", UsuarioModel.class).getResultList();
    }

    public UsuarioModel getById(int id) {
        return em.find(UsuarioModel.class, id);
    }

    public void update(UsuarioModel usu) {
        em.getTransaction().begin();
        em.merge(usu);
        em.getTransaction().commit();
    }

    public void delete(UsuarioModel usu) {
        em.getTransaction().begin();
        em.remove(usu);
        em.getTransaction().commit();
    }
}
