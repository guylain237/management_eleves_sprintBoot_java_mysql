package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.eleves;
@Service
public interface elevesServices {

	List<eleves> getallEleves();
	eleves saveEleves(eleves student);
	
	eleves getElevesById(Long id);
	
	eleves updateEleves(eleves eleve);
	
	void deleleEleveById(Long id);
	
    List<eleves> rechercher(String recherche) ;
}
