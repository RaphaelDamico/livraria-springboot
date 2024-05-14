package br.org.serratec.livraria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.livraria.entitties.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
