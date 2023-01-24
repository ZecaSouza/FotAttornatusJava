package com.testeAttornatus.TesteWithJava.module.pessoa.service;

import com.testeAttornatus.TesteWithJava.databases.entities.Pessoa;
import com.testeAttornatus.TesteWithJava.databases.models.dtos.PessoaDTO;
import com.testeAttornatus.TesteWithJava.databases.repositories.PessoaRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositry pessoaRepository;

    public List<PessoaDTO> getAllPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDTO> pessoaDTOS = new ArrayList<PessoaDTO>();
        for(Pessoa pessoa : pessoas){
            pessoaDTOS.add(new PessoaDTO(pessoa));
        }
        return pessoaDTOS;
    }
    public PessoaDTO getPessoaById(Long pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow();
        return new PessoaDTO(pessoa);
    }

    public PessoaDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return new PessoaDTO(savedPessoa);
    }

    public PessoaDTO updatePessoa(Long pessoaId, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow();
        pessoa = new Pessoa(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoa);
    }

    public void deletePessoa(Long pessoaId) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        pessoaRepository.deleteById(pessoaId);
    }

}
