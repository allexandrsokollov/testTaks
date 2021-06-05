package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String expression = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your expression");
        expression = in.nextLine();

        try {
            Calculator calc = new Calculator(expression);
        } catch (DataException e) {
            e.printStackTrace();
        }

        in.close();

    }


}
