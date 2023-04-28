package br.com.hugoogle.api.services.parametro;

import br.com.hugoogle.api.dtos.ParametroGlobalDto;
import br.com.hugoogle.api.model.parametro.*;
import br.com.hugoogle.api.repositories.ParametroDefinicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserGuildParametroGlobalService {


    @Autowired
    private final ParametroDefinicaoRepository parametroDefinicaoRepository;


    public UserGuildParametroGlobalService(ParametroDefinicaoRepository parametroDefinicaoRepository) {
        this.parametroDefinicaoRepository = parametroDefinicaoRepository;
    }



    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void atualizarValorParametro(final IUserGuildParametroBooleanDefinicao paramDef,
                                        final String usuario,
                                        final boolean valor) {
        atualizarOuCriarParametro(paramDef, usuario, valor ? "1" : "0");
    }

    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void atualizarValorParametro(final IUserGuildParametroStringDefinicao paramDef,
                                        final String usuario,
                                        final String valor) {
        atualizarOuCriarParametro(paramDef, usuario, valor);
    }

    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void atualizarValorParametro(final IUserGuildParametroIntegerDefinicao paramDef,
                                        final String usuario,
                                        final int valor) {
        atualizarOuCriarParametro(paramDef, usuario, String.valueOf(valor));
    }

    private void atualizarOuCriarParametro (final IUserGuildParametroDefinicao paramDef, final String usuario, final String valorNovo) {
//        UserGuildParametroPorUsuario oldUserGuildParametroPorUsuario = obterUserGuildParametroPorUsuario(paramDef, usuario);
//
//
//            final ParametroDefinicao parametroDefinicao = obterParametroDefinicao(paramDef);
//
//            if (oldUserGuildParametroPorUsuario != null) {
//
//                final UserGuildParametroPorUsuario newUserGuildParametroPorUsuario = new UserGuildParametroPorUsuario();
//                newUserGuildParametroPorUsuario.setParametroDefinicao(parametroDefinicao);
//                newUserGuildParametroPorUsuario.setUsuario(usuario);
//                newUserGuildParametroPorUsuario.setValor(parametroDefinicao.getValorPadrao());
//                newUserGuildParametroPorUsuario.setDataUltimaAlteracao(LocalDateTime.now());
//            }
        }


    public ParametroGlobalDto obterParametroGlobal() {

        ParametroGlobalDto parametroGlobalDto = new ParametroGlobalDto();

        Optional<ParametroDefinicao> printElementoSelecionado = Optional.ofNullable(parametroDefinicaoRepository.obterParametro(UserGuildParametroDefinicaoEnum.Boolean.PRINT_ELEMENTO_SELECIONADO.name()));
        parametroGlobalDto.setPrintElementoSelecionado(printElementoSelecionado.isPresent() ? Integer.parseInt(printElementoSelecionado.get().getValorPadrao()) == 1 : false);

        Optional<ParametroDefinicao> bordaElementoSelecionado = Optional.ofNullable(parametroDefinicaoRepository.obterParametro(UserGuildParametroDefinicaoEnum.Boolean.BORDA_ELEMENTO_SELECIONADO.name()));
        parametroGlobalDto.setBordaElementoSelecionado(bordaElementoSelecionado.isPresent() ? Integer.parseInt(bordaElementoSelecionado.get().getValorPadrao()) == 1 : false);

        Optional<ParametroDefinicao> fixarBarraFerramentaDireira = Optional.ofNullable(parametroDefinicaoRepository.obterParametro(UserGuildParametroDefinicaoEnum.Boolean.FIXAR_BARRA_FERRAMENTA_DIREITA.name()));
        parametroGlobalDto.setFixarBarraFerramentaDireita(bordaElementoSelecionado.isPresent() ? Integer.parseInt(fixarBarraFerramentaDireira.get().getValorPadrao()) == 1 : false);


        return parametroGlobalDto;
    }


}
