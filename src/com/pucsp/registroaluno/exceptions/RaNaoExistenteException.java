package com.pucsp.registroaluno.exceptions;

public class RaNaoExistenteException extends Exception{

    public RaNaoExistenteException(){
        super("Este RA não está no cadastro");
    }

    public RaNaoExistenteException(String msg){
        super(msg);
    }


}
