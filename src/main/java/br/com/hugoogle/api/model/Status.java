package br.com.hugoogle.api.model;

public enum Status {

    ABERTO(0, "ABERTO"),
    FECHADO(1, "FECHADO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer cod;

    Status(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    private String descricao;


    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }


    public static Status toEnum(Integer cod){

        if(cod == null){
            return null;
        }

        for (Status x: Status.values()) {
             if(cod.equals(x.getCod())){
                 return x;
             }

        }

        throw  new IllegalArgumentException("Status invalido! " + cod);
    }
}
