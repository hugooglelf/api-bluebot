package br.com.hugoogle.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Fornecedor extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fornecedor")
    private List<Pedido> pedidoList = new ArrayList<>();

    public Fornecedor() {
        super();
    }

    public Fornecedor(String nome, String cpf, String cnpj, String telefone) {
        super(nome, cpf, cnpj, telefone);
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }


}
