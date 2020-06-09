package dao;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class database {

    private static SessionFactory sessionFactory = null;
    private static Configuration configuration;

    private static SessionFactory buildSessionFactory(){
        configuration = new Configuration().configure();
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "deus");

        configuration.addPackage("model").addAnnotatedClass(cidade.class);
        configuration.addPackage("model").addAnnotatedClass(contato.class);
        configuration.addPackage("model").addAnnotatedClass(tipoContato.class);
        configuration.addPackage("model").addAnnotatedClass(usuario.class);

        sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
