package com.example.tdd.service;

import com.example.tdd.entities.Pessoa;
import com.example.tdd.repositories.PessoaRepository;
import com.example.tdd.service.impl.PessoaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PessoaServiceTest {

    private static final Long ID = 1L;
    private static final String NOME = "FELIPE AMORIM";
    private static final String CPF = "12345678912";

    private Pessoa pessoa;
    private PessoaService service;

    @Mock
    private PessoaRepository repo;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.service = new PessoaServiceImpl(repo);
        initPessoa();
    }

    @Test
    public void deveRetornarUmaInstanciaDePessoaAposPersistencia() {
        when(repo.save(any())).thenReturn(pessoa);

        Pessoa response = service.salvar(pessoa);

        assertNotNull(response);
        assertEquals(Pessoa.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(CPF, response.getCpf());
    }

    private void initPessoa(){
        pessoa = new Pessoa(NOME, CPF);
        pessoa.setId(ID);
    }
}
