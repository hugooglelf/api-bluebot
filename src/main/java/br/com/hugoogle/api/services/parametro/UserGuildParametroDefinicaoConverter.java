package br.com.hugoogle.api.services.parametro;


import br.com.hugoogle.api.model.parametro.UserGuildParametroPorUsuario;
import br.com.hugoogle.api.model.parametro.UserGuildParametroDefinicaoEnum;
import br.com.hugoogle.api.dtos.ParametroPorUsuarioDto;
import br.com.hugoogle.api.repositories.ParametroDefinicaoRepository;
import br.com.hugoogle.api.repositories.UserGuildParametroPorUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserGuildParametroDefinicaoConverter {

    @Autowired
    private final UserGuildParametroGlobalService userGuildParametroService;


    @Autowired
    private final UserGuildParametroPorUsuarioRepository userGuildParametroPorUsuarioRepository;


    @Autowired
    private final ParametroDefinicaoRepository parametroDefinicaoRepository;

    public UserGuildParametroDefinicaoConverter(UserGuildParametroGlobalService userGuildParametroService, UserGuildParametroPorUsuarioRepository userGuildParametroPorUsuarioRepository, ParametroDefinicaoRepository parametroDefinicaoRepository) {
        this.userGuildParametroService = userGuildParametroService;
        this.userGuildParametroPorUsuarioRepository = userGuildParametroPorUsuarioRepository;
        this.parametroDefinicaoRepository = parametroDefinicaoRepository;
    }

    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void atualizarParametroUsuario(final ParametroPorUsuarioDto parametroPorUsuarioDto) {
            this.userGuildParametroService.atualizarValorParametro(UserGuildParametroDefinicaoEnum.Boolean.PRINT_ELEMENTO_SELECIONADO, parametroPorUsuarioDto.getUsuario(), parametroPorUsuarioDto.isPrintElementoSelecionado());
            this.userGuildParametroService.atualizarValorParametro(UserGuildParametroDefinicaoEnum.Boolean.BORDA_ELEMENTO_SELECIONADO, parametroPorUsuarioDto.getUsuario(), parametroPorUsuarioDto.isBordaElementoSelecionado());
            this.userGuildParametroService.atualizarValorParametro(UserGuildParametroDefinicaoEnum.Boolean.BORDA_ELEMENTO_SELECIONADO, parametroPorUsuarioDto.getUsuario(), parametroPorUsuarioDto.isBordaElementoSelecionado());

    }

    public ParametroPorUsuarioDto obterParametrosDoUsuario(final String usuario) {

        ParametroPorUsuarioDto parametroPorUsuarioDto = new ParametroPorUsuarioDto();

        Optional<UserGuildParametroPorUsuario> printElementoSelecionado = Optional.ofNullable(userGuildParametroPorUsuarioRepository.obterParametroPorUsuario(usuario, UserGuildParametroDefinicaoEnum.Boolean.PRINT_ELEMENTO_SELECIONADO.name()));
        parametroPorUsuarioDto.setPrintElementoSelecionado(printElementoSelecionado.isPresent() ? Integer.parseInt(printElementoSelecionado.get().getValor()) == 1 : false);


        Optional<UserGuildParametroPorUsuario> bordaElementoSelecionado = Optional.ofNullable(userGuildParametroPorUsuarioRepository.obterParametroPorUsuario(usuario, UserGuildParametroDefinicaoEnum.Boolean.BORDA_ELEMENTO_SELECIONADO.name()));
        parametroPorUsuarioDto.setBordaElementoSelecionado(bordaElementoSelecionado.isPresent() ? Integer.parseInt(bordaElementoSelecionado.get().getValor()) == 1 : false);

        Optional<UserGuildParametroPorUsuario> fixarBarraFerramentaDireira = Optional.ofNullable(userGuildParametroPorUsuarioRepository.obterParametroPorUsuario(usuario, UserGuildParametroDefinicaoEnum.Boolean.FIXAR_BARRA_FERRAMENTA_DIREITA.name()));
        parametroPorUsuarioDto.setFixarBarrarFerramentaDireita(bordaElementoSelecionado.isPresent() ? Integer.parseInt(fixarBarraFerramentaDireira.get().getValor()) == 1 : false);


        //   parametroPorUsuarioDto.setUsuario(printElementoSelecionado.get().getUsuario());
        if(printElementoSelecionado.isPresent() || bordaElementoSelecionado.isPresent() || fixarBarraFerramentaDireira.isPresent()) {
            parametroPorUsuarioDto.setUsuario(usuario);
        }



     //   boolean bordaElementoSelecionado = Integer.parseInt(userGuildParametroPorUsuarioRepository.obterParametroPorUsuario(usuario, UserGuildParametroUsuarioEnum.Boolean.BORDA_ELEMENTO_SELECIONADO.name()).getValor()) == 1;

  //      parametroPorUsuarioDto.setPrintElementoSelecionado(Integer.parseInt(printElementoSelecionado.getValor()) == 1);
    //    parametroPorUsuarioDto.setBordaElementoSelecionado(bordaElementoSelecionado);

        return parametroPorUsuarioDto;
    }




}
