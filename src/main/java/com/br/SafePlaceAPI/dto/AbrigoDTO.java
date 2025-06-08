package com.br.SafePlaceAPI.dto;

public class AbrigoDTO {
    private Long id;
    private String nome;
    private String endereco;
    private Integer capacidade;
    private Integer ocupacaoAtual;
    private String contato;
    private String cnpj;
    private String description;
    private Long usuarioId;
    private String usuarioNome;

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
    public Integer getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    public Integer getOcupacaoAtual() {
        return ocupacaoAtual;
    }
    public void setOcupacaoAtual(Integer ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getUsuarioNome() {
        return usuarioNome;
    }
    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}
