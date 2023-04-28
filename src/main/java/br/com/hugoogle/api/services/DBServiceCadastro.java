package br.com.hugoogle.api.services;

import br.com.hugoogle.api.model.Departamento;
import br.com.hugoogle.api.model.Produto;
import br.com.hugoogle.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DBServiceCadastro {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DBServiceCadastro(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public void instanciaCadastro() {
        Departamento departamento1 = new Departamento("Limpeza");
        departamentoRepository.save(departamento1);
    }
}
