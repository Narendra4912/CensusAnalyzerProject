package com.blz.censusAnalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyzer {

    public int loadIndiaCensusData(String csvPath) throws CensusAnalyzerException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvPath)))
        {
            Iterator<CensusStateCSV> censusCsvIterator = CsvBuilder.getIterator(reader, CensusStateCSV.class);
            return getRecordsCount(censusCsvIterator);
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int loadIndiaStateCode(String csvPath) throws CensusAnalyzerException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvPath)))
        {
            Iterator<IndiaStateCodeCSV> censusStateIterator = CsvBuilder.getIterator(reader, IndiaStateCodeCSV.class);
            return getRecordsCount(censusStateIterator);
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    private <E> int getRecordsCount(Iterator iterator)
    {
        Iterable<E> iterable = () -> iterator;
        int numOfEntries = (int) StreamSupport.stream(iterable.spliterator(),true).count();

        return numOfEntries;
    }
}
