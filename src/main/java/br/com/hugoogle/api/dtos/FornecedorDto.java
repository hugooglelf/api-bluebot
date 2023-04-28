package br.com.hugoogle.api.dtos;

import br.com.hugoogle.api.model.Fornecedor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class FornecedorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;
    private String telefone;

    public FornecedorDto() {
        super();
    }

    public FornecedorDto(Fornecedor obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.cnpj = obj.getCnpj();
        this.telefone = obj.getTelefone();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
