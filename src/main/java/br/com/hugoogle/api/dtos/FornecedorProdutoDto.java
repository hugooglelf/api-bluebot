package br.com.hugoogle.api.dtos;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FornecedorProdutoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;

    private List<PrecoDto> precos = new ArrayList<>();


    public FornecedorProdutoDto() {
        super();
    }

    public FornecedorProdutoDto(String nome, String cnpj, String cpf) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cpf = cpf;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<PrecoDto> getPrecos() {
        return precos;
    }

    public void setPrecos(List<PrecoDto> precos) {
        this.precos = precos;
    }


}
