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
//            CsvToBeanBuilder<CensusStateCSV> csvToBeanBuilder = new CsvToBeanBuilder<CensusStateCSV>(reader);
//            csvToBeanBuilder.withType(CensusStateCSV.class);
//            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//            CsvToBean<CensusStateCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<CensusStateCSV> censusCsvIterator = getIterator(reader, CensusStateCSV.class);
            Iterable<CensusStateCSV> censusIterable = () -> censusCsvIterator;
            int numOfEntries = (int) StreamSupport.stream(censusIterable.spliterator(),true).count();

            return numOfEntries;
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int loadIndiaStateCode(String csvPath) throws CensusAnalyzerException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvPath)))
        {
            Iterator<IndiaStateCodeCSV> censusStateIterator = getIterator(reader, IndiaStateCodeCSV.class);
            Iterable<IndiaStateCodeCSV> censusIterable = () -> censusStateIterator;

            int numOfEntries = (int) StreamSupport.stream(censusIterable.spliterator(),true).count();

            return numOfEntries;
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public <E> Iterator<E> getIterator(Reader reader, Class className)
    {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(className);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();

        return csvToBean.iterator();
    }
}
