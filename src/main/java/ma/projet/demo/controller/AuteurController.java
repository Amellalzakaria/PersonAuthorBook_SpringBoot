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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.projet.demo.entities.Auteur;
import ma.projet.demo.entities.Livre;
import ma.projet.demo.repositories.AuteurRepository;
import ma.projet.demo.repositories.LivreRepository;
import ma.projet.demo.services.AuteurService;
import ma.projet.demo.services.LivreService;

@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {
	@Autowired
	private AuteurService auteurService;
	@Autowired
	private LivreService livreService;
	
	@PostMapping("/save")
	public void save(@RequestBody Auteur auteur) {
		auteurService.save(auteur);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Auteur a = auteurService.findById(Integer.parseInt(id));
		auteurService.delete(a);
	}

	@GetMapping("/all")
	public List<Auteur> findAll() {
		return auteurService.findAll();
	}

	@GetMapping("/count")
	public long countAuteur() {
		return auteurService.count();
	}

	
	/* Récupération des détails d’une auteur */
	@GetMapping("/{id}")
	public ResponseEntity<Auteur> getAuteurById(@PathVariable(value = "id") int auteurId)
			throws ResourceNotFoundException {
		Auteur auteur = auteurService.findById(auteurId);
		if (auteur == null) {
			throw new ResourceNotFoundException("Auteur not found for this id :: " + auteurId);
		}
		return ResponseEntity.ok().body(auteur);
	}

	/* rechercher auteur by cin */
	@GetMapping("/ByCin/{cin}")
	public ResponseEntity<Auteur> getAuteurByCin(@PathVariable(value = "cin") String auteurCin)
			throws ResourceNotFoundException {
		Auteur auteur = auteurService.findByCin(auteurCin);
		if (auteur == null) {
			throw new ResourceNotFoundException("Personne not found for this id :: " + auteurCin);
		}
		return ResponseEntity.ok().body(auteur);
	}
	/*trouver les auteurs nés à une date donnée*/
	@GetMapping("dateNaissance/{dateNaissance}")
    public List<Auteur> getAuteursByDateNaissance(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateNaissance) {
        return auteurService.findByDateNaissance(dateNaissance);
    }
	/* Ajoutez également une méthode pour affecter un livre à un auteur.*/
	@PutMapping("/affectToLivre/{id1}/auteur/{id2}")
	public void affectToLivre(@PathVariable String id1, @PathVariable String id2) {
		Livre livre = livreService.findById(Integer.parseInt(id1));
		Auteur auteur = auteurService.findById(Integer.parseInt(id2));
		livre.getAuteurs().add(auteur);
		livreService.save(livre);
	}
	
}
