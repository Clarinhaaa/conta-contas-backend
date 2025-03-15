package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.UsuarioModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class UsuarioDao implements InterfaceDao<UsuarioModel> {
    @PersistenceContext
    private EntityManager em;

    public List<UsuarioModel> getAll() {
        return em.createQuery("SELECT u FROM Usuario u", UsuarioModel.class).getResultList();
    }

    public UsuarioModel getById(int id) {
        return em.find(UsuarioModel.class, id);
    }

    @Transactional
    public void insert(UsuarioModel usu) {
        em.persist(usu);
    }

    @Transactional
    public void update(UsuarioModel usu) {
        em.merge(usu);
    }

    @Transactional
    public void delete(UsuarioModel usu) {
        if(em.contains(usu)) {
            em.remove(usu);
        }else {
            UsuarioModel novoUsu = em.merge(usu);
            em.remove(novoUsu);
        }
    }
}
