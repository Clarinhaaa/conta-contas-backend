package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.dao.util.InterfaceDao;
import br.com.projetofinal.api.model.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class EnderecoDao implements InterfaceDao<EnderecoModel> {
    @PersistenceContext
    private EntityManager em;

    public List<EnderecoModel> getAll() {
        return em.createQuery("SELECT e FROM Endereco e", EnderecoModel.class).getResultList();
    }

    public EnderecoModel getById(int id) {
        return em.find(EnderecoModel.class, id);
    }

    @Transactional
    public void insert(EnderecoModel end) {
        em.persist(end);
    }

    @Transactional
    public void update(EnderecoModel end) {
        em.merge(end);
    }

    @Transactional
    public void delete(EnderecoModel end) {
        if(em.contains(end)) {
            em.remove(end);
        } else {
            EnderecoModel novoEnd = em.merge(end);
            em.remove(novoEnd);
        }
    }
}
