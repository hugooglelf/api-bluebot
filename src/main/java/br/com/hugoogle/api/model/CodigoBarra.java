package br.com.hugoogle.api.model;

import javax.persistence.*;

@Entity
public class CodigoBarra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    Produto produto;
    Long gtin;


    public CodigoBarra(Produto produto, Long gtin) {
        this.produto = produto;
        this.gtin = gtin;
    }

    public CodigoBarra() {

    }

    public Long getGtin() {
        return gtin;
    }

    public void setGtin(Long gtin) {
        gtin = gtin;
    }

    public Produto getProduto() {
        return produto;
    }
 public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
