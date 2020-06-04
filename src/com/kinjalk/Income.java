package com.kinjalk;

import java.util.Scanner;

public class Income {
    Scanner sc = new Scanner(System.in);

    public double getSingleIncome() {
        System.out.println("Enter your income:");
        return sc.nextDouble();
    }

    public double getJointIncome() {
        System.out.println("Enter first income:");
        double firstIncome = sc.nextDouble();
        System.out.println("Enter second income:");
        double secondIncome = sc.nextDouble();
        return firstIncome + secondIncome;
    }
}
