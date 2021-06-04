package com.company;

public class Calculator {

    private int a;
    private int b;
    private String operation;

    Calculator(String expression) {

        StringBuilder nothing = new StringBuilder("");
        StringBuilder[] signs = new StringBuilder[3];
        signs[0].append(nothing);
        signs[1].append(nothing);
        signs[3].append(nothing);

        char[] opr = expression.toCharArray();

        for(int i = 0, j = 0; i < expression.length(); i++) {

            if(opr[i] == ' ' && signs[j].equals("")) {
                continue;
            } else if(opr[i] == ' ' && !signs[j].equals("")) {
                j++;
            } else {
                signs[j].append(opr[i]);
            }
        }
    };



}
