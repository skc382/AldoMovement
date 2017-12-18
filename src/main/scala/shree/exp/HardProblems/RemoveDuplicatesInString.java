package shree.exp.HardProblems;


class RemoveDuplicatesInString {

    public static void main(String[] args) {
        String res = removeDuplicateLetters("aadbbnnggh");
        System.out.println(res);

    }

    public static String removeDuplicateLetters(String s) {
        boolean[] char_hash = new boolean[26];
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i++ ) {
            int index  = s.charAt(i) % 97;

            if(!char_hash[index]) {
                char_hash[index] = true;
            }
        }

        for(int i=0; i<char_hash.length; i++) {
            if(char_hash[i]) {
                int in = 97+i;
                char c = (char) in;
                Character curr = Character.valueOf(c);
                builder.append(String.valueOf(curr));
            }
        }

        return builder.toString();
    }
}
