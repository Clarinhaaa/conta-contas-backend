package br.com.projetofinal.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projetofinal.api.model.UsuarioModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class AuthDao {
    @PersistenceContext
    private EntityManager em;

    public UsuarioModel getByEmailAndSenha(String emailUsu, String senhaUsu) {
        TypedQuery<UsuarioModel> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.emailUsuario = :email AND u.senhaUsuario = :senha", UsuarioModel.class);
        query.setParameter("email", emailUsu);
        query.setParameter("senha", senhaUsu);
        List<UsuarioModel> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
