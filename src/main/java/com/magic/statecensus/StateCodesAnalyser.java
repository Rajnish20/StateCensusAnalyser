package com.magic.statecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCodesAnalyser {
    public static int numOfEntries = 0;

    public int loadStateCodeData(String path) throws StateCensusException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvToBean<CSVStateCodes> csvToBean = new CsvToBeanBuilder<CSVStateCodes>(reader).
                    withType(CSVStateCodes.class).withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCodes> csvStateCodesIterator = csvToBean.iterator();
            while (csvStateCodesIterator.hasNext()) {
                numOfEntries++;
                csvStateCodesIterator.next();
            }
        } catch (IOException e) {
            if (!(path.contains(".csv")))
                throw new StateCensusException(StateCensusException.ExceptionType.Wrong_Extension, "Wrong Extension");
            throw new StateCensusException(StateCensusException.ExceptionType.Wrong_File, "Wrong Path Given");
        } catch (RuntimeException e) {
            throw new StateCensusException(StateCensusException.ExceptionType.Wrong_Delimiter_Or_Wrong_Header, "Wrong Delimited File or Wrong Header File");
        }
        return numOfEntries;
    }
}
