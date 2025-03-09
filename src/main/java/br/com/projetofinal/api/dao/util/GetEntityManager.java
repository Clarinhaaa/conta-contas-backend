package br.com.projetofinal.api.dao.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetEntityManager {
    private static final String JPA = "conta-contas";
    private static EntityManagerFactory emf;

    public static EntityManager getConnectionJPA() {
        emf = Persistence.createEntityManagerFactory(JPA);
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
