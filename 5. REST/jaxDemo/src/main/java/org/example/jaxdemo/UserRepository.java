package org.example.jaxdemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class UserRepository {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("p1");
    EntityManager em=emf.createEntityManager();

    public Users fetchUser(String username){
        return em.find(Users.class,username);
    }

    public List<Users> fetchAllUsers() {
        Query q = em.createQuery("from Users", Users.class);
        return (List<Users>) q.getResultList();
    }

    public void createUser(Users user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void updateUser(Users user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(String username) {
        Users user = em.find(Users.class,username);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
}
