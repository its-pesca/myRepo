package com.khaoula.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaoula.dto.EtudiantRequestDTO;
import com.khaoula.dto.EtudiantResponseDTO;
import com.khaoula.entities.Etudiant;
import com.khaoula.mapper.EtudiantInterfaceMap;
import com.khaoula.repositories.EtudiantRepository;

import jakarta.transaction.Transactional;

@Service

@Transactional
public class EtudiantServiceInterfaceImpl implements EtudiantServiceInterface {
	
	// POST
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EtudiantInterfaceMap etudiantInterfaceMap;

	@Override
	public void add(EtudiantRequestDTO etudiantRequestDTO) {
		Etudiant e = new Etudiant();
		
		e = etudiantInterfaceMap.etudiantRequestDTO2Etudiant(etudiantRequestDTO);
		
		etudiantRepository.save(e);
		
	}

	@Override
	public List<EtudiantResponseDTO> listerEtudiants() {
		List<Etudiant> liste = new ArrayList<Etudiant>();
		liste = etudiantRepository.findAll();
		
		
		List<EtudiantResponseDTO> l = new ArrayList<EtudiantResponseDTO>();
		
		for (Etudiant e:liste) {
			EtudiantResponseDTO r = new EtudiantResponseDTO();
			r = etudiantInterfaceMap.etudiant2EtudiantResponseDTO(e);
			l.add(r);
		}
		
		return l;
	}

	@Override
	public EtudiantResponseDTO EtudiantById(Integer id) {
		Etudiant e = etudiantRepository.findById(id).get();
		
		EtudiantResponseDTO r = new EtudiantResponseDTO();
		r = etudiantInterfaceMap.etudiant2EtudiantResponseDTO(e);
		return r;
	}

	@Override
	public void update(Integer id, EtudiantRequestDTO r) {
		Etudiant e1 = etudiantRepository.findById(id).get();
		
		if(r.getApogee()!=null) e1.setApogee(r.getApogee());
		if(r.getNom()!=null) e1.setNom(r.getNom());
		if(r.getPrenom()!=null) e1.setPrenom(r.getPrenom());
		if(r.getFiliere()!=null) e1.setFiliere(r.getFiliere());
		
		etudiantRepository.save(e1);
		
	}

	@Override
	public void supprime(Integer id) {

		etudiantRepository.deleteById(id);
		
	}

}
