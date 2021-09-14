package com.example.diplom.exceptions;

import lombok.NoArgsConstructor;


public class PrivateException extends RuntimeException {

    Long message;

    public PrivateException(String message){
        super(message);
    }
}
