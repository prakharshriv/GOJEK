package com.gojek.financial.test.Services;

import com.gojek.financial.Repository.UserData;
import com.gojek.financial.Services.CreditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditServiceTest extends UserData {
    CreditService creditService=new CreditService();
    @BeforeEach
    void setUserDataToDefault(){
        UserData.userBalance=0;
    }

    @Test
    @DisplayName("checking if credit is successful on base case")
    void creditAmountToUserTest() {
        creditService.creditAmountToUser(10);
        creditService.creditAmountToUser(110.22);
        assertEquals(120.22,UserData.userBalance);
    }

    @Test
    @DisplayName("checking if credit is successful on updated case")
    void creditAmountToUserForUpdatedCase() {
        UserData.userBalance=-22;
        creditService.creditAmountToUser(110.22);
        assertEquals(88.22,UserData.userBalance);
    }

}