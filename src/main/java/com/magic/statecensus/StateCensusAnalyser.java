package com.magic.statecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public static int numOfEntries = 0;

    public int loadStateCensusData(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).
                withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<CSVStateCensus> csvStateCensusIterator = csvToBean.iterator();
        while (csvStateCensusIterator.hasNext()) {
            numOfEntries++;
            csvStateCensusIterator.next();
        }
        return numOfEntries;
    }

    public static void main(String[] args) throws IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        System.out.println(stateCensusAnalyser.loadStateCensusData("C:\\Users\\rajni\\Desktop\\StateCensusData.csv"));

    }
}
