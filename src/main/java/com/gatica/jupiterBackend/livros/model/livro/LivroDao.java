package com.gatica.jupiterBackend.livros.model.livro;

import com.gatica.jupiterBackend.livros.utils.pdfUtils.PdfUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDao {

    private String capa;
    private String autor;
    private String titulo;
    private String[] texto;
    private String keyWords;
    private int posicaoAtual;
    private int quantidadePaginas;
    private int tamanhoPosicao;


    public LivroDao(String path) {

        try {
            PdfUtils pdfUtils = new PdfUtils(path);
            this.posicaoAtual = 0;
            this.titulo = pdfUtils.gerarTitulo();
            this.autor = pdfUtils.gerarAutor();
            this.quantidadePaginas = pdfUtils.gerarQuantidadePaginas();
            this.keyWords = pdfUtils.gerarKeywords();
            this.capa = pdfUtils.gerarCapa();
            this.texto = pdfUtils.gerarTexto();
            this.tamanhoPosicao = texto.length;
            pdfUtils.fecharPdf();
        }catch (Exception ignored){
        }
    }
}
