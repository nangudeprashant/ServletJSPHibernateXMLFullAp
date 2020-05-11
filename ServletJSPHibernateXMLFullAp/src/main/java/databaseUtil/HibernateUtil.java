package databaseUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistryBuilder registryBuilder;
    private static ServiceRegistry serviceRegistry;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
            	Configuration configuration = new Configuration().configure();
            	registryBuilder = new ServiceRegistryBuilder();
            	registryBuilder.applySettings(configuration.getProperties());
                serviceRegistry = registryBuilder.buildServiceRegistry();
                // builds a session factory from the service registry
                sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
            } catch (Exception e) {
                e.printStackTrace();
                if (registryBuilder != null) {
                    ServiceRegistryBuilder.destroy(serviceRegistry);
                }
            }
        }
        return sessionFactory;
    }
    public static void shutdown() {
        if (registryBuilder != null) {
        	ServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
    
   /* private static final SessionFactory sessionFactory1;

    static {
        try {
            sessionFactory1 = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory1() {
        return sessionFactory1;
    }*/
}
