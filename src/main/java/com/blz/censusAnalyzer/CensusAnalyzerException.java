package com.blz.censusAnalyzer;

public class CensusAnalyzerException extends Exception {

    private String message;
    private ExceptionType type;

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        INCORRECT_CSV_FILE_PATH,
        DELIMITER_IS_INCORRECT
    }

    public CensusAnalyzerException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return "CensusAnalyzerException{" +
                "message='" + message + '\'' +
                '}';
    }
}
