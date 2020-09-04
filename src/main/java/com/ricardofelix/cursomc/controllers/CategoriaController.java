package com.ricardofelix.cursomc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardofelix.cursomc.models.Categoria;
import com.ricardofelix.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

	
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findCategoria(@PathVariable Integer id) {
		
		/*Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		
		lista.add(cat1);
		lista.add(cat2);*/
		
		Categoria categoria = categoriaService.buscar(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> postCategoria(){
		
		List<Categoria> categoria = categoriaService.buscarAll();

		return ResponseEntity.ok().body(categoria);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> postCategoria(@RequestBody Categoria categoria){
		
		Categoria cat = categoriaService.saveCategoria(categoria);

		return ResponseEntity.ok().body(cat);
		
	}
	
	
}
