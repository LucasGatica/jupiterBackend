package com.gatica.jupiterBackend.livros.model.livro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    private String id;
    private String capa;
    private String autor;
    private String titulo;
    private String[] texto;
    private String keyWords;
    private int posicaoAtual;
    private int quantidadePaginas;
    private int tamanhoPosicao;

    public Livro(String capa, String autor, String titulo, String[] texto, int posicaoAtual, String keyWords, int quantidadePaginas, int tamanhoPosicao) {
        this.capa = capa;
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
        this.posicaoAtual = posicaoAtual;
        this.keyWords = keyWords;
        this.quantidadePaginas = quantidadePaginas;
        this.tamanhoPosicao = tamanhoPosicao;
    }

}
