package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.parametro.IUserGuildParametroDefinicao;
import br.com.hugoogle.api.model.parametro.ParametroDefinicao;
import br.com.hugoogle.api.model.parametro.UserGuildParametroPorUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroDefinicaoRepository extends JpaRepository<ParametroDefinicao, String> {

    @Query("SELECT obj FROM ParametroDefinicao obj WHERE obj.userGuildParametroDefinicaoKey =:parametroDefinicaoKey")
    ParametroDefinicao obterParametro(@Param("parametroDefinicaoKey") String parametroDefinicaoKey);

}
