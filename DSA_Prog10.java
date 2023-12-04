class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<T> {
    Node<T> top;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class DSA_Prog10 {
    public static void main(String[] args) {
        Stack<Integer> primeAnagramStack = generatePrimeAnagramStack(0, 1000);

        System.out.println("Prime Anagrams in Reverse Order:");
        while (!primeAnagramStack.isEmpty()) {
            System.out.print(primeAnagramStack.pop() + " ");
        }
    }

    private static Stack<Integer> generatePrimeAnagramStack(int start, int end) {
        Stack<Integer> primeAnagramStack = new Stack<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                int reverseNumber = reverseNumber(i);
                if (isPrime(reverseNumber) && i != reverseNumber) {
                    primeAnagramStack.push(i);
                }
            }
        }

        return primeAnagramStack;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }
}


