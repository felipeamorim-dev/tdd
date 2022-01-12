package com.example.tdd.exceptions;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException(String mensagem){
        super(mensagem);
    }
}
