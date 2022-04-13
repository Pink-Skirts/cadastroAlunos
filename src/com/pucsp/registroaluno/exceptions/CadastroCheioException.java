package com.pucsp.registroaluno.exceptions;

public class CadastroCheioException extends Exception{

    public CadastroCheioException(){
        super("Cadastro cheio");
    }

    public CadastroCheioException(String msg){
        super(msg);
    }
}
