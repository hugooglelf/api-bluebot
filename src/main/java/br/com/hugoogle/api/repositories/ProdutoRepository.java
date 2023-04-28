package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.dtos.FornecedorProdutoDto;
import br.com.hugoogle.api.dtos.ProdutoDto;
import br.com.hugoogle.api.model.Produto;
import br.com.hugoogle.api.vo.RelatorioDeVendasVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT obj FROM Produto obj WHERE obj.descricao =:descricao")
    Produto findByDescricao(@Param("descricao") String descricao);

    @Query("SELECT new br.com.hugoogle.api.dtos.ProdutoDto(produto, codigoBarra) " +
            "FROM CodigoBarra codigoBarra " +
            "JOIN codigoBarra.produto produto " +
            "ORDER BY produto.descricao DESC")
    List<ProdutoDto> listaDeProdutos();

}
