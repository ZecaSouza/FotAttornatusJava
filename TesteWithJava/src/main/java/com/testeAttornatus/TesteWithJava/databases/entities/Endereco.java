package com.testeAttornatus.TesteWithJava.databases.entities;

import com.testeAttornatus.TesteWithJava.databases.models.dtos.EnderecoDTO;
import com.testeAttornatus.TesteWithJava.databases.models.enums.OrdemEnum;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "endereco")
@EntityListeners(AuditingEntityListener.class)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "ordem")
    @Enumerated(EnumType.STRING)
    private OrdemEnum ordem;

    @Column(name = "cep")
    private Long cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(Long id, String rua, String cidade, String estado, OrdemEnum ordem, Long cep, Pessoa pessoa) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.ordem = ordem;
        this.cep = cep;
        this.pessoa = pessoa;
    }

    public Endereco(EnderecoDTO enderecoDTO, Pessoa pessoa) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
        this.cep = enderecoDTO.getCep();
        this.pessoa = pessoa;
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

    public OrdemEnum getOrdem() {
        return ordem;
    }

    public void setOrdem(OrdemEnum ordem) {
        this.ordem = ordem;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}