package MAD.DAO.config;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Test;

public class ConfigTest {
	
	private Session session;

	@Test
	public void testConnection() {
		session = HibernateUtil.getSessionFactory("/hibernate_test.cfg.xml").openSession();
		assertNotNull(session);
	}
	
	@After
	public void endSession() {
		session.close();
	}

}
