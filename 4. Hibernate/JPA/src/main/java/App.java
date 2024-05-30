import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Students s=new Students();
        s.setId(1);
        s.setUsername("skpathak");
        s.setPassword("myPasss");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("p1");
        EntityManager em=emf.createEntityManager();
//        Students s=em.find(Students.class,8);
//        System.out.println(s);

        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();

    }
}
