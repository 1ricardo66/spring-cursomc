package com.ricardofelix.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardofelix.cursomc.models.Categoria;
import com.ricardofelix.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria buscar ( Integer id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElse(null);
	}
	
	public List<Categoria> buscarAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria saveCategoria (Categoria categoria) {
		return categoriaRepository.save(categoria);
		
	}
	
}
