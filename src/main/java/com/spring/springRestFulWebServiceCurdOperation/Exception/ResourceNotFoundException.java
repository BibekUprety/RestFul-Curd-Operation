package com.spring.springRestFulWebServiceCurdOperation.Exception;

public class ResourceNotFoundException extends RuntimeException {
   private static final long serialversionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
