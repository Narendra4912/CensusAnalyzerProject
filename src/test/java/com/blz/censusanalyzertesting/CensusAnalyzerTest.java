package com.blz.censusanalyzertesting;

import com.blz.censusAnalyzer.CensusAnalyzer;
import com.blz.censusAnalyzer.CensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class CensusAnalyzerTest {

    private static final String INDIA_CENSUS_CSV_PATH = "D:\\BridgeLabz Assignments\\CensusAnalyzerProject\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_INCORRECT_CSV_PATH = "D:\\BridgeLabz Assignments\\CensusAnalyzerProject\\src\\main\\resources\\IndiaStateCensusData.pdf";


    private static final String INDIA_STATE_CODE_CSV_PATH = "D:\\BridgeLabz Assignments\\CensusAnalyzerProject\\src\\main\\resources\\IndiaStateCode.csv";
    private static final String INDIA_STATE_CODE_INCORRECT_CSV_PATH = "D:\\BridgeLabz Assignments\\CensusAnalyzerProject\\src\\main\\resources\\IndiaStateCode.pdf";

    CensusAnalyzer censusAnalyzer = new CensusAnalyzer();

    // UC1 - TC 1.1 completed
    @Test
    public void givenIndiaCensusCsvFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyzerException {

        try {
            int numOfRecords = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29,numOfRecords);
        }
        catch (CensusAnalyzerException e)
        {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    // UC1 - TC 1.2 completed
    @Test
    public void givenIndiaCensusCsvFile_WhenLoad_ShouldReturnException() throws CensusAnalyzerException {

        try {
            int numOfRecords = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_INCORRECT_CSV_PATH);
            Assert.assertEquals(29,numOfRecords);
        }
        catch (CensusAnalyzerException e)
        {
            System.out.println(CensusAnalyzerException.ExceptionType.INCORRECT_CSV_FILE_PATH);
        }
    }

    // UC1 - TC 1.4 completed
    @Test
    public void givenIndiaCensusCsvFileUsingDelimiter_WhenLoad_ShouldReturnAllRecords() throws CensusAnalyzerException, FileNotFoundException {

        censusAnalyzer.loadIndiaCensusDataUsingDelimiter(INDIA_CENSUS_CSV_PATH);
//        try {
//            int numOfRecords = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_INCORRECT_CSV_PATH);
//            Assert.assertEquals(29,numOfRecords);
//        }
//        catch (CensusAnalyzerException e)
//        {
//            System.out.println(CensusAnalyzerException.ExceptionType.INCORRECT_CSV_FILE_PATH);
//        }
    }



    // UC2 - TC 2.1 completed
    @Test
    public void givenIndiaStateCodeCsvFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyzerException {

        try {
            int numOfRecords = censusAnalyzer.loadIndiaStateCode(INDIA_STATE_CODE_CSV_PATH);
            Assert.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyzerException e)
        {

        }
    }

    // UC2 - TC 2.2 completed
    @Test
    public void givenIndiaStateCodeCsvFile_WhenLoad_ShouldReturnException() throws CensusAnalyzerException {

        try {
            int numOfRecords = censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CODE_INCORRECT_CSV_PATH);
            Assert.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyzerException e)
        {
            System.out.println(CensusAnalyzerException.ExceptionType.INCORRECT_CSV_FILE_PATH);
        }
    }
}
