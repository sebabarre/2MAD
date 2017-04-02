package MAD.DAO.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Type;

@Entity
public class Album {

	
	public Album() {
		
	}
	
	@Column(name="ID_ALBUM")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="ID_ARTIST")
	@JoinColumn(name="ID_ARTIST")
	private Integer idArtist;
	
	@Column(name="MAIN_RELEASE_DISCOGS_ID")
	private Integer idDiscogs;
	
	@Column(name="TITLE")
	private String titreAlbum;
	
	@Column(name="YEAR")
	private Integer anneeSortie;
	
	@Column(name="DATE_RELEASE")
	private Date dateSortie;
	
	@Column(name="THUMB")
	private byte[] thumb;
	
	@Column(name="DISCOGS_URI")
	private String uriDiscogs;
	
	@Column(name="IS_NEW", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isNew = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdArtist() {
		return idArtist;
	}

	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}

	public Integer getIdDiscogs() {
		return idDiscogs;
	}

	public void setIdDiscogs(Integer idDiscogs) {
		this.idDiscogs = idDiscogs;
	}

	public String getTitreAlbum() {
		return titreAlbum;
	}

	public void setTitreAlbum(String titreAlbum) {
		this.titreAlbum = titreAlbum;
	}

	public Integer getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(Integer anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
}
