package com.magic.statecensus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {

    @Test
    public void givenPath_WhenCorrectShouldReturnNumOfEntriesAs29() throws IOException {
        String path = "C:\\Users\\rajni\\Desktop\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int numOfEntries = stateCensusAnalyser.loadStateCensusData(path);
        Assertions.assertEquals(29, numOfEntries);
    }
}
