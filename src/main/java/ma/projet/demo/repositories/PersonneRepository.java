package ma.projet.demo.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.projet.demo.entities.Auteur;
import ma.projet.demo.entities.Personne;
import ma.projet.demo.entities.Auteur;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
	
	Personne findById(int id);
	
	//Personne findByCin(String cin);
	
	//List<Personne> findById(String id);
	
	//TRouver tous les auteurs d'aun auteur
	//List<Auteur> findByAuteur(String id);
	/*
	  	Auteur findByIsbn (String isbn);
	//Trouver les auteurs parus entre deux dates 
	List<Auteur> findByDateParutionBetween (Date debut, Date fin);
*/
	
}
