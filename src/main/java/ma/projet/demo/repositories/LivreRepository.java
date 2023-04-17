package ma.projet.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ma.projet.demo.entities.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {
	//
	Livre findById(int id);

	Livre findByIsbn(String isbn);

	/* trouver les livres parus entre deux dates */
	@Query("SELECT l FROM Livre l WHERE l.dateEdition BETWEEN :dateDebut AND :dateFin")
	List<Livre> findByDateParutionBetween(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);

	// TRouver tous les livres d'aun auteur
	// List<Livre> findByAuteur(String id);
	/*
	 * Livre findByIsbn (String isbn); //Trouver les livres parus entre deux dates
	 * List<Livre> findByDateParutionBetween (Date debut, Date fin);
	 */
}
