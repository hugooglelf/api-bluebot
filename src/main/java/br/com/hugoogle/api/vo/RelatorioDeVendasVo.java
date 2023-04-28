package br.com.hugoogle.api.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

    private String descricaoProduto;
    private Double quantidade;
    private LocalDate dataEmissao;


    public RelatorioDeVendasVo(String descricaoProduto, Double quantidade, LocalDate dataEmissao) {
        this.descricaoProduto = descricaoProduto;
        this.quantidade = quantidade;
        this.dataEmissao = dataEmissao;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVo{" +
                "descricao='" + descricaoProduto + '\'' +
                ", quantidade=" + quantidade +
                ", dataEmissao=" + dataEmissao +
                '}';
    }
}

