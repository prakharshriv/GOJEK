package com.gojek.financial.Exceptions;

public class WrongFormatException extends Exception {
    public WrongFormatException() {
        super("Worng Input Format Type. Money input and output should be in the format \"xD yC\" where x are dollars and y are cents");
    }
}
