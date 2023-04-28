package br.com.hugoogle.api.services.parametro;

import br.com.hugoogle.api.dtos.FornecedorDto;
import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.parametro.IUserGuildParametroBooleanDefinicao;
import br.com.hugoogle.api.model.parametro.ParametroDefinicao;
import br.com.hugoogle.api.model.parametro.UserGuildParametroDefinicaoEnum;
import br.com.hugoogle.api.model.parametro.UserGuildParametroPorUsuario;
import br.com.hugoogle.api.repositories.ParametroDefinicaoRepository;
import br.com.hugoogle.api.repositories.UserGuildParametroPorUsuarioRepository;
import br.com.hugoogle.api.services.exception.DataIntegratyonViolationException;
import br.com.hugoogle.api.dtos.ParametroPorUsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParametroPorUsuarioService {

    @Autowired
    private final UserGuildParametroDefinicaoConverter userGuildParametroDefinicaoConverter;

    @Autowired
    private final UserGuildParametroPorUsuarioRepository userGuildParametroPorUsuarioRepository;

    @Autowired final UserGuildParametroGlobalService userGuildParametroGlobalService;

    @Autowired final ParametroDefinicaoRepository parametroDefinicaoRepository;


    public ParametroPorUsuarioService(UserGuildParametroDefinicaoConverter userGuildParametroDefinicaoConverter, UserGuildParametroPorUsuarioRepository userGuildParametroPorUsuarioRepository, UserGuildParametroGlobalService userGuildParametroGlobalService, ParametroDefinicaoRepository parametroDefinicaoRepository) {
        this.userGuildParametroDefinicaoConverter = userGuildParametroDefinicaoConverter;
        this.userGuildParametroPorUsuarioRepository = userGuildParametroPorUsuarioRepository;
        this.userGuildParametroGlobalService = userGuildParametroGlobalService;
        this.parametroDefinicaoRepository = parametroDefinicaoRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ParametroPorUsuarioDto salvarParametroPorUsuario(ParametroPorUsuarioDto parametroPorUsuarioDto) {

      final  Map<String, Boolean> isPrintSelecionado =  this.atualizarValorParametro(UserGuildParametroDefinicaoEnum.Boolean.PRINT_ELEMENTO_SELECIONADO, parametroPorUsuarioDto.getUsuario(), parametroPorUsuarioDto.isPrintElementoSelecionado());
      final  Map<String, Boolean> isBordaElementoSelecionado = this.atualizarValorParametro(UserGuildParametroDefinicaoEnum.Boolean.BORDA_ELEMENTO_SELECIONADO, parametroPorUsuarioDto.getUsuario(), parametroPorUsuarioDto.isBordaElementoSelecionado());
      final  Map<String, Boolean> isFixarBarraFerramentaDireita =  this.atualizarValorParametro(UserGuildParametroDefinicaoEnum.Boolean.FIXAR_BARRA_FERRAMENTA_DIREITA, parametroPorUsuarioDto.getUsuario(), parametroPorUsuarioDto.isFixarBarrarFerramentaDireita());

      ParametroPorUsuarioDto parametroPorUsuarioDtoAtualizado = new ParametroPorUsuarioDto();
      parametroPorUsuarioDtoAtualizado.setUsuario(isPrintSelecionado.keySet().stream().findAny().get());
      parametroPorUsuarioDtoAtualizado.setPrintElementoSelecionado(isPrintSelecionado.values().stream().findAny().orElse(false));
      parametroPorUsuarioDtoAtualizado.setBordaElementoSelecionado(isBordaElementoSelecionado.values().stream().findAny().orElse(false));
      parametroPorUsuarioDtoAtualizado.setFixarBarrarFerramentaDireita(isFixarBarraFerramentaDireita.values().stream().findAny().orElse(false));
        return parametroPorUsuarioDtoAtualizado;

    }

    public ParametroPorUsuarioDto obterParametroDoUsuario(final String usuario) {
        return userGuildParametroDefinicaoConverter.obterParametrosDoUsuario(usuario);
    }


    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public  Map<String, Boolean> atualizarValorParametro(final IUserGuildParametroBooleanDefinicao paramDef,
                                        final String usuario,
                                        final boolean valor) {
       return atualizarOuCriarParametro(paramDef, usuario, valor ? "1" : "0");
    }

    private Map<String, Boolean> atualizarOuCriarParametro (final IUserGuildParametroBooleanDefinicao paramDef,
                                                            final String usuario,
                                                            final String valor) {

        UserGuildParametroPorUsuario userGuildParametroPorUsuario = userGuildParametroPorUsuarioRepository.obterParametroPorUsuario(usuario, paramDef.name());
        Map<String, Boolean> mapUsuarioStatusParametro = new HashMap<>();
        if (userGuildParametroPorUsuario != null) {
            userGuildParametroPorUsuario.setValor(valor);
            mapUsuarioStatusParametro.put(userGuildParametroPorUsuario.getUsuario(), userGuildParametroPorUsuario.getValor() == "1" ? true : false);
          return mapUsuarioStatusParametro;
        }

        else {
            ParametroDefinicao parametroDefinicao = parametroDefinicaoRepository.obterParametro(paramDef.name());
            userGuildParametroPorUsuario = new UserGuildParametroPorUsuario();
            userGuildParametroPorUsuario.setParametroDefinicao(parametroDefinicao);
            userGuildParametroPorUsuario.setUsuario(usuario);
            userGuildParametroPorUsuario.setValor(valor);
            userGuildParametroPorUsuario.setDataUltimaAlteracao(LocalDateTime.now());
            userGuildParametroPorUsuarioRepository.save(userGuildParametroPorUsuario);
            mapUsuarioStatusParametro.put(userGuildParametroPorUsuario.getUsuario(), userGuildParametroPorUsuario.getValor() == "1" ? true : false);
            return mapUsuarioStatusParametro;

        }

    }




}
