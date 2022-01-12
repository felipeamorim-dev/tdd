package com.example.tdd.service;

import com.example.tdd.entities.Pessoa;

import java.util.Optional;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa);

    Pessoa getById(Long id);
}
