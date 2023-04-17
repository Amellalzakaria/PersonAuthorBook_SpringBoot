package ma.projet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.entities.Personne;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.PersonneRepository;

@Service
public class PersonneService implements IDao<Personne>{
	
	@Autowired
	private PersonneRepository personneRepository ;

	@Override
	public Personne save(Personne o) {
		// TODO Auto-generated method stub
		return personneRepository.save(o);
	}

	@Override
	public Personne update(Personne o) {
		// TODO Auto-generated method stub
		return personneRepository.save(o);
	}

	@Override
	public void delete(Personne o) {
		// TODO Auto-generated method stub
		personneRepository.delete(o);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return personneRepository.count();
	}

	@Override
	public Personne findById(int id) {
		// TODO Auto-generated method stub
		return personneRepository.findById(id);
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return personneRepository.findAll();
	}

}
