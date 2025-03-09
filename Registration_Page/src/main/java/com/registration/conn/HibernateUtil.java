package com.registration.conn;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.registration.entities.Emp;

public class HibernateUtil {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                Configuration cfg = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/myhiber");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root4321");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                properties.put(Environment.SHOW_SQL, true);

                cfg.setProperties(properties);
                cfg.addAnnotatedClass(Emp.class);

                factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }
}
