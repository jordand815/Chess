package com.example.chess;

public class moveNotPossibleException extends IllegalArgumentException {

    public moveNotPossibleException(String message)
    {
        super(message);
    }
}