package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.parametro.IUserGuildParametroDefinicao;
import br.com.hugoogle.api.model.parametro.ParametroDefinicao;
import br.com.hugoogle.api.model.parametro.UserGuildParametroPorUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGuildParametroPorUsuarioRepository  extends JpaRepository<UserGuildParametroPorUsuario, String> {

    @Query("SELECT obj FROM UserGuildParametroPorUsuario obj WHERE obj.usuario =:usuario")
    UserGuildParametroPorUsuario obterUsuario(@Param("usuario") String usuario);

    @Query("SELECT obj FROM UserGuildParametroPorUsuario obj WHERE obj.usuario =:usuario")
    UserGuildParametroPorUsuario obterParametro(@Param("usuario") String usuario);

    @Query("SELECT obj FROM UserGuildParametroPorUsuario obj WHERE obj.usuario =:usuario and obj.parametroDefinicao.userGuildParametroDefinicaoKey =:parametroDefinicao")
    UserGuildParametroPorUsuario obterParametroPorUsuario(@Param("usuario") String usuario, @Param("parametroDefinicao") String parametroDefinicao );

}




