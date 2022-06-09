package com.gojek.financial.Services;

import com.gojek.financial.Repository.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitServiceTest extends UserData{
    DebitService debitService=new DebitService();
    @BeforeEach
    void setUserDataToDefault(){
        UserData.userBalance=0;
    }

    @Test
    @DisplayName("checking debit system for base case")
    void checkDebitForBaseCase(){
        debitService.debitAmountFromUser(120.22);
        assertEquals(-120.22,UserData.userBalance);
    }

    @Test
    @DisplayName("checking debit system for updated case")
    void checkDebitForUpdatedCase(){
        UserData.userBalance=100;
        debitService.debitAmountFromUser(120);
        assertEquals(-20.00,UserData.userBalance);
        UserData.userBalance=-100;
        debitService.debitAmountFromUser(20);
        assertEquals(-120,UserData.userBalance);
    }

}