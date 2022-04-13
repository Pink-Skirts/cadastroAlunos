package com.pucsp.registroaluno.exceptions;

public class FormatoRaIncorretoException extends Exception{

    public FormatoRaIncorretoException(){
        super("Formato incorreto!");
    }

    public FormatoRaIncorretoException(String msg){
        super(msg);
    }
}
