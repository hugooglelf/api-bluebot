package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {
    @Query("SELECT obj FROM Loja obj WHERE obj.cpf =:cpf")
    Loja findByCPF(@Param("cpf") String cpf);
}
