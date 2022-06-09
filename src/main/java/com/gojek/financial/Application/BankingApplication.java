package com.gojek.financial.Application;

import com.gojek.financial.Controller.BankingController;

public class BankingApplication {
    public static void main(String[] args) {
        BankingController bankingController = new BankingController();
        bankingController.init();
    }
}
