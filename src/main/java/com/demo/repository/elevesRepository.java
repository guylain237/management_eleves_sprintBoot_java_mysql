package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.eleves;
@Repository
public interface elevesRepository extends JpaRepository<eleves,Long > {

	
List<eleves> findByNomContainingIgnoreCaseOrEmailContainingIgnoreCase(String nom, String email);

	

	
	
  }
