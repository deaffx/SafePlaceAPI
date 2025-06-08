package com.br.SafePlaceAPI.dto;

public class PontoDoacaoDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String tipoItem;
    private Long abrigoId;

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTipoItem() {
        return tipoItem;
    }
    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
    public Long getAbrigoId() {
        return abrigoId;
    }
    public void setAbrigoId(Long abrigoId) {
        this.abrigoId = abrigoId;
    }
}
