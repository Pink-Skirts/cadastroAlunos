package com.pucsp.registroaluno.exceptions;

import com.pucsp.registroaluno.aluno.Cadastro;

public class CadastrosVaziosException extends Exception {
    public CadastrosVaziosException(){
        super("Cadastros vazios!");
    }

    public CadastrosVaziosException (String msg) {
        super(msg);
    }
}
