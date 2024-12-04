package com.generation.AstronautGames.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties
    private List<Produto> produto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @NotBlank
    @Size(min = 3, max = 1000, message = "O atributo nomeCategoria deve conter entre 3 e 1000 caractéres")
    private String nomeCategoria;

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nome_categoria) {
        this.nomeCategoria = nome_categoria;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
