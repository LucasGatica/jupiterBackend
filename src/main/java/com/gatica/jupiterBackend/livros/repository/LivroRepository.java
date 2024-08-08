package com.gatica.jupiterBackend.livros.repository;

import com.gatica.jupiterBackend.livros.model.livro.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
}
