package com.testeAttornatus.TesteWithJava.databases.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testeAttornatus.TesteWithJava.databases.entities.Pessoa;
import java.io.Serializable;
import java.time.LocalDate;

public class PessoaDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getName();
        this.dataNascimento = pessoa.getDataNascimento();
    }

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
