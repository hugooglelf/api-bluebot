package br.com.hugoogle.api.model.parametro;

import br.com.hugoogle.api.core.CacheRegion;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "USERGUILD_PARAM_DEF")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = CacheRegion.RARELY_UPDATED_ENTITIES)
public class ParametroDefinicao {
    @Id
    @Column(name = "USERGUILD_PARAM_DEF_KEY")
    private String userGuildParametroDefinicaoKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "USERGUILD_TIPO_PARAM")
    private UserGuildTipoParametroEnum userGuildSistemaEnum;
    private String valorPadrao;
    private String descricao;

    public String getUserGuildParametroDefinicaoKey() {
        return userGuildParametroDefinicaoKey;
    }

    public void setUserGuildParametroDefinicaoKey(String userGuildParametroDefinicaoKey) {
        this.userGuildParametroDefinicaoKey = userGuildParametroDefinicaoKey;
    }

    public String getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(String valorPadrao) {
        this.valorPadrao = valorPadrao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UserGuildTipoParametroEnum getUserGuildSistemaEnum() {
        return userGuildSistemaEnum;
    }

    public void setUserGuildSistemaEnum(UserGuildTipoParametroEnum userGuildSistemaEnum) {
        this.userGuildSistemaEnum = userGuildSistemaEnum;
    }
}

