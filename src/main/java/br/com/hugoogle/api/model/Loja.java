package br.com.hugoogle.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Loja extends Pessoa{


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "loja")
    private List<Pedido> pedidoList = new ArrayList<>();
    public Loja() {
    }

    public Loja(String nome, String cpf, String cnpj, String telefone) {
        super(nome, cpf, cnpj, telefone);
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
}
