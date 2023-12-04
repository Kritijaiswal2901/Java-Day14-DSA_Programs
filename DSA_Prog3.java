import java.util.Stack;

class ParenthesesChecker {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; 
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty(); 
    }
}

public class DSA_Prog3 {
    public static void main(String[] args) {
        String arithmeticExpression = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
        boolean isBalanced = ParenthesesChecker.isBalanced(arithmeticExpression);
        System.out.println("Arithmetic Expression is balanced: " + isBalanced);
    }
}

