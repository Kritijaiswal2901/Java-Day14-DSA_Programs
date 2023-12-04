import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DSA_Prog5 {
    public static boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false; 
            }
        }
        return true; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        boolean result = isPalindrome(input);
        System.out.println("Is the string a palindrome? " + result);
        scanner.close();
    }
}

