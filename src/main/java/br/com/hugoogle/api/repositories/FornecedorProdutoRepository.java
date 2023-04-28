package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.dtos.FornecedorProdutoDto;
import br.com.hugoogle.api.dtos.PrecoDto;
import br.com.hugoogle.api.model.FornecedorProduto;
import br.com.hugoogle.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorProdutoRepository extends JpaRepository<FornecedorProduto, Long> {


    @Query("SELECT obj FROM Produto obj WHERE obj.descricao =:descricao")
    Produto findByDescricao(@Param("descricao") String descricao);

    @Query("SELECT new br.com.hugoogle.api.dtos.FornecedorProdutoDto(fornecedorProduto.fornecedor.nome, fornecedorProduto.fornecedor.cnpj, fornecedorProduto.fornecedor.cpf) " +
            "FROM CodigoBarra c, FornecedorProduto fornecedorProduto " +
            "JOIN fornecedorProduto.produto produto " +
            "JOIN fornecedorProduto.fornecedor fornecedor  " +
            "WHERE c.gtin =:gtin " +
            "GROUP BY fornecedorProduto.fornecedor ")
    List<FornecedorProdutoDto> listaFornecedorGtin(@Param("gtin") Long gtin);

    @Query("SELECT  new br.com.hugoogle.api.dtos.PrecoDto(fornecedorProduto.quantidadeMinima, fornecedorProduto.preco) " +
            "FROM CodigoBarra c, FornecedorProduto fornecedorProduto " +
            "JOIN fornecedorProduto.produto produto " +
            "JOIN fornecedorProduto.fornecedor fornecedor  " +
            "WHERE c.gtin =:gtin " +
            "AND (fornecedor.cpf is not null) AND fornecedor.cpf =:cpf " +
            "OR (fornecedor.cnpj is not null) AND fornecedor.cnpj =:cnpj " +
            "GROUP BY fornecedorProduto.fornecedor, fornecedorProduto.preco, fornecedorProduto.quantidadeMinima ")
    List<PrecoDto> listaPrecoQuantidadePorGtin(@Param("gtin") Long gtin, @Param("cnpj") String cnpj, @Param("cpf") String cpf);
}
