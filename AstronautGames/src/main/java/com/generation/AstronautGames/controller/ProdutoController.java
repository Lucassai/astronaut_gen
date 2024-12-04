package com.generation.AstronautGames.controller;

import com.generation.AstronautGames.Model.Categoria;
import com.generation.AstronautGames.Model.Produto;
import com.generation.AstronautGames.repository.CategoriaRepository;
import com.generation.AstronautGames.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));
    }
    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
        return produtoRepository.findById(produto.getIdProduto()).map(resposta -> ResponseEntity.status(HttpStatus.OK)
                .body(produtoRepository.save(produto)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        categoriaRepository.deleteById(id);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Produto> getById(@PathVariable long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("produtos/{nomeProduto}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nomeProduto){
        List<Produto> resposta = produtoRepository.findByNomeProdutoContainingIgnoreCase(nomeProduto);
        if (resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resposta);
    }

}
