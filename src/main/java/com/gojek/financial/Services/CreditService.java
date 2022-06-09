package com.gojek.financial.Services;

import com.gojek.financial.Interface.Service.CreditServiceInterface;
import com.gojek.financial.Repository.UserData;

public class CreditService extends UserData implements CreditServiceInterface {
    public CreditService() {

    }

    @Override
    public boolean creditAmountToUser(double amount) {
        UserData.userBalance += amount;
        ViewService.viewSuccessMessage();
        return true;
    }
}
