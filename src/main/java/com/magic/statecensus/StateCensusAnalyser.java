package com.magic.statecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public static int numOfEntries = 0;

    public int loadStateCensusData(String path) throws StateCensusException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).
                    withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCensus> csvStateCensusIterator = csvToBean.iterator();
            while (csvStateCensusIterator.hasNext()) {
                numOfEntries++;
                csvStateCensusIterator.next();
            }
        } catch (IOException e) {
            if (!(path.contains(".csv")))
                throw new StateCensusException(StateCensusException.ExceptionType.Wrong_Extension, "Wrong Extension");
            throw new StateCensusException(StateCensusException.ExceptionType.Wrong_File, "Wrong Path Given");
        }

        catch (RuntimeException e)
        {
            throw new StateCensusException(StateCensusException.ExceptionType.Wrong_Delimiter_Or_Wrong_Header,"Wrong Delimited File or Wrong Header File");
        }
        return numOfEntries;
    }
}
