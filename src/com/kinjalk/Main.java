package com.kinjalk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to pay the tax!\nSelect (1) Single (2) Joint");
        int numberOfPayers = sc.nextInt();
        double taxToPay = 0;
        TaxCalculation taxCalculation = new TaxCalculation();
        if(numberOfPayers == 1) {
            taxCalculation.calculateSingleTax(taxToPay);
        } else if (numberOfPayers == 2) {
            taxCalculation.calculateJointTax(taxToPay);
        } else {
            System.out.println("Please select a valid option!");
        }
    }
}
