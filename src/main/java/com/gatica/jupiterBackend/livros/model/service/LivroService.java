package com.gatica.jupiterBackend.livros.model.service;

import com.gatica.jupiterBackend.livros.model.livro.Livro;
import com.gatica.jupiterBackend.livros.model.livro.LivroDao;
import com.gatica.jupiterBackend.livros.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository livroRepository;

    public Livro addLivro( String livroUrl) {
        LivroDao livroDao = new LivroDao(livroUrl);
        Livro livro = new Livro( livroDao.getCapa(), livroDao.getAutor(),livroDao.getTitulo(),livroDao.getTexto(),
                livroDao.getPosicaoAtual(),livroDao.getKeyWords(),livroDao.getQuantidadePaginas(),livroDao.getTamanhoPosicao());
        return livroRepository.save(livro);
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Livro teste() {
        LivroDao livroDao = new LivroDao("/Users/lucasgatica/Desktop/pdfReader/src/main/resources/pdfs/torre.pdf");
        Livro livro = new Livro( livroDao.getCapa(), livroDao.getAutor(),livroDao.getTitulo(),livroDao.getTexto(),
                livroDao.getPosicaoAtual(),livroDao.getKeyWords(),livroDao.getQuantidadePaginas(),livroDao.getTamanhoPosicao());
        return livroRepository.save(livro);
    }
}
