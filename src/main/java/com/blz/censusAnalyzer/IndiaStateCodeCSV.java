package com.blz.censusAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCodeCSV {

    @CsvBindByName(column = "SrNo")
    private int srNo;

    @CsvBindByName(column = "State Name")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "StateCode")
    private String stateCode;
}
