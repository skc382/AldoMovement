package blah.just.practice;

import java.util.Arrays;

public class Palindrome {


    public static void main(String[] args) {
        String s = "sdffgh";

        Arrays.stream(s.split("\\|")).forEach(System.out::println);
//        System.out.println(checkIfPalindrome(s));
    }

    static boolean checkIfPalindrome(String input) {
        String s = input.replace("|", "");

        for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0 && i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

