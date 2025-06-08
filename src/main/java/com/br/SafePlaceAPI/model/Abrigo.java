package com.br.SafePlaceAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Abrigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotNull
    private Integer capacidade;

    private Integer ocupacaoAtual = 0;

    @NotBlank
    private String contato;

    @NotBlank
    private String cnpj;

    private String description;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
    public Integer getOcupacaoAtual() { return ocupacaoAtual; }
    public void setOcupacaoAtual(Integer ocupacaoAtual) { this.ocupacaoAtual = ocupacaoAtual; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
