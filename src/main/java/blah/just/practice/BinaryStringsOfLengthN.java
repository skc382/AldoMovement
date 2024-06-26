package blah.just.practice;

import shree.exp.Utils;

import java.util.ArrayList;

public class BinaryStringsOfLengthN {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();

//        doThis(, "", result);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void doThis(int n, String currentCombination, ArrayList<String> allCombinations) {
        if (currentCombination.length() == n) {
            allCombinations.add(currentCombination);
        } else {
            doThis(n, currentCombination + "0", allCombinations);
            doThis(n, currentCombination + "1", allCombinations);
        }
    }
}
