package br.org.serratec.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.livraria.entitties.Livro;
import br.org.serratec.livraria.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroService livroService;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		return new ResponseEntity<>(livroService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findById(id);
		if (livro == null)
			return new ResponseEntity<>(livro, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(livro, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro) {
		livro = livroService.update(id,livro);
		return new ResponseEntity<>(livro,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = livroService.delete(id);
		if (deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
