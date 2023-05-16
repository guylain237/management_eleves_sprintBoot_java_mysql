package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.eleves;
import com.demo.repository.elevesRepository;
import com.demo.services.elevesServices;
@Service
public class elevesServicesImpl implements elevesServices {
 
	private elevesRepository elevesrepository;
 
	
	
	public elevesServicesImpl(elevesRepository elevesrepository) {
		super();
		this.elevesrepository = elevesrepository;
	}



	@Override
	public List<eleves> getallEleves() {
		// TODO Auto-generated method stub
		return elevesrepository.findAll();
	}



	@Override
	public eleves saveEleves(eleves student) {
		// TODO Auto-generated method stub
		return elevesrepository.save(student);
	}



	@Override
	public eleves getElevesById(Long id) {
		
		return elevesrepository.findById(id).get();
	}



	@Override
	public eleves updateEleves(eleves eleve) {
		// TODO Auto-generated method stub
		return elevesrepository.save(eleve);
	}



	@Override
	public void deleleEleveById(Long id) {
		elevesrepository.deleteById(id);
		
	}
	

	@Override
	public List<eleves> rechercher(String recherche) {
		 
		return elevesrepository.findByNomContainingIgnoreCaseOrEmailContainingIgnoreCase(recherche, recherche);
			
	}


}
