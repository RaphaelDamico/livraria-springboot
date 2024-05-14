package br.org.serratec.livraria.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.serratec.livraria.entitties.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
