package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.Loja;
import br.com.hugoogle.api.model.Pedido;
import br.com.hugoogle.api.vo.RelatorioDeVendasVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT SUM(obj.valorTotal) FROM Pedido obj")
    BigDecimal getValorTotalVendido();

    @Query("SELECT produto.descricao, " +
            "SUM(item.quantidade), " +
            "MAX(pedido.dataEmissao) " +
            "FROM Pedido pedido " +
            "JOIN pedido.itens item " +
            "JOIN item.produto produto  " +
            "GROUP BY produto.descricao " +
            "ORDER BY item.quantidade DESC")
    List<Object[]> getRelatorioVendaVo();

    @Query("SELECT new br.com.hugoogle.api.vo.RelatorioDeVendasVo(produto.descricao, item.quantidade, pedido.dataEmissao)" +
            "FROM Pedido pedido " +
            "JOIN pedido.itens item " +
            "JOIN item.produto produto  " +
            "GROUP BY produto.descricao " +
            "ORDER BY item.quantidade DESC")
    List<RelatorioDeVendasVo> getRelatorioVendasVo();


    @Query("SELECT p FROM Pedido p JOIN FETCH p.loja WHERE p.loja.id = :id")
    List<Pedido> buscarPedidoPorLoja(int id);

}
