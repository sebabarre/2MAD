package MAD.DAO.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;

	private static SessionFactory buildSessionFactory(String path)
	{
		try
		{
			if (sessionFactory == null)
			{
				Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource(path));
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			return sessionFactory;
		} catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory(String path)
	{
		if (sessionFactory == null) {
			buildSessionFactory(path);
		}
		return sessionFactory;
	}

	public static void shutdown()
	{
		getSessionFactory(null).close();
	}
}
