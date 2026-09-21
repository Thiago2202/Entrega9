package br.com.techx.aula.controller;

import br.com.techx.aula.Model.Aluno;
import br.com.techx.aula.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    // TODO: troque pelos seus dados reais antes de entregar a atividade
    private static final String NOME_ALUNO = "Thiago";
    private static final int RA_ALUNO = 2026001;

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // GET /aluno -> lista todos os alunos cadastrados no banco
    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.findAll();
    }

    // GET /aluno/{id} -> busca um aluno pelo id (@PathVariable)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id) {
        return alunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /aluno/buscar?nome=... -> busca alunos pelo nome (@RequestParam)
    @GetMapping("/buscar")
    public List<Aluno> buscarPorNome(@RequestParam String nome) {
        return alunoService.findByNome(nome);
    }

    // POST /aluno -> cria um novo aluno (@RequestBody), persistindo no PostgreSQL
    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno salvo = alunoService.save(aluno);
        return ResponseEntity.ok(salvo);
    }

    // GET /aluno/desafio -> desafio pratico da aula: frase fixa com nome e RA do aluno
    @GetMapping("/desafio")
    public String desafio() {
        return "O RA do aluno " + NOME_ALUNO + " é " + RA_ALUNO;
    }
}
