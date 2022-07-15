package com.lojaSA.lojaSA.util.Converter;

import com.lojaSA.lojaSA.model.document.Produto;
import com.lojaSA.lojaSA.model.dto.request.ProdutoEntradaRequest;
import com.lojaSA.lojaSA.model.dto.response.ProdutoResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProdutosConverter {
    public static Produto convertProdutoEntradaRequestToProduto (ProdutoEntradaRequest produtoEntradaRequest){
        return Produto.builder()
                .descricao(produtoEntradaRequest.getDescricao())
                .nome(produtoEntradaRequest.getNome())
                .quantidade(produtoEntradaRequest.getQuantidade())
                .validade(produtoEntradaRequest.getValidade())
                .valor(produtoEntradaRequest.getValor())
                .build();
    }
    public static ProdutoResponse convertProdutoToProdutoResponse (Produto produto){
        return ProdutoResponse.builder()
                .id(produto.getId())
                .descricao(produto.getDescricao())
                .nome(produto.getNome())
                .quantidade(produto.getQuantidade())
                .validade(produto.getValidade())
                .valor(produto.getValor())
                .build();
    }
    public static List<ProdutoResponse> mapProdutoToProdutoResponse (List<Produto> produtos){
        return produtos.stream().filter(produto -> produto.getAtivo() == true).map(produto -> convertProdutoToProdutoResponse(produto)).collect(Collectors.toList());
    }
}
