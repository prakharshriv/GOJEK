package com.gojek.financial.Interface.Controller;

public interface BankManagerInterface {
    public void credit(double creditAmount);

    public void debit(double debitAmount);

    public void checkBalance();

    public void exit();

}
