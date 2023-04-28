package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    @Query("SELECT obj FROM Fornecedor obj WHERE obj.cpf =:cpf")
    Fornecedor findByCPF(@Param("cpf") String cpf);
}
