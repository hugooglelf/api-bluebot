package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.HtmlCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HtmlCodeRepository extends JpaRepository<HtmlCode, Long> {


    @Query("SELECT obj FROM HtmlCode obj WHERE obj.elemento =:elemento and obj.urlPage =:urlPage ")
    Optional<HtmlCode> findByElemento(@Param("elemento") String elemento, @Param("urlPage") String urlPage );
}
