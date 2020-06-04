package com.kinjalk;

public class TaxCalculation {
    public enum TaxRates {
        TEN_PERCENT(0.1), TWELVE_PERCENT(0.12), TWENTY_TWO_PERCENT(0.22),
        TWENTY_FOUR_PERCENT(0.24), THIRTY_TWO_PERCENT(0.32), THIRTY_FIVE_PERCENT(0.35),
        THIRTY_SEVEN_PERCENT(0.37);
        private double rate;

        TaxRates(double rate) {
            this.rate = rate;
        }
    }

    public enum SingleTaxValues {
        FIRST(0), SECOND(9876), THIRD(40126), FOURTH(85526),
        FIFTH(163301), SIXTH(207351), SEVENTH(518401);

        private double income;

        SingleTaxValues(double income) {
            this.income = income;
        }
    }

    public enum JointTaxValues {
        FIRST(0), SECOND(19751), THIRD(80251), FOURTH(171051),
        FIFTH(326601), SIXTH(414701), SEVENTH(622051);

        private double income;

        JointTaxValues(double income) {
            this.income = income;
        }
    }

    public void calculateSingleTax(double taxToPay) {
        Income income = new Income();
        double annualIncome = income.getSingleIncome();
        if (annualIncome < 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }
        int singleTaxLength = SingleTaxValues.values().length;
        for(int i = 0; i < singleTaxLength; i++) {
            boolean isLastElement;
            if (i+1 == SingleTaxValues.values().length) isLastElement = true;
            else isLastElement = annualIncome < SingleTaxValues.values()[i+1].income;
            if (annualIncome >= SingleTaxValues.values()[i].income && isLastElement) {
                taxToPay = annualIncome * TaxRates.values()[i].rate;
                break;
            }
        }
        System.out.println("Tax to pay is $"+taxToPay);
    }

    public void calculateJointTax(double taxToPay) {
        Income income = new Income();
        double combinedIncome = income.getJointIncome();
        if (combinedIncome < 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }
        for(int i = 0; i < JointTaxValues.values().length; i++) {
            boolean isLastElement;
            if (i+1 == JointTaxValues.values().length) isLastElement = true;
            else isLastElement = combinedIncome < JointTaxValues.values()[i+1].income;
            if (combinedIncome >= JointTaxValues.values()[i].income && isLastElement) {
                taxToPay = combinedIncome * TaxRates.values()[i].rate;
                break;
            }
        }
        System.out.println("Combined tax to pay is $"+taxToPay);
    }
}