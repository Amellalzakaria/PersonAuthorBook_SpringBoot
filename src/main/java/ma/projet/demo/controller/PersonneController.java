package ma.projet.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.projet.demo.entities.Personne;
import ma.projet.demo.repositories.PersonneRepository;
import ma.projet.demo.services.PersonneService;



@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
	@Autowired
	private PersonneService personneService;

	@PostMapping("/save")
	public void save(@RequestBody Personne personne) {
		personneService.save(personne);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Personne a = personneService.findById(Integer.parseInt(id));
		personneService.delete(a);
	}

	@GetMapping("/all")
	public List<Personne> findAll() {
		return personneService.findAll();
	}

	@GetMapping("/count")
	public long countPersonne() {
		return personneService.count();
	}

	/* Récupération des détails d’une personne */
	@GetMapping("/{id}")
	public ResponseEntity<Personne> getPersonneById(@PathVariable(value = "id") int personneId)
			throws ResourceNotFoundException {
		Personne personne = personneService.findById(personneId);
		if (personne == null) {
			throw new ResourceNotFoundException("Personne not found for this id :: " + personneId);
		}
		return ResponseEntity.ok().body(personne);
	}

}