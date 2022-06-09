package com.gojek.financial.test.Services;

import com.gojek.financial.Exceptions.WrongFormatException;
import com.gojek.financial.Services.FinancialDataProcessingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinancialDataProcessingServiceTest {

    @Test
    @DisplayName("Checking String processing for full Inputs")
    void getAmountFromStringInputTestForFullInput(){
        try {
            Assertions.assertEquals(100.1, FinancialDataProcessingService.getAmountFromStringInput("100D 10C"));
            assertEquals(1.1,FinancialDataProcessingService.getAmountFromStringInput("1D 10C"));
            assertEquals(12356678.99,FinancialDataProcessingService.getAmountFromStringInput("12356678D 99C"));
            assertEquals(0.1,FinancialDataProcessingService.getAmountFromStringInput("00D 10C"));
            assertEquals(10.00F,FinancialDataProcessingService.getAmountFromStringInput("10D 00C"));
            assertEquals(0.0,FinancialDataProcessingService.getAmountFromStringInput("00D 0C"));

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
    @Test
    @DisplayName("Checking String processing for half Inputs")
    void getAmountFromStringInputTestForHalfInput(){
        try {
            assertEquals(100.0,FinancialDataProcessingService.getAmountFromStringInput("100D"));
            assertEquals(1.0,FinancialDataProcessingService.getAmountFromStringInput("1D"));
            assertEquals(0.10,FinancialDataProcessingService.getAmountFromStringInput("10C"));
            assertEquals(0.0,FinancialDataProcessingService.getAmountFromStringInput("0D"));
            assertEquals(0.01,FinancialDataProcessingService.getAmountFromStringInput("1C"));

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    @DisplayName("Checking String processing for wrong Inputs")
    void getAmountFromStringInputTestForWrongInput(){
        try {
            assertThrows(WrongFormatException.class,()->FinancialDataProcessingService.getAmountFromStringInput("20D -22C"));
            assertThrows(WrongFormatException.class,()->FinancialDataProcessingService.getAmountFromStringInput("20D -202C"));
            assertThrows(WrongFormatException.class,()->FinancialDataProcessingService.getAmountFromStringInput("20D 222C"));
            assertThrows(WrongFormatException.class,()->FinancialDataProcessingService.getAmountFromStringInput("0D -22C"));

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}