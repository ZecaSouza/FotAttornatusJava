package com.testeAttornatus.TesteWithJava.databases.repositories;

import com.testeAttornatus.TesteWithJava.databases.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositry extends JpaRepository<Pessoa, Long> {
}