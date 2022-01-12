package com.example.tdd.service.impl;

import com.example.tdd.entities.Pessoa;
import com.example.tdd.exceptions.PessoaNotFoundException;
import com.example.tdd.repositories.PessoaRepository;
import com.example.tdd.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

    public final PessoaRepository pessoaRepository;

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa getById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada"));
    }
}
