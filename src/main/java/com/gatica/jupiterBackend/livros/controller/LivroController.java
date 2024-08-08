package com.gatica.jupiterBackend.livros.controller;

import com.gatica.jupiterBackend.livros.model.livro.Livro;
import com.gatica.jupiterBackend.livros.model.service.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
@AllArgsConstructor
public class LivroController {

    private LivroService livroService;

    @PostMapping
    public Livro addLivro(String livroUrl){
        return livroService.addLivro(livroUrl);
    }

}
