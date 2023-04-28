package br.com.hugoogle.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class FornecedorProduto implements Serializable {

    private static final long serialVersionUID = 25222L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    Produto produto;

    Double quantidadeMinima;

    BigDecimal preco;

    public FornecedorProduto(Fornecedor fornecedor, Produto produto, Double quantidadeMinima, BigDecimal preco) {
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.quantidadeMinima = quantidadeMinima;
        this.preco = preco;
    }

    public FornecedorProduto() {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
