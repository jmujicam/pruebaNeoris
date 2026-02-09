package com.neoris.cliente.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException (String mensaje){
        super(mensaje);
    }

    public BadRequestException (String mensaje,Throwable motivo){
        super(mensaje,motivo);
    }

    public BadRequestException (Throwable motivo){
        super(motivo);
    }
}
