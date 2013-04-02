package BD.java.fr.univaix.iut.progbd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAOPokemonJPA implements DAOPokemon {

    private EntityManager entityManager;

    public DAOPokemonJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Pokemon> findByType(Type type) {
        TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_BY_TYPE, Pokemon.class);
        query.setParameter("ftype", type);
        return query.getResultList();
    }

    @Override
    public boolean delete(Pokemon obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Pokemon> findAll() {
        TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_ALL, Pokemon.class);
        return query.getResultList();
    }

    @Override
    public Pokemon getById(String id) {
        return entityManager.find(Pokemon.class, id);
    }

    @Override
    public Pokemon insert(Pokemon obj) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(obj);
        tx.commit();
        return entityManager.find(Pokemon.class, obj.getName());
    }

    @Override
    public boolean update(Pokemon obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void FixOwner(Pokemon pokemon,String Owner) {
   	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        pokemon.setOwner(Owner);
        tx.begin();
        em.persist(pokemon);
        tx.commit();

        em.close();
        emf.close();

   }
}
