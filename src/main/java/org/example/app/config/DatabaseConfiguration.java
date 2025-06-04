package org.example.app.config;

import org.example.app.entity.Student;
import org.example.app.view.AppView;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class DatabaseConfiguration {
private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try{
            Configuration configuration = getConfiguration();
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Exception e){
            new AppView().displayInfo(e.getMessage());
        }
        return sessionFactory;
    }
    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        try{
            properties.load(DatabaseConfiguration.class.getResourceAsStream("/hql.properties"));
        } catch (IOException e) {
           new AppView().displayInfo(e.getMessage());

        }
        properties.put(Environment.JAKARTA_JDBC_DRIVER, properties.getProperty("dbDriver"));
        properties.put(Environment.JAKARTA_JDBC_URL, properties.getProperty("dbUrl"));
        properties.put(Environment.JAKARTA_JDBC_USER, properties.getProperty("userName"));
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, properties.getProperty("password"));
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        configuration.setProperties(properties);
        return configuration;
    }
}
