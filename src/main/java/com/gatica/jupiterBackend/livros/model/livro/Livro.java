package com.gatica.jupiterBackend.livros.model.livro;

import com.gatica.jupiterBackend.livros.utils.pdfUtils.PdfUtils;
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
    private String texto;
    private String keyWords;
    private int posicaoAtual;
    private int quantidadePaginas;
    private int tamanhoPosicao;


}
