package com.testeAttornatus.TesteWithJava.databases.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testeAttornatus.TesteWithJava.databases.entities.Endereco;
import com.testeAttornatus.TesteWithJava.databases.models.enums.OrdemEnum;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("rua")
    private String rua;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("ordem")
    private OrdemEnum ordemEnum;

    @JsonProperty("cep")
    private Long cep;

    @JsonProperty("pessoa")
    private Long pessoa;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String rua, String cidade, String estado, OrdemEnum ordemEnum, Long cep, Long pessoa) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.ordemEnum = ordemEnum;
        this.cep = cep;
        this.pessoa = pessoa;
    }

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.ordemEnum = endereco.getOrdem();
        this.cep = endereco.getCep();
        this.pessoa = endereco.getPessoa().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public OrdemEnum getOrdemEnum() {
        return ordemEnum;
    }

    public void setOrdemEnum(OrdemEnum ordemEnum) {
        this.ordemEnum = ordemEnum;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Long getPessoa() {
        return pessoa;
    }

    public void setPessoa(Long pessoa) {
        this.pessoa = pessoa;
    }
}

