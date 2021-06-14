package com.magic.statecensus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StateCensusAnalyserTest {

    @Test
    public void givenPath_WhenCorrectShouldReturnNumOfEntriesAs29() throws StateCensusException {
        String path = "C:\\Users\\rajni\\Desktop\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int numOfEntries = stateCensusAnalyser.loadStateCensusData(path);
        Assertions.assertEquals(29, numOfEntries);
    }

    @Test
    public void givenPath_WhenWrong_ShouldReturn_WrongFileExceptionType() {
        String path = "c:\\Users\\rajni\\Documents\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int entries = stateCensusAnalyser.loadStateCensusData(path);
        } catch (StateCensusException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusException.ExceptionType.Wrong_File, e.type);
        }
    }

    @Test
    public void givenPath_ButWithWrongFileExtension_ShouldReturn_WrongExtensionExceptionType() {
        String path = "c:\\Users\\rajni\\Desktop\\StateCensusData.txt";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int entries = stateCensusAnalyser.loadStateCensusData(path);
        } catch (StateCensusException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(StateCensusException.ExceptionType.Wrong_Extension, e.type);
        }
    }
}
