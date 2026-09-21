package br.com.techx.aula.service;

import br.com.techx.aula.Model.Aluno;
import br.com.techx.aula.Repositorio.AlunoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepositorio alunoRepositorio;

    public AlunoService(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    public List<Aluno> findAll() {
        return alunoRepositorio.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepositorio.findById(id);
    }

    public List<Aluno> findByNome(String nome) {
        return alunoRepositorio.findByNomeContainingIgnoreCase(nome);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepositorio.save(aluno);
    }
}
