package br.com.hugoogle.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loja_id")
    private Loja loja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoItem> itens = new ArrayList<>();
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataEmissao;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataFechado;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String observacoes;
    private BigDecimal valorTotal = BigDecimal.ZERO;

    public Pedido(List<PedidoItem> itens) {
        super();
        this.itens = itens;
    }

    public Pedido(Fornecedor fornecedor, Loja loja) {
        this.setDataEmissao(LocalDate.now());
        this.setStatus(Status.ABERTO);
        this.fornecedor = fornecedor;
        this.loja = loja;
    }

    public Pedido() {

    }

    public Pedido(Loja loja, Fornecedor fornecedor, List<PedidoItem> itens, LocalDate dataEmissao, LocalDate dataFechado, Status status, String observacoes, BigDecimal valorTotal) {
        this.loja = loja;
        this.fornecedor = fornecedor;
        this.itens = itens;
        this.dataEmissao = dataEmissao;
        this.dataFechado = dataFechado;
        this.status = status;
        this.observacoes = observacoes;
        this.valorTotal = valorTotal;
    }

    public void adicionarItem (PedidoItem item) {
        item.setPedido(this);
        this.itens.add(item);
        this.valorTotal = this.valorTotal.add(item.getValorTotal());
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataFechado() {
        return dataFechado;
    }

    public void setDataFechado(LocalDate dataFechado) {
        this.dataFechado = dataFechado;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}