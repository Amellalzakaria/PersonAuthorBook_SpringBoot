package ma.projet.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;


import jakarta.persistence.ManyToMany;


@Entity
public class Auteur extends Personne{
	private String email;
	@JsonIgnore
	@ManyToMany (mappedBy = "auteurs", fetch = FetchType.EAGER)
	private List<Livre> livres;
	
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}



	
	
	

}
