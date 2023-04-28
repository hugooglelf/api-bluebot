package br.com.hugoogle.api.dtos;

import java.io.Serializable;

public class ParametroGlobalDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean printElementoSelecionado;

    private boolean bordaElementoSelecionado;

    private boolean fixarBarraFerramentaDireita;

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

    public boolean isFixarBarraFerramentaDireita() {
        return fixarBarraFerramentaDireita;
    }

    public void setFixarBarraFerramentaDireita(boolean fixarBarraFerramentaDireita) {
        this.fixarBarraFerramentaDireita = fixarBarraFerramentaDireita;
    }
}
