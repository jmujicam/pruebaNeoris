package com.neoris.cliente.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensaje)
    {
        super(mensaje);
    }

    public NotFoundException(String mensaje,Throwable motivo)
    {
        super(mensaje,motivo);
    }

    public NotFoundException(Throwable motivo)
    {
        super(motivo);
    }
}
