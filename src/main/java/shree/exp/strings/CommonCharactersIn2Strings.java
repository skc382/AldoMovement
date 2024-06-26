package shree.exp.strings;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/17/17.
 */
public class CommonCharactersIn2Strings {

    public static void main(String[] args) {
        System.out.println(common("geeks", "forgeeks"));
    }

    private static String common(String s1, String s2) {

        int[] characters = new int[26];

        for (int i = 0; i < s1.length() && i < s2.length() ; i++) {
            char c1 = s1.charAt(i);

            int ind_1 = c1 % 97;
            characters[ind_1] = characters[ind_1] + 1;
        }

        for (int i = 0; i < s2.length() ; i++) {
            char c2 = s2.charAt(i);
            int ind_2 = c2 % 97;
            characters[ind_2] = characters[ind_2] + 1;
        }


        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < characters.length; i++) {
            if(characters[i] > 1) {
                int count = characters[i];
                int j = 0;
                int ci = i+97;
                char ch = (char) ci;

                while(j <= count) {
                    builder.append(ch);
                    j++;
                }
            }
        }

        return builder.toString();
    }
}
