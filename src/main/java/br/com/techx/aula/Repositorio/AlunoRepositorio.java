package br.com.techx.aula.Repositorio;

import br.com.techx.aula.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepositorio extends JpaRepository <Aluno, Long>{

    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
