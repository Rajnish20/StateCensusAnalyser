package com.magic.statecensus;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCodes {
    @CsvBindByName(column = "SrNo", required = true)
    public int srNo;

    @CsvBindByName(column = "StateName", required = true)
    public String stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "CSVStateCodes{" +
                "srNo=" + srNo +
                ", stateName='" + stateName + '\'' +
                ", tin=" + tin +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
