package com.pucsp.registroaluno.exceptions;

public class CampoIncorretoException extends Exception {

    public CampoIncorretoException(){
        super("Campo incorreto! Preencha novamente.");
    }

    public CampoIncorretoException(String msg) {
        super(msg);
    }
}
