package com.gojek.financial.Exceptions;

public class EmptyInputException extends Exception {
    public EmptyInputException() {
        super("Input Provided was Empty");
    }
}
