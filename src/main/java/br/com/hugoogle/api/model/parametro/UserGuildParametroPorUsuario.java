package br.com.hugoogle.api.model.parametro;

import br.com.hugoogle.api.core.CacheRegion;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import static org.hibernate.id.enhanced.SequenceStyleGenerator.SEQUENCE_PARAM;

@Entity
@Table(name = "USERGUILD_PARAM_POR_USUARIO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = CacheRegion.RARELY_UPDATED_ENTITIES)
public class UserGuildParametroPorUsuario {

    public static final String SEQ_USUERGUILD_PARAM_USUARIO = "SEQ_USUERGUILD_PARAM_USUARIO";
    @Id
    @GeneratedValue(generator = SEQ_USUERGUILD_PARAM_USUARIO)
    @GenericGenerator(strategy = "sequence", name = SEQ_USUERGUILD_PARAM_USUARIO, parameters = @Parameter(name = SEQUENCE_PARAM, value = SEQ_USUERGUILD_PARAM_USUARIO))
    @Column(name = "USERGUILD_PARAM_USUARIO_KEY")
    private Integer logisticaParametroCustomizadoKey;

    private String usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USERGUILD_PARAM_DEF_KEY")
    @Enumerated(EnumType.STRING)
    private ParametroDefinicao parametroDefinicao;

    private String valor;
    private LocalDateTime dataUltimaAlteracao;


    public Integer getLogisticaParametroCustomizadoKey() {
        return logisticaParametroCustomizadoKey;
    }

    public void setLogisticaParametroCustomizadoKey(Integer logisticaParametroCustomizadoKey) {
        this.logisticaParametroCustomizadoKey = logisticaParametroCustomizadoKey;
    }

    public String getUsuario() {
        return usuario;
    }



    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ParametroDefinicao getParametroDefinicao() {
        return parametroDefinicao;
    }

    public void setParametroDefinicao(ParametroDefinicao parametroDefinicao) {
        this.parametroDefinicao = parametroDefinicao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }
}
