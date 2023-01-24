package com.testeAttornatus.TesteWithJava.module.endereco.service;

import com.testeAttornatus.TesteWithJava.databases.entities.Endereco;
import com.testeAttornatus.TesteWithJava.databases.entities.Pessoa;
import com.testeAttornatus.TesteWithJava.databases.models.dtos.EnderecoDTO;
import com.testeAttornatus.TesteWithJava.databases.repositories.EnderecoRepositry;
import com.testeAttornatus.TesteWithJava.databases.repositories.PessoaRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private PessoaRepositry pessoaRepository;
    private EnderecoRepositry enderecoRepository;


    public List<EnderecoDTO> getAllEnderecoByPessoa(Long pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow();
        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();
        for(Endereco endereco: pessoa.getEnderecoList()) {
            enderecoDTOList.add(new EnderecoDTO(endereco));
        }
        return enderecoDTOList;
    }


    public EnderecoDTO createEnderecoForPessoa(EnderecoDTO enderecoDTO) {
        Pessoa pessoa = pessoaRepository.findById(enderecoDTO.getPessoa()).orElseThrow();
        Endereco endereco = new Endereco(enderecoDTO, pessoa);
        endereco = enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }


    public EnderecoDTO updateEndereco(Long enderecoId, EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.findById(enderecoId).orElseThrow();
        Pessoa pessoa = pessoaRepository.findById(enderecoDTO.getPessoa()).orElseThrow();
        endereco.setRua(enderecoDTO.getRua());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setOrdem(enderecoDTO.getOrdemEnum());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setPessoa(pessoa);
        endereco = enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }


    public void deleteEndereco(Long enderecoId) {
        Endereco endereco = enderecoRepository.findById(enderecoId).orElseThrow();
        enderecoRepository.deleteById(enderecoId);
    }
}
