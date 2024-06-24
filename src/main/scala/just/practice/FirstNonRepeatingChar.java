package just.practice;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class FirstNonRepeatingChar {


    public static void main(String[] args) {
        String s = "zbacabad";

        int index = firstNotRepeatingCharacter(s);
        System.out.println("Index is: "+ index);
    }

    static int firstNotRepeatingCharacter(String s) {
        char[] chArr = s.toCharArray();

        int[] modArr = new int[chArr.length];
        Utils.initializArray(modArr, 0);
        for(int i = 0; i < chArr.length; i++) {
            char curr = chArr[i];
            Integer intValue = Integer.valueOf(curr);
            int modValue = intValue % (chArr.length-1);

            System.out.println(modValue +"-"+chArr[i]);
            modArr[modValue] = modArr[modValue] + 1;
        }

        for(int i = 0; i < modArr.length; i++) {
            if(modArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
