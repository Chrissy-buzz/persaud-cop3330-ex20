package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Christina Persaud
 */

public class App {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static double calcTaxWI (double amount)
    {
        return amount*0.05;
    }
    public static double calcTaxWIE (double amount)
    {
        return amount*0.05004;
    }
    public static double calcTaxWID (double amount)
    {
        return amount*0.05005;
    }
    public static double calcTaxI (double amount)
    {
        return amount*0.08;
    }
    public static double total (double amount, double tax)
    {
        return amount+tax;
    }
    public static void main(String[] args) {

        double tax= 0; //initialize tax to 0

        Scanner scan1 = new Scanner(System.in);
        System.out.print("What is the order amount? ");
        double amount = scan1.nextDouble();

        Scanner input = new Scanner(System.in);
        System.out.print("What state do you live in? ");
        String ans = input.nextLine();
        //Illinois
        if (ans.equals("Illinois")){
            tax= calcTaxI(amount);
            System.out.print("The tax is: $" + tax +".\n");
        }


        //WI resident
        if (ans.equals("Wisconsin")) {
            Scanner input2 = new Scanner(System.in);
            System.out.print("What county do you live in? ");
            String count = input.nextLine();

            if (count.equals("Eau Claire")) {
                tax = calcTaxWIE(amount); //add in tax only when WI
                System.out.print("The tax is: $" + tax + ".\n");
            } else if (count.equals("Dunn")) {
                tax = calcTaxWID(amount); //add in tax only when WI
                System.out.print("The tax is: $" + tax + ".\n");
            } else {
                tax = calcTaxWI(amount); //add in tax only when WI
                System.out.print("The tax is: $" + tax + ".\n");
            }
        }
        else{
            tax=0;
        }
        double total= total(amount, tax);
        System.out.print("The total is: $" + df2.format(total)+".\n");
    }
}