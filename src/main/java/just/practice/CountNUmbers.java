package just.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class CountNUmbers {

    public static void main(String[] args) {
        String input = "The Academy";

        System.out.println(CountLetters(input));

    }

    static String CountLetters(String input) {
        Map<Character, Integer> characterCount = new LinkedHashMap<>();

        for(int i = 0; i < input.length(); i++) {
            char curr = Character.toLowerCase(input.charAt(i));

            if(characterCount.containsKey(curr)) {
                Integer count = characterCount.get(curr);
                count = count + 1;
                characterCount.put(curr, count);
            } else {
                characterCount.put(curr, 1);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: characterCount.entrySet()) {
            builder.append("'" + entry.getKey() + "'" +":"+entry.getValue());
            builder.append(",");
        }

        String toReturn = builder.toString();
        return toReturn.substring(0, toReturn.length()-1);

    }
}
