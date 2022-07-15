package com.lojaSA.lojaSA.repository;

import com.lojaSA.lojaSA.model.document.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto,String> {
}
