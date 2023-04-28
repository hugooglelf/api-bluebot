package br.com.hugoogle.api.controller;


import br.com.hugoogle.api.dtos.FornecedorProdutoDto;
import br.com.hugoogle.api.dtos.ProdutoDto;
import br.com.hugoogle.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    ProdutoService produtoService;


    @GetMapping
    ResponseEntity<List<ProdutoDto>>  listaDeProdutos() {
        List<ProdutoDto> produtoDtos = produtoService.listaDeProdutos();
        return  ResponseEntity.ok().body(produtoDtos);
    }




}
