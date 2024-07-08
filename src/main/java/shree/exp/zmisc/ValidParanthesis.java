package shree.exp.zmisc;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String exp = "(((()))";
        if(validate(exp)) {
            System.out.println("Valid");
        } else {
            System.out.println("In-Valid");
        }
    }

    private static boolean validate(String exp) {

        char[] expArr = exp.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expArr.length ; i++) {
            char curr = expArr[i];
            if(curr == '(') {
                stack.push(curr);
            }

            if (curr == ')') {
                if(stack.isEmpty()) {
                    return false;
                }

                char openbracket = stack.pop();
                if(openbracket != '(') {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
