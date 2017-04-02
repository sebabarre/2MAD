package MAD.DAO.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {
	
	public Artist() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ARTIST")
	private Integer Id;
	
	@Column(name="ID_ARTIST_DISCOGS")
	private Integer idDiscogs;
	
	@Column(name="NOM_ARTIST")
	private String name;
	
	@Column(name="THUMB")
	private byte[] thumb;
	
	@Column(name="DISCOGS_URI")
	private String uriDiscogs;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Album> listAlbums;
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getIdDiscogs() {
		return idDiscogs;
	}

	public void setIdDiscogs(Integer idDiscogs) {
		this.idDiscogs = idDiscogs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getThumb() {
		return thumb;
	}

	public void setThumb(byte[] thumb) {
		this.thumb = thumb;
	}

	public String getUriDiscogs() {
		return uriDiscogs;
	}

	public void setUriDiscogs(String uriDiscogs) {
		this.uriDiscogs = uriDiscogs;
	}

	public List<Album> getListAlbums() {
		return listAlbums;
	}

	public void setListAlbums(List<Album> listAlbums) {
		this.listAlbums = listAlbums;
	}
	
}
