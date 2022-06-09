package com.gojek.financial.Services;

public class ViewService {
    private static String OPTIONS = "Select an option:\n" +
            "\t1. Credit\n" +
            "\t2. Debit\n" +
            "\t3. Check Balance\n" +
            "\t4. Exit";
    private static String ENTER_AMOUNT = "Enter Amount:\n";
    private static String END_MESSAGE = "Thank You!";
    private static String SUCCESS_MESSAGE = "Success!";
    private static String FAIL_MESSAGE = "Operation Failed";

    public static void viewOptions() {
        System.out.println(OPTIONS);
    }

    public static void viewAmountEnterMessage() {
        System.out.println(ENTER_AMOUNT);
    }

    public static void viewBalance(double amount) {
        String data = "" + amount;
        String dataSplit[] = data.split("\\.");
        System.out.println(String.format("%sD %sC", dataSplit[0], dataSplit[1]));
    }

    public static void viewEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void viewSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void viewFailureMessage() {
        System.out.println(FAIL_MESSAGE);
    }

}
