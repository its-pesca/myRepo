package com.khaoula.services;

import java.util.List;

import com.khaoula.dto.EtudiantRequestDTO;
import com.khaoula.dto.EtudiantResponseDTO;


public interface EtudiantServiceInterface {
	
	// POST
		public void add(EtudiantRequestDTO etudiantRequestDTO);
		//Get
		public List<EtudiantResponseDTO> listerEtudiants();
		// Get by id
		public EtudiantResponseDTO EtudiantById(Integer id);
		//put
		public void update(Integer id, EtudiantRequestDTO c);
		//delete
		public void supprime(Integer id);

}
