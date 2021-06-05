package com.company;


import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumbers {
    private final int MAX_ROMAN_VALUE = 3999;
    private Map<Integer, String> units = new LinkedHashMap<Integer, String>();
    private final char[] romanSigns = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private String[] roman = new String[MAX_ROMAN_VALUE + 1];



    public RomanNumbers() {
        units.put(1000, "M");
        units.put(900, "CM");
        units.put(500, "D");
        units.put(400, "CD");
        units.put(100, "C");
        units.put(90, "XC");
        units.put(50, "L");
        units.put(40, "XL");
        units.put(10, "X");
        units.put(9, "IX");
        units.put(5, "V");
        units.put(4, "IV");
        units.put(1, "I");

        roman[0] = "you shouldn't see it";

        for(int i = 1; i <= MAX_ROMAN_VALUE; i++) {
            roman[i] = intToRoman(i);
        }

    }


    public int whatNumberIsIt(String romanNumber) {
        int toReturn = -1;
        for(int i = 1; i <= MAX_ROMAN_VALUE; i++) {
            if(roman[i].equals(romanNumber)) {
                toReturn =  i;
                break;
            }
        }

        return toReturn;
    }


    public boolean isRoman(String str) {
        boolean ret = true;

        char[] strArr = str.toCharArray();

        for(int i = 0; i < str.length(); i++) {
            if(!isRomanSign(strArr[i])) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    private boolean isRomanSign(char ch) {
        boolean ret = false;
        for(int i = 0; i < romanSigns.length; i++) {
            if(ch == romanSigns[i]) {
                ret = true;
                break;
            }
        }

        return ret;
    }


    public String intToRoman(int number) {
        if (number > MAX_ROMAN_VALUE || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();


        for(Integer key: units.keySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

}
