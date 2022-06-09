package com.gojek.financial.Services;

import com.gojek.financial.Exceptions.EmptyInputException;
import com.gojek.financial.Exceptions.WrongFormatException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputService {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static int takeUserInputForOptions() {
        ViewService.viewOptions();
        try {
            String data = input.readLine();

            if (data.trim().length() == 0)
                throw new EmptyInputException();

            return Integer.parseInt(data);
        } catch (EmptyInputException emptyInputException) {
            System.out.println("No Input Found");

        } catch (NumberFormatException numberFormatException) {
            System.out.println("Only Numerical Options allowed");
        } catch (Exception e) {
            System.out.println("Some Error Occurred");
        }
        return 0;
    }

    public static double takeUserInputForAmount() {
        ViewService.viewAmountEnterMessage();
        try {
            String data = input.readLine();

            if (data.trim().length() == 0)
                throw new EmptyInputException();

            return FinancialDataProcessingService.getAmountFromStringInput(data);
        } catch (EmptyInputException emptyInputException) {
            System.out.println("No Input Found");
        } catch (WrongFormatException wrongFormatException) {
            System.out.println("Wrong input format. Please try again");
        } catch (Exception e) {
            System.out.println("Some Error Occurred");
        }
        return 0;
    }

}
