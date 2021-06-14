package com.magic.statecensus;

public class StateCensusException extends Exception {
    public enum ExceptionType{
        Wrong_File;
    }
    public ExceptionType type;

    public StateCensusException(ExceptionType type, String message)
    {
        super(message);
        this.type = type;
    }
}
