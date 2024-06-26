package just.practice;


import java.util.Stack;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class StringValidation {

    public static void main(String[] args) {
        String input  = "<<>>{}";

        System.out.println(ValidateString(input));
    }


    static boolean ValidateString(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length() ; i++) {
            if(input.charAt(i) == '<' || input.charAt(i) == '{') {
                stack.push(input.charAt(i));
            }

            if(input.charAt(i) == '>') {
                if(stack.isEmpty()) {
                    return false;
                }

                if(stack.peek() != '<') {
                    return false;
                }

                stack.pop();
            }

            if(input.charAt(i) == '}') {
                if(stack.isEmpty()) {
                    return false;
                }

                if(stack.peek() != '{') {
                    return false;
                }

                stack.pop();
            }

        }


        return true;

    }

    static char getOppChar(char input) {
        switch (input) {
            case '{' : return '}';
            case '<' : return '>';
            default: throw new RuntimeException("Invalid Argument");
        }
    }
}
