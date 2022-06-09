package com.gojek.financial.Services;

import com.gojek.financial.Interface.Service.DebitServiceInterface;
import com.gojek.financial.Repository.UserData;

public class DebitService extends UserData implements DebitServiceInterface {
    public DebitService() {

    }

    @Override
    public boolean debitAmountFromUser(double amount) {
        UserData.userBalance -= amount;
        ViewService.viewSuccessMessage();
        return true;
    }
}
