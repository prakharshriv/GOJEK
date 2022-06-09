package com.gojek.financial.test.controller;

import com.gojek.financial.Controller.BankingController;
import com.gojek.financial.Repository.UserData;
import com.gojek.financial.Services.CreditService;
import com.gojek.financial.Services.DebitService;
import com.gojek.financial.Services.ViewService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankingControllerTest extends UserData {
    CreditService creditService=new CreditService();
    DebitService debitService=new DebitService();

    @BeforeEach
    void setUserDataToDefault(){
        UserData.userBalance=0;
    }

    @Test
    @DisplayName("testing credit system when user balance is 0")
    void testCreditForInitialCase() {
        creditService.creditAmountToUser(100.0);
        assertEquals(100.0,UserData.userBalance);
    }

    @Test
    @DisplayName("testing credit system when user balance is not 0 ")
    void testCreditForUpdatedCase(){
        UserData.userBalance=100.0;
        creditService.creditAmountToUser(200.0);
        assertEquals(300,UserData.userBalance);
        UserData.userBalance=-10;
        creditService.creditAmountToUser(100);
        assertEquals(90,UserData.userBalance);
    }

    @Test
    @DisplayName("testing debit system when user balance is 0 ")
    void testDebitForInitialCase() {
        BankingController stub=Mockito.mock(BankingController.class);
        debitService.debitAmountFromUser(100.23);
        assertEquals(-100.23,UserData.userBalance);
    }


    @Test
    @DisplayName("testing debit system when user balance is not 0 ")
    void testDebitForUpdatedCase() {
        UserData.userBalance=22.56;
        debitService.debitAmountFromUser(100.23);
        assertEquals(-77.67,UserData.userBalance);
    }


}