package br.org.serratec.livraria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.livraria.entitties.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
