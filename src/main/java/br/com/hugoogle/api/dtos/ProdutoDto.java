package br.com.hugoogle.api.dtos;

import br.com.hugoogle.api.model.CodigoBarra;
import br.com.hugoogle.api.model.Produto;

public class ProdutoDto {

    String descricao;
    Long gtin;

    public ProdutoDto(Produto produto, CodigoBarra codigoBarra) {
        this.descricao = produto.getDescricao();
        this.gtin = codigoBarra.getGtin();
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getGtin() {
        return gtin;
    }

    public void setGtin(Long gtin) {
        this.gtin = gtin;
    }
}
