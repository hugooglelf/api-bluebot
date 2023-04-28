package br.com.hugoogle.api.model.parametro;

public class UserGuildParametroDefinicaoEnum {

    private UserGuildParametroDefinicaoEnum() {
    }

    public enum Boolean implements IUserGuildParametroBooleanDefinicao {

        PRINT_ELEMENTO_SELECIONADO,
        BORDA_ELEMENTO_SELECIONADO,

        FIXAR_BARRA_FERRAMENTA_DIREITA
    }
}
