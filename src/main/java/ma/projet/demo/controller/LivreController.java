package ma.projet.demo.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.projet.demo.entities.Livre;
import ma.projet.demo.repositories.LivreRepository;
import ma.projet.demo.services.LivreService;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
	@Autowired
	private LivreService livreService;
	
	@PostMapping("/save")
	public void save(@RequestBody Livre livre) {
		livreService.save(livre);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Livre l = livreService.findById(Integer.parseInt(id));
		livreService.delete(l);
	}

	@GetMapping("/all")
	public List<Livre> findAll() {
		return livreService.findAll();
	}

	/* rechercher Livre by Isbn */
	@GetMapping("/ByIsbn/{isbn}")
	public ResponseEntity<Livre> getLivreByIsbn(@PathVariable(value = "isbn") String livreIsbn)
			 {
		return livreService.findByIsbn(livreIsbn);
	}

/*trouver les livres parus entre deux dates*/
	@GetMapping("/{dateDebut}/{dateFin}")
	public List<Livre> trouverLivresParusEntre(@PathVariable("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebut,
	                                            @PathVariable("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin) {
	    return livreService.findByDateParutionBetween(dateDebut, dateFin);
	}
	
}
