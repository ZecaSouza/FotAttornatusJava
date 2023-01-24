package com.testeAttornatus.TesteWithJava.module.endereco.controller;

import com.testeAttornatus.TesteWithJava.databases.models.dtos.EnderecoDTO;
import com.testeAttornatus.TesteWithJava.databases.models.dtos.PessoaDTO;
import com.testeAttornatus.TesteWithJava.module.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "{pessoaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnderecoDTO> getAllEnderecoByPessoa(@PathVariable Long pessoaId) {
        return enderecoService.getAllEnderecoByPessoa(pessoaId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO createEnderecoForPessoa(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.createEnderecoForPessoa(enderecoDTO);
    }

    @PutMapping(value ="{endercoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO updateEndereco(@PathVariable Long endercoId, @RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.updateEndereco(endercoId, enderecoDTO);
    }

    @DeleteMapping(value = "{pessoaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEndereco(@PathVariable Long pessoaId){
        enderecoService.deleteEndereco(pessoaId);
    }

}
