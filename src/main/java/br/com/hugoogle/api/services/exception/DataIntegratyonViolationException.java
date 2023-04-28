package br.com.hugoogle.api.services.exception;

public class DataIntegratyonViolationException extends  RuntimeException{

    private static  final long serialVersionUID = 1L;
    public DataIntegratyonViolationException(String message, Throwable cause){
        super(message, cause);
    }

    public DataIntegratyonViolationException(String message){
        super(message);

    }



}
