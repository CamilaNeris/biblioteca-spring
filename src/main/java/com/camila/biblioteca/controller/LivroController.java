package com.camila.biblioteca.controller;

import com.camila.biblioteca.model.Livro;
import com.camila.biblioteca.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository repository;

    public LivroController(LivroRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Livro> listar(){
        return repository.findAll();
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro){
        return repository.save(livro);
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id){
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro){
        livro.setId(id);
        return repository.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        repository.deleteById(id);
    }
}
