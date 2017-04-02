package MAD.DAO.Entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import MAD.DAO.config.HibernateUtil;

public class AlbumTest {

	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		session = HibernateUtil.getSessionFactory("/hibernate_test.cfg.xml").openSession();
		transaction = session.beginTransaction();
	}
	
	@Test
	public void testAlbum() {
		Artist artist = new Artist();
		artist.setName("test");
		artist.setIdDiscogs(2);
		artist.setUriDiscogs("test");
		Album album = new Album();
		album.setAnneeSortie(1998);;
		album.setNew(false);
		List<Album> listAlbum = new ArrayList<Album>();
		listAlbum.add(album);
		artist.setListAlbums(listAlbum);
		session.save(artist);
		transaction.commit();
		List<Album> listInMemory = session.createCriteria(Album.class).list();
		assertEquals(1, listInMemory.size());
	}
	

	@After
	public void endSession() {
		session.close();
	}
}
