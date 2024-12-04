package com.generation.AstronautGames.controller;

import com.generation.AstronautGames.Model.Categoria;
import com.generation.AstronautGames.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaRepository.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        categoriaRepository.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
        return categoriaRepository.findById(categoria.getIdCategoria()).map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(categoriaRepository.save(categoria)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("nomeCategoria/{nomeCategoria}")
    public ResponseEntity<List<Categoria>> getByNome(@PathVariable String nomeCategoria) {
        List<Categoria> resposta = categoriaRepository.findByNomeCategoriaContainingIgnoreCase(nomeCategoria);
        if (resposta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resposta);
    }
}
