package br.com.hugoogle.api.model;

import br.com.hugoogle.api.services.DBService;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Double quantidade;

    private BigDecimal precoUnitario;


    public PedidoItem(Pedido pedido, Produto produto, Double quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    public PedidoItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int compare(PedidoItem pedido, PedidoItem outroPedidoItem) {
        return pedido.getQuantidade().compareTo(outroPedidoItem.getQuantidade());
    }

    public BigDecimal getValorTotal() {
        return this.precoUnitario.multiply(new BigDecimal(quantidade));
    }

}
