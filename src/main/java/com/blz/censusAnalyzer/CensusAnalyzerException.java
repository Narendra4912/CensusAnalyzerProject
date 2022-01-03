package com.blz.censusAnalyzer;

public class CensusAnalyzerException extends Exception {

    private String message;
    private ExceptionType type;

    enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }

    public CensusAnalyzerException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

}
