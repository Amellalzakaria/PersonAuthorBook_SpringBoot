package ma.projet.demo.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Livre {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String isbn;
	private String titre;
	@Temporal(TemporalType.DATE)
	private Date dateEdition;
	
	@ManyToMany
	private List<Auteur> auteurs;
	
	
	public Livre(int id, String isbn, String titre, Date dateEdition, List<Auteur> auteurs) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.dateEdition = dateEdition;
		this.auteurs = auteurs;
	}

	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	
	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}
	
	public List<Auteur> getAuteurs() {
		return auteurs;
	}



}
