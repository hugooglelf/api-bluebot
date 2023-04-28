package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.CodigoBarra;
import br.com.hugoogle.api.model.FornecedorProduto;
import br.com.hugoogle.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodigoBarraRepository extends JpaRepository<CodigoBarra, Long> {


    @Query("SELECT obj FROM CodigoBarra obj")
    Produto findByDescricao();

}
