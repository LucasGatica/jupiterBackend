package com.gatica.jupiterBackend;

import com.gatica.jupiterBackend.livros.model.livro.LivroDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JupiterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JupiterBackendApplication.class, args);
		
		LivroDao livro = new LivroDao("/Users/lucasgatica/Desktop/pdfReader/src/main/resources/pdfs/torre.pdf");

		System.out.println(livro.getTitulo());
		System.out.println(livro.getAutor());
		System.out.println(livro.getKeyWords());
		System.out.println(livro.getTamanhoPosicao());

		int contador = 0;
		for(String palavra : livro.getTexto()){
			if(contador > 100 ){
				break;
			}
			System.out.println(palavra);
			contador++;
		}
	}
}
