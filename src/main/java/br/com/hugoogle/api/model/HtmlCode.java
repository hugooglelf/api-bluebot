package br.com.hugoogle.api.model;

import br.com.hugoogle.api.controller.HtmlCodeController;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class HtmlCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo título não pode estar vazio.")
    @Length(min = 3, max = 35, message = "O título deverá ter entre {min} e no máximo {max} caracteres")
    private String titulo;

    private String urlPage;

    private Integer menu;
    private String elemento;

    private String passo;

    private Integer ordenacao;
    @Column(name = "intro", columnDefinition = "text")
    private String code;

    private  Integer largura;

    private String posicao;

    public HtmlCode() {

    }

    public HtmlCode(Long id, String titulo, String urlPage, Integer menu, String elemento, String passo, Integer ordenacao, String code, Integer largura, String posicao) {
        this.id = id;
        this.titulo = titulo;
        this.urlPage = urlPage;
        this.menu = menu;
        this.elemento = elemento;
        this.passo = passo;
        this.ordenacao = ordenacao;
        this.code = code;
        this.largura = largura;
        this.posicao = posicao;
    }

    public HtmlCode(HtmlCode htmlCode) {
        this.id = htmlCode.getId();
        this.titulo =htmlCode.getTitulo();
        this.urlPage = htmlCode.getCode();
        this.menu = htmlCode.getMenu();
        this.elemento = htmlCode.getElemento();
        this.passo = htmlCode.getPasso();
        this.ordenacao = htmlCode.getOrdenacao();
        this.code = htmlCode.getCode();
        this.largura = htmlCode.getLargura();
        this.posicao = htmlCode.getPosicao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlPage() {
        return urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }

    public Integer getMenu() {
        return menu;
    }

    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }

    public Integer getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(Integer ordenacao) {
        this.ordenacao = ordenacao;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }


}
