package com.khaoula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.khaoula.entities.Etudiant;

@RepositoryRestController

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
