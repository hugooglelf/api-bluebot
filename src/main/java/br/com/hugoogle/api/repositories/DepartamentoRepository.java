package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    @Query("SELECT obj FROM Departamento obj WHERE obj.descricao =:descricao")
    Departamento findByDescricao(@Param("descricao") String descricao);

}
