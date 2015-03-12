package isamm.tn.dao ; 

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Adresse;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static SessionFactory buildSessionFactory() 
    {
        Configuration cfg = new Configuration().addResource(HIBERNATE_CFG).configure();
        cfg.configure().addAnnotatedClass(Adherent.class); 
        cfg.configure().addAnnotatedClass(Document.class); 
        cfg.configure().addAnnotatedClass(Emprunt.class); 
        cfg.configure().addAnnotatedClass(Administrateur.class); 
        cfg.configure().addAnnotatedClass(Adresse.class); 
        
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        getSessionFactory().close();
    }

}
