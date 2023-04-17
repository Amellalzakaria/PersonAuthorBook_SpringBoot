package ma.projet.demo.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ma.projet.demo.entities.Livre;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.LivreRepository;

@Service
public class LivreService implements IDao<Livre> {

	@Autowired
	private LivreRepository livreRepository;

	@Override
	public Livre save(Livre o) {
		// TODO Auto-generated method stub
		return livreRepository.save(o);
	}

	@Override
	public Livre update(Livre o) {
		// TODO Auto-generated method stub
		return livreRepository.save(o);
	}

	@Override
	public void delete(Livre o) {
		// TODO Auto-generated method stub
		livreRepository.delete(o);

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return livreRepository.count();
	}

	@Override
	public Livre findById(int id) {
		// TODO Auto-generated method stub
		return livreRepository.findById(id);
	}

	@Override
	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		return livreRepository.findAll();
	}

	public ResponseEntity<Livre> findByIsbn(@PathVariable(value = "isbn") String livreIsbn)
			throws ResourceNotFoundException {
		Livre livre = livreRepository.findByIsbn(livreIsbn);
		if (livre == null) {
			throw new ResourceNotFoundException("Livre not found for this isbn :: " + livreIsbn);
		}
		return ResponseEntity.ok().body(livre);
	}

	public List<Livre> findByDateParutionBetween(
			@PathVariable("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebut,
			@PathVariable("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin) {
		return livreRepository.findByDateParutionBetween(dateDebut, dateFin);

	}
}
