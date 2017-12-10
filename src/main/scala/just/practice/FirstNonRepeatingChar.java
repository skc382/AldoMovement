package just.practice;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class FirstNonRepeatingChar {


    public static void main(String[] args) {
        String s = "abacabad";

        firstNotRepeatingCharacter(s);
    }

    static void firstNotRepeatingCharacter(String s) {
        char[] chArr = s.toCharArray();

        for(int i = 0; i < chArr.length; i++) {
            char curr = chArr[i];
            Integer intValue = Integer.valueOf(curr);
            Integer modValue = intValue % (chArr.length-1);

            System.out.println(modValue +"-"+chArr[i]);
        }

    }
}
