package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    private Map<Integer, String> units = new HashMap<Integer, String>();



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
    }

    private String intToRoman(int number) {
        if (number >= 4000 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();

        for(Map.Entry<Integer, String> key: units.entrySet()) {
            while (number >= key.getKey()) {
                number -= key.getKey();
                result.append(units.get(key));
            }
        }
        return result.toString();
    }






}
