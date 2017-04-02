package MAD.DAO.Entity;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import MAD.DAO.config.HibernateUtil;

public class ArtistTest {
	
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		session = HibernateUtil.getSessionFactory("/hibernate_test.cfg.xml").openSession();
		transaction = session.beginTransaction();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInsertion() {
		Artist artist = new Artist();
		artist.setName("test");
		artist.setIdDiscogs(2);
		artist.setUriDiscogs("test");
		session.save(artist);
		transaction.commit();
		
		List<Artist> listArtist = (List<Artist>) session.createCriteria(Artist.class).list();
		assertEquals(1, listArtist.size());
	}
	
	@After
	public void endSession() {
		session.close();
	}

}
