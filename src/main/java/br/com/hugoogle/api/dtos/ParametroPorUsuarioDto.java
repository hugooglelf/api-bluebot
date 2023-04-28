package br.com.hugoogle.api.dtos;

import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.parametro.ParametroDefinicao;
import br.com.hugoogle.api.model.parametro.UserGuildParametroPorUsuario;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ParametroPorUsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;
//
//    private Integer logisticaParametroCustomizadoKey;
//    private ParametroDefinicao parametroDefinicao;
//    private LocalDateTime dataUltimaAlteracao;
    private String usuario;
//    private String valor;
    private boolean printElementoSelecionado;

    private boolean bordaElementoSelecionado;

    private boolean fixarBarrarFerramentaDireita;



//    public ParametroPorUsuarioDto(final UserGuildParametroPorUsuario obj) {
//        this.logisticaParametroCustomizadoKey = obj.getLogisticaParametroCustomizadoKey();
//        this.usuario = obj.getUsuario();
//        this.parametroDefinicao = obj.getParametroDefinicao();
//        this.valor = obj.getUsuario();
//        this.dataUltimaAlteracao = obj.getDataUltimaAlteracao();
//
//    }

//    public Integer getLogisticaParametroCustomizadoKey() {
//        return logisticaParametroCustomizadoKey;
//    }
//
//    public void setLogisticaParametroCustomizadoKey(Integer logisticaParametroCustomizadoKey) {
//        this.logisticaParametroCustomizadoKey = logisticaParametroCustomizadoKey;
//    }
//
//    public ParametroDefinicao getParametroDefinicao() {
//        return parametroDefinicao;
//    }
//
//    public void setParametroDefinicao(ParametroDefinicao parametroDefinicao) {
//        this.parametroDefinicao = parametroDefinicao;
//    }
//
//    public LocalDateTime getDataUltimaAlteracao() {
//        return dataUltimaAlteracao;
//    }
//
//    public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
//        this.dataUltimaAlteracao = dataUltimaAlteracao;
//    }
//
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
//
//    public String getValor() {
//        return valor;
//    }
//
//    public void setValor(String valor) {
//        this.valor = valor;
//    }
//

    public boolean isPrintElementoSelecionado() {
        return printElementoSelecionado;
    }

    public void setPrintElementoSelecionado(boolean printElementoSelecionado) {
        this.printElementoSelecionado = printElementoSelecionado;
    }

    public boolean isBordaElementoSelecionado() {
        return bordaElementoSelecionado;
    }

    public void setBordaElementoSelecionado(boolean bordaElementoSelecionado) {
        this.bordaElementoSelecionado = bordaElementoSelecionado;
    }

    public boolean isFixarBarrarFerramentaDireita() {
        return fixarBarrarFerramentaDireita;
    }

    public void setFixarBarrarFerramentaDireita(boolean fixarBarrarFerramentaDireita) {
        this.fixarBarrarFerramentaDireita = fixarBarrarFerramentaDireita;
    }
}
