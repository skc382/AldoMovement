package shree.exp.zmisc;


import shree.exp.Utils;

public class HeapsAlgoPermutation {

    public static void main(String[] args) {
        String s = "Blahshree";
        char[] ch = s.toCharArray();
        permutate(ch, ch.length);
        System.out.println(count);

    }

    static int count = 0;
    private static void permutate(char[] characters, int size) {

        if(size == 1) {
            Utils.printArray(characters);
            count++;
            return;
        }

        for (int i = 0; i < characters.length ; i++) {
            permutate(characters, size - 1);

            if((size%2) == 0) {
                Utils.swap(characters, i, size-1);
            } else {
                Utils.swap(characters, 0, size-1);
            }
        }
    }
}
