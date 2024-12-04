package com.generation.AstronautGames.repository;

import com.generation.AstronautGames.Model.Categoria;
import com.generation.AstronautGames.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByNomeProdutoContainingIgnoreCase(@Param("nomeProduto") String nomeProduto);
}
