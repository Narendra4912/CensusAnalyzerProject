package com.blz.censusanalyzertesting;

import com.blz.censusAnalyzer.CensusAnalyzer;
import com.blz.censusAnalyzer.CensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {

    private static final String INDIA_CENSUS_CSV_PATH = "D:\\BridgeLabz Assignments\\CensusAnalyzerProject\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CODE_CSV_PATH = "D:\\BridgeLabz Assignments\\CensusAnalyzerProject\\src\\main\\resources\\IndiaStateCode.csv";

    CensusAnalyzer censusAnalyzer = new CensusAnalyzer();

    @Test
    public void givenIndiaCensusCsvFile_WhenLoad_ShouldReturnCorrectRecords() {

        try {
            int numOfRecords = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29,numOfRecords);
        }
        catch (CensusAnalyzerException e)
        {

        }
    }

    @Test
    public void givenIndiaStateCodeCsvFile_WhenLoad_ShouldReturnCorrectRecords() {

        try {
            int numOfRecords = censusAnalyzer.loadIndiaStateCode(INDIA_STATE_CODE_CSV_PATH);
            Assert.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyzerException e)
        {

        }
    }
}
