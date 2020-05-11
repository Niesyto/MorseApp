package com.example.niesyto.morseapp;

/**
 *
 * @author Niesyto
 * @version 1.0
 */
public class MorseCodeException extends Exception{
    /**
     * Non-parameter constructor
     */
    public MorseCodeException() {
    }

    /**
     * Constructor
     *
     * @param message display message
     */
    public MorseCodeException(String message) {
        super(message);
    }
}