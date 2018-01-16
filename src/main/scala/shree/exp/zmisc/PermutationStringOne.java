package shree.exp.zmisc;

import shree.exp.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/25/17.
 */
public class PermutationStringOne {

    public static void main(String[] args) {

        Set<String> result = new HashSet<>();
        String s = "BLa";
        permute(s, 0, s.length()-1, result);

        result.forEach(e -> System.out.println(e));
    }

    public static void permute(String input, int l, int r, Set<String> result) {

        if(l == r) {
            result.add(input);
            return;
        }

        if(!result.contains(input)) {
            for (int i = l; i <= r; i++) {
                input = Utils.swap(input, l, i);

                permute(input, l + 1, r, result);

                input = Utils.swap(input, l, i);

            }
        }
    }
}
