package br.com.hugoogle.api.dtos;

import java.math.BigDecimal;
public class PrecoDto {

    Double quantidadeMinima;
    BigDecimal preco;

    public PrecoDto(Double quantidadeMinima, BigDecimal preco) {
        this.quantidadeMinima = quantidadeMinima;
        this.preco = preco;
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
