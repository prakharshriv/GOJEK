package com.gojek.financial.Controller;

import com.gojek.financial.Interface.Controller.BankManagerInterface;
import com.gojek.financial.Interface.Service.CreditServiceInterface;
import com.gojek.financial.Interface.Service.DebitServiceInterface;
import com.gojek.financial.Repository.UserData;
import com.gojek.financial.Services.CreditService;
import com.gojek.financial.Services.DebitService;
import com.gojek.financial.Services.InputService;
import com.gojek.financial.Services.ViewService;


public class BankingController extends UserData implements BankManagerInterface {
    private final CreditServiceInterface creditService;
    private final DebitServiceInterface debitService;

    public BankingController() {
        this.creditService = new CreditService();
        this.debitService = new DebitService();

    }

    public void init() {
        int options = 0;

        do {
            try {
                options = InputService.takeUserInputForOptions();
                switch (options) {
                    case 1:
                        credit(InputService.takeUserInputForAmount());
                        break;
                    case 2:
                        debit(InputService.takeUserInputForAmount());
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        exit();
                    default:
                        System.out.println("wrong input. try again");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("some unexpected error ocurred");
            }
        } while (true);
    }

    @Override
    public void credit(double creditAmount) {
        creditService.creditAmountToUser(creditAmount);
    }

    @Override
    public void debit(double debitAmount) {
        debitService.debitAmountFromUser(debitAmount);
    }

    @Override
    public void checkBalance() {
        ViewService.viewBalance(UserData.userBalance);
    }

    @Override
    public void exit() {
        ViewService.viewEndMessage();
        System.exit(0);
    }
}
