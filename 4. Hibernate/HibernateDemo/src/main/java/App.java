import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
//        Laptop laptop = new Laptop();
//        laptop.setBrand("Dell");
//        laptop.setLid(101);

        Students stud = new Students();
//        stud.setUsername("skp");
//        stud.setPassword("1234");
//        stud.setId(8);
//        stud.getLaps().add(laptop);
//
//        laptop.setStud(stud);

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory sf=cfg.buildSessionFactory(reg);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
//        session.save(stud);
//        session.save(laptop);
        stud=(Students) session.get(Students.class,8);
        tx.commit();
        System.out.println(stud.getPassword());
    }
}
