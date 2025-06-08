package com.br.SafePlaceAPI.dto;

import java.time.LocalDateTime;

public class AlertaDTO {
    private Long id;
    private String tipo;
    private String descricao;
    private LocalDateTime datahora;
    private Long abrigoId;

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDateTime getDatahora() {
        return datahora;
    }
    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }
    public Long getAbrigoId() {
        return abrigoId;
    }
    public void setAbrigoId(Long abrigoId) {
        this.abrigoId = abrigoId;
    }
}
