package br.com.hugoogle.api.controller.exception;

public class StandardError {
    private Integer status;
    private Long timesTamp;
    private String messagem;

    public StandardError(Integer status, Long timesTamp, String messagem) {
        this.status = status;
        this.timesTamp = timesTamp;
        this.messagem = messagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Long timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
}
