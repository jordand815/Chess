package com.example.chess;

public class moveOutOfBoundsException extends IllegalArgumentException {

        public moveOutOfBoundsException(String message)
        {
            super(message);
        }
}
