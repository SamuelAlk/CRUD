package com.lojaSA.lojaSA.service;

import com.lojaSA.lojaSA.model.document.Produto;
import com.lojaSA.lojaSA.model.dto.request.ProdutoEntradaRequest;
import com.lojaSA.lojaSA.model.dto.response.ProdutoResponse;
import com.lojaSA.lojaSA.repository.ProdutoRepository;
import com.lojaSA.lojaSA.util.Converter.ProdutosConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoResponse inserirProduto(ProdutoEntradaRequest entradaProduto){
        if (entradaProduto.getQuantidade() < 1) return null;
        if (entradaProduto.getValidade().isAfter(LocalDate.now())) return null;
        if (entradaProduto.getValor().compareTo(BigDecimal.ZERO) <= 0 ) return null;
        if (entradaProduto.getNome().length() == 0) return null;
        Produto produto = ProdutosConverter.convertProdutoEntradaRequestToProduto(entradaProduto);
        produto.setAtivo(true);
        produto = produtoRepository.save(produto);
        return ProdutosConverter.convertProdutoToProdutoResponse(produto);
    }
    public ProdutoResponse buscarProduto(String id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto == null) return null;
        return ProdutosConverter.convertProdutoToProdutoResponse(produto);
    }
    public List <ProdutoResponse> buscarProdutos(){
        List <Produto> produtos = produtoRepository.findAll();
        return ProdutosConverter.mapProdutoToProdutoResponse(produtos);
    }
    public void deletarProduto(String id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            produto.setAtivo(false);
            produtoRepository.save(produto);
        }
    }
    public ProdutoResponse atualizarProduto(String id,ProdutoEntradaRequest produtoEntradaRequest) {
        if (produtoEntradaRequest.getQuantidade() < 1) return null;
        if (produtoEntradaRequest.getValidade().isAfter(LocalDate.now())) return null;
        if (produtoEntradaRequest.getValor().compareTo(BigDecimal.ZERO) <= 0 ) return null;
        if (produtoEntradaRequest.getNome().length() == 0) return null;
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto == null) return null;
        produto.setDescricao(produtoEntradaRequest.getDescricao());
        produto.setNome(produtoEntradaRequest.getNome());
        produto.setQuantidade(produtoEntradaRequest.getQuantidade());
        produto.setValidade(produtoEntradaRequest.getValidade());
        produto.setValor(produtoEntradaRequest.getValor());
        return ProdutosConverter.convertProdutoToProdutoResponse(produtoRepository.save(produto));
   }

}
