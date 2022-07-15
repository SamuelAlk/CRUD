package com.lojaSA.lojaSA.controller;

import com.lojaSA.lojaSA.model.dto.request.ProdutoEntradaRequest;
import com.lojaSA.lojaSA.model.dto.response.ProdutoResponse;
import com.lojaSA.lojaSA.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;
    @GetMapping("/{id}")
    public ProdutoResponse buscarProduto(@PathVariable("id") String id){
        return produtoService.buscarProduto(id);
    }
    @GetMapping("/")
    public List <ProdutoResponse> buscarProdutos(){
        return produtoService.buscarProdutos();
    }
    @PostMapping("/")
    public ProdutoResponse inserirProduto(@RequestBody ProdutoEntradaRequest entradaRequest){
        return produtoService.inserirProduto(entradaRequest);
    }
    @PutMapping("/{id}")
    public ProdutoResponse atualizarProduto(@PathVariable String id,@RequestBody ProdutoEntradaRequest entradaRequest){
        return produtoService.atualizarProduto(id,entradaRequest);
    }
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") String id){
        produtoService.deletarProduto(id);
    }
}
