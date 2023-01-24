package com.testeAttornatus.TesteWithJava.databases.entities;

import com.testeAttornatus.TesteWithJava.databases.models.dtos.PessoaDTO;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pessoa")
@EntityListeners(AuditingEntityListener.class)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private Set<Endereco> enderecoList;

    public Pessoa() {
    }

    public Pessoa(Long id, String name, LocalDate dataNascimento, Set<Endereco> enderecoList) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.enderecoList = enderecoList;
    }

    public Pessoa(PessoaDTO pessoaDTO) {
        this.id = pessoaDTO.getId();
        this.name = pessoaDTO.getNome();
        this.dataNascimento = pessoaDTO.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;
    }

    public Set<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(Set<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

}



