package br.com.hugoogle.api.services;

import br.com.hugoogle.api.dtos.ProdutoDto;
import br.com.hugoogle.api.model.Produto;
import br.com.hugoogle.api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoDto> listaDeProdutos() {
      return  produtoRepository.listaDeProdutos();
    }

}
