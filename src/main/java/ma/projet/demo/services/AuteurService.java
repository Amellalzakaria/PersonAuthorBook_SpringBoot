package ma.projet.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ma.projet.demo.entities.Auteur;
import ma.projet.demo.entities.Livre;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.AuteurRepository;
import ma.projet.demo.repositories.LivreRepository;

@Service
public class AuteurService implements IDao<Auteur>{
	@Autowired
	private AuteurRepository auteurRepository;
	@Autowired
	private LivreRepository livreRepository;
	@Override
	public Auteur save(Auteur o) {
		// TODO Auto-generated method stub
		return auteurRepository.save(o);
	}

	@Override
	public Auteur update(Auteur o) {
		// TODO Auto-generated method stub
		return auteurRepository.save(o);
	}

	@Override
	public void delete(Auteur o) {
		// TODO Auto-generated method stub
		auteurRepository.delete(o);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return auteurRepository.count();
	}

	@Override
	public Auteur findById(int id) {
		// TODO Auto-generated method stub
		return auteurRepository.findById(id);
	}
	
	public Auteur findByCin(String cin) {
		// TODO Auto-generated method stub
		return auteurRepository.findByCin(cin);
	}
	
	public List<Auteur> findByDateNaissance(Date dateNaissance) {
		// TODO Auto-generated method stub
		return auteurRepository.findByDateNaissance(dateNaissance);
	}
	
	public void affectToLivre(@PathVariable String id1, @PathVariable String id2) {
		// TODO Auto-generated method stub
		Livre livre = livreRepository.findById(Integer.parseInt(id1));
		Auteur auteur = auteurRepository.findById(Integer.parseInt(id2));
		livre.getAuteurs().add(auteur);
		livreRepository.save(livre);
	}

	@Override
	public List<Auteur> findAll() {
		// TODO Auto-generated method stub
		return auteurRepository.findAll();
	}

}
