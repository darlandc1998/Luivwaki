package app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        return new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build()).getMetadataBuilder().build().getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static void closeSessionFactory(){
           sessionFactory.close();
           sessionFactory = null;
    }
    
}
