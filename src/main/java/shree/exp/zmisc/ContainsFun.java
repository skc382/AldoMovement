package shree.exp.zmisc;

/**
 * Created by schampakaram on 1/16/18.
 */
public class ContainsFun {

    public static void main(String[] args) {
        String input = "This is a test";
        String pattern = "This";

        char[] inputArray = input.toCharArray();
        char[] patternArray =   pattern.toCharArray();

        System.out.println(containsRecursive(inputArray, patternArray, false, inputArray.length-1, patternArray.length-1));
    }

    private static boolean contains(char[] input, char[] pattern) {

        int j = 0;
        int i = 0;
        while (i < input.length) {

            while(j < pattern.length && i < input.length  && input[i] == pattern[j]) {
                if(j >= pattern.length - 1) {
                    return true;
                }
                j++;
                i++;
            }

            j = 0;
            i++;
        }

        return false;
    }

    private static boolean containsRecursive(char[] input, char[] pattern, boolean result , int inputIndex, int patternIndex) {

        if(inputIndex < 0) {
            return result;
        }

        if(patternIndex < 0 && !result) {
            patternIndex = pattern.length;
        } else if(patternIndex < 0 && result){
            return true;
        }

        if(input[inputIndex] == pattern[patternIndex]) {
            return containsRecursive(input, pattern, true, inputIndex-1, patternIndex-1);
        }

        return containsRecursive(input, pattern, false, inputIndex-1, pattern.length-1);
    }
}
