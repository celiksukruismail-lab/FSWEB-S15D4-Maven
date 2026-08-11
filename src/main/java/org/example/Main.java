package org.example;

import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static boolean checkForPalindrome(String text) {
        if (text == null) {
            return false;
        }

        String normalized = text
                .replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]", "")
                .toLowerCase(Locale.ROOT);
        Stack<Character> characters = new Stack<>();

        for (char character : normalized.toCharArray()) {
            characters.push(character);
        }

        for (char character : normalized.toCharArray()) {
            if (character != characters.pop()) {
                return false;
            }
        }
        return true;
    }


    public static String convertDecimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }
        if (decimalNumber < 0) {
            throw new IllegalArgumentException("Sayı negatif olamaz.");
        }

        Stack<Integer> remainders = new Stack<>();
        while (decimalNumber > 0) {
            remainders.push(decimalNumber % 2);
            decimalNumber /= 2;
        }

        StringBuilder binaryNumber = new StringBuilder();
        while (!remainders.isEmpty()) {
            binaryNumber.append(remainders.pop());
        }
        return binaryNumber.toString();
    }
}
