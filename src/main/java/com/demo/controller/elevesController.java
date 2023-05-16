package com.demo.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.eleves;
import com.demo.services.elevesServices;

@Controller
public class elevesController {
	
	private elevesServices elevesservices;

	public elevesController(elevesServices elevesservices) {
		super();
		this.elevesservices = elevesservices;
	}
	
	
	 
	@GetMapping("/eleves")
	public String listEleves(Model model) {
		
	model.addAttribute("eleves",elevesservices.getallEleves());
	
		return "eleves";
	}
	@GetMapping("/eleves/new")
	public String createEleves(Model model) {
		
		eleves student = new eleves();
		model.addAttribute("student", student);
		
		return "new_eleves";
		
		
	}
	
	@GetMapping("/eleves/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        eleves eleve = elevesservices.getElevesById(id);
        byte[] imageBytes = eleve.getPhoto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);
        return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
    }
	
	@PostMapping("/eleves")
	public String saveEleves(@ModelAttribute("student") eleves student  ) {
		 elevesservices.saveEleves(student);
		 return "redirect:/eleves";
	}
	
	@GetMapping("/eleves/edit/{id}")
	public String editEleves(@PathVariable Long id, Model model) {
		
		model.addAttribute("eleve", elevesservices.getElevesById(id));
		
		return "edit_eleves";	
	}
	
	@PostMapping("/eleves/{id}")
	public String updateEleves(@PathVariable Long id,
			@ModelAttribute("eleve") eleves eleve,
			Model model) {
		
		eleves existingEleves = elevesservices.getElevesById(id);
		
		existingEleves.setId(id);
		existingEleves.setNom(eleve.getNom());
		existingEleves.setPrenom(eleve.getPrenom());
		existingEleves.setEmail(eleve.getEmail());
		
		elevesservices.updateEleves(existingEleves);
		return "redirect:/eleves";
	}
	@GetMapping("/eleves/{id}")
	public String supprimeEleves(@PathVariable Long id) {
		
		elevesservices.deleleEleveById(id);
		 return "redirect:/eleves";
	}
	
	
	    @GetMapping("/eleves/rechercher")
	    public String rechercher(@RequestParam String recherche, Model model) {
	        List<eleves> eleves = elevesservices.rechercher(recherche);
	        model.addAttribute("eleves", eleves);
	        return "eleves";
	    }

	

	
	

}
