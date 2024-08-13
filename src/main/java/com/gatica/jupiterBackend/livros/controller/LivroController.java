package com.gatica.jupiterBackend.livros.controller;

import com.gatica.jupiterBackend.livros.model.livro.Livro;
import com.gatica.jupiterBackend.livros.model.service.LivroService;
import com.gatica.jupiterBackend.livros.model.service.Pedido;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@AllArgsConstructor
public class LivroController {

    private LivroService livroService;

    @PostMapping
    public Livro addLivro(@RequestBody Pedido livroUrl){
        return livroService.addLivro(livroUrl.getUrl());
    }

    @GetMapping
    public List<Livro> getLivros(){
        return livroService.getAllLivros();
    }

    @PostMapping("/teste")
    public Livro teste(){
        return livroService.teste();
    }


}
