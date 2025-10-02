package com.example.meusgastos.domain.model;

public class ErrorResposta {

    private String dataHora;
    private String titulo;
    private Integer status;
    private String mensagem;

    public ErrorResposta(String dataHora, String titulo, Integer status, String mensagem) {
        this.dataHora = dataHora;
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
