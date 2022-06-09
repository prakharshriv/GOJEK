package com.gojek.financial.Services;

import com.gojek.financial.Exceptions.WrongFormatException;

public class FinancialDataProcessingService {


    public static double getAmountFromStringInput(String input) throws WrongFormatException, NumberFormatException {
        input = input.trim();
        if (input.indexOf(' ') == -1) {
            String amountPart = input.substring(input.length() - 1);
            if (!amountPart.equals("D") && !amountPart.equals("C"))
                throw new WrongFormatException();
            else
                return amountPart.equals("D")?getIndividualPartAsAmount(input, amountPart):getIndividualPartAsAmount(input, amountPart)/(double)100;
        } else {
            String splitForAmount[] = input.split(" ");
            if (splitForAmount.length > 2) throw new WrongFormatException();
            String result = "";
            for (String part : splitForAmount) {
                part = part.trim();
                String amountPart = part.substring(part.length() - 1);
                if (!amountPart.equals("D") && !amountPart.equals("C"))
                    throw new WrongFormatException();
                else
                    result += (int)(getIndividualPartAsAmount(part, amountPart))+ ".";
            }
            return Double.parseDouble(result.substring(0,result.length()-1));

        }
    }


    private static int getIndividualPartAsAmount(String input, String amountPart) throws NumberFormatException,WrongFormatException{
        int sign = 1;
        int number = 0;

        if (input.charAt(0) == '-') {
            sign = -1;
            number = Integer.parseInt(input.substring(1, input.length() - 1));
        } else
            number = Integer.parseInt(input.substring(0, input.length() - 1));

        if((amountPart.equals("C")&&(sign==-1||number>99)))
            throw new WrongFormatException();


        return  sign *  number;
    }

    public static void main(String[] args) throws WrongFormatException {
        System.out.println(getAmountFromStringInput("50D 44C"));
        System.out.println(getAmountFromStringInput("00D 44C"));
        System.out.println(getAmountFromStringInput("5D 4C"));
        System.out.println(getAmountFromStringInput("0D 0C"));
        System.out.println(getAmountFromStringInput("50D"));
        System.out.println(getAmountFromStringInput("44C"));
        System.out.println(getAmountFromStringInput("0C"));
        System.out.println(getAmountFromStringInput("0D"));
//        System.out.println(getAmountFromStringInput("-50C"));
        System.out.println(getAmountFromStringInput("-4D"));
        System.out.println(getAmountFromStringInput("-2D 4C"));// doubt
//        System.out.println(getAmountFromStringInput("2D -4C"));// doubt
//        System.out.println(getAmountFromStringInput("-2D -4C"));// doubt
    }
}


