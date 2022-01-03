package com.blz.censusAnalyzer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
            CsvToBeanBuilder<CensusStateCSV> csvToBeanBuilder = new CsvToBeanBuilder<CensusStateCSV>(reader);
            csvToBeanBuilder.withType(CensusStateCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CensusStateCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<CensusStateCSV> censusCsvIterator = csvToBean.iterator();
            Iterable<CensusStateCSV> censusIterable = () -> censusCsvIterator;
            int numOfEntries = (int) StreamSupport.stream(censusIterable.spliterator(),true).count();
//            int numOfEntries = 0;
//            while(censusCsvIterator.hasNext())
//            {
//                numOfEntries++;
//                censusCsvIterator.next();
//            }
            return numOfEntries;


        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int loadIndiaStateCode(String csvPath) throws CensusAnalyzerException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvPath)))
        {
            CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaStateCodeCSV>(reader);
            csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaStateCodeCSV> censusCsvIterator = csvToBean.iterator();
            Iterable<IndiaStateCodeCSV> censusIterable = () -> censusCsvIterator;
            int numOfEntries = (int) StreamSupport.stream(censusIterable.spliterator(),true).count();

            return numOfEntries;
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}
