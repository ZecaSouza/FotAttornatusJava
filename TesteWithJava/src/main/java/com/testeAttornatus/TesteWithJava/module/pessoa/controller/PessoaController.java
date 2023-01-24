package com.testeAttornatus.TesteWithJava.module.pessoa.controller;

import com.testeAttornatus.TesteWithJava.databases.models.dtos.PessoaDTO;
import com.testeAttornatus.TesteWithJava.module.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PessoaDTO> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @GetMapping(value = "{pessoaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaDTO getPessoaById(@PathVariable Long pessoaId) {
        return pessoaService.getPessoaById(pessoaId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaDTO createPessoa(@RequestBody PessoaDTO pessoaDTO){
        return pessoaService.createPessoa(pessoaDTO);
    }

    @PutMapping(value = "{pessoaId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaDTO updatePessoa(@PathVariable Long pessoaId, @RequestBody PessoaDTO pessoaDTO){
        return pessoaService.updatePessoa(pessoaId,pessoaDTO);
    }

    @DeleteMapping(value = "{pessoaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePessoa(@PathVariable Long pessoaId){
        pessoaService.deletePessoa(pessoaId);
    }
}
