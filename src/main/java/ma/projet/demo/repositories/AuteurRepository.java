package ma.projet.demo.repositories;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ma.projet.demo.entities.Auteur;



@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
	
	Auteur findById(int id);
	
	Auteur findByCin(String cin);
	
	List<Auteur> findById(String id);
	
	/*trouver les auteurs nés à une date donnée*/
	@Query("SELECT a FROM Auteur a WHERE a.dateNaissance = :dateNaissance")
	    List<Auteur> findByDateNaissance(@Param("dateNaissance") Date dateNaissance);
	
	/*
	@Modifying
    @Query("UPDATE Livre l SET l.auteur = :auteur WHERE l.id = :livreId")
    void affecterAuteurAuLivre(@Param("livreId") int livreId, @Param("auteur") Auteur auteur);
	*/
	
	//TRouver tous les auteurs d'aun auteur
	//List<Auteur> findByAuteur(String id);
	/*
	  	Auteur findByIsbn (String isbn);
	//Trouver les auteurs parus entre deux dates 
	List<Auteur> findByDateParutionBetween (Date debut, Date fin);
*/
	
}
