package com.company;

public class Calculator {

    private int a;
    private int b;
    private int result;
    String[] signs = new String[3];

    Calculator(String expression) throws DataException {
        RomanNumbers roman = new RomanNumbers();
        boolean isRoman = false;
        signs[0] = "";
        signs[1] = "";
        signs[2] = "";


        char[] opr = expression.toCharArray();

        for(int i = 0, j = 0; i < expression.length(); i++) {

            if(opr[i] == ' ' && signs[j].equals("")) {
                continue;
            } else if(opr[i] == ' ' && !signs[j].equals(" ")) {
                j++;
            } else {
                signs[j] += opr[i];
            }
        }

        if(roman.isRoman(signs[0]) && roman.isRoman(signs[2])) {
            a = roman.whatNumberIsIt(signs[0]);
            b = roman.whatNumberIsIt(signs[2]);
            isRoman = true;

            if(a > 10 || a < 1 || b > 10 || b < 1) {
                throw new DataException("NumbersShouldBeMoreThenOneAndLessThenTen");
            } else if(a == -1 || b == -1) {
                throw new DataException("WrongSpellingOfNumber");
            }

            switch (signs[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new DataException("UnexpectedOperation");
            }
        } else if (!roman.isRoman(signs[0]) && !roman.isRoman(signs[2])) {
            a = Integer.parseInt(signs[0]);
            b = Integer.parseInt(signs[2]);

            if(a > 10 || a < 1 || b > 10 || b < 1) {
                throw new DataException("NumbersShouldBeMoreThenOneAndLessThenTen");
            }


            switch (signs[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new DataException("UnexpectedOperation");
            }

        } else {
            throw new DataException("WeCanNotUseRomanAndArabicNumbersSimultaneously");
        }

        if(isRoman) {
            System.out.println(roman.intToRoman(result));
        } else {
            System.out.println(result);
        }

    }






}
