package br.com.projetofinal.api.dao;

import java.util.List;

import br.com.projetofinal.api.dao.util.GetEntityManager;
import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.EnderecoModel;
import jakarta.persistence.EntityManager;

public class EnderecoDao implements InterfaceDao<EnderecoModel> {
    EntityManager em = GetEntityManager.getConnectionJPA();

    public void insert(EnderecoModel end) {
        em.getTransaction().begin();
        em.persist(end);
        em.getTransaction().commit();
    }

    public List<EnderecoModel> getAll() {
        return em.createQuery("SELECT e FROM Endereco e", EnderecoModel.class).getResultList();
    }

    public EnderecoModel getById(int id) {
        return em.find(EnderecoModel.class, id);
    }

    public void update(EnderecoModel end) {
        em.getTransaction().begin();
        em.merge(end);
        em.getTransaction().commit();
    }

    public void delete(EnderecoModel end) {
        em.getTransaction().begin();
        em.remove(end);
        em.getTransaction().commit();
    }
}
