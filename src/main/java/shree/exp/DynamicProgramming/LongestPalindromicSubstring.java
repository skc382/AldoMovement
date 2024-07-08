package shree.exp.DynamicProgramming;

import com.sun.org.apache.xpath.internal.operations.Bool;
import shree.exp.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        Map<String, Boolean> memo = new HashMap<>();
//        findLongestPalindrome("bobmamam", "", memo);
//        System.out.println("Longest palindrome is: ");
//        System.out.println(memo.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey)
//                .max(Comparator.comparingInt(String::length)));
//        System.out.println("\n");
//        memo.entrySet().forEach(e -> {
//            System.out.println(String.format("Key=[%s] IsPalindrome=%s", e.getKey(), String.valueOf(e.getValue())));
//        });

        /*
         *  With DP
         */
        findLongestPalindromeWithDP("bobmamam");

    }

    private static void findLongestPalindromeWithDP(String input) {
        int[][] matrix = new int[input.length()][input.length()];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0 ; j--) {
                if(input.charAt(i) == input.charAt(j)){
                    matrix[i][j] = 1;
                }
            }
        }

        Utils.printMatrixWithHeadings(input.toCharArray(), input.toCharArray(), matrix);
    }

    private static void findLongestPalindrome(String input, String slate, Map<String, Boolean> memo) {
//        if (memo.containsKey(slate)) {
//            return;
//        }

        System.out.printf("[%s]%n", slate);
        if (input.isEmpty()) {
            return;
        }

        String firstChar = String.valueOf(input.charAt(0));
        memo.put(slate + firstChar, isPalindrome(slate + firstChar));

        findLongestPalindrome(input.substring(1), slate + firstChar, memo);
        memo.put(firstChar, true);
        findLongestPalindrome(input.substring(1), firstChar, memo);
    }

    private static boolean isPalindrome(String input) {

        for (int i = 0, j = input.length() - 1; i <= j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
