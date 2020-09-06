package com.ricardofelix.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardofelix.cursomc.models.Categoria;
import com.ricardofelix.cursomc.repository.CategoriaRepository;
import com.ricardofelix.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria buscar ( Integer id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		
		return cat.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id));
		
		
	}
	
	public List<Categoria> buscarAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria saveCategoria (Categoria categoria) {
		return categoriaRepository.save(categoria);
		
	}
	
}
