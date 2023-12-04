class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Queue<T> {
    Node<T> front;
    Node<T> rear;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class DSA_Prog11 {
    public static void main(String[] args) {
        Queue<Integer> primeAnagramQueue = generatePrimeAnagramQueue(0, 1000);

        System.out.println("Prime Anagrams from the Queue:");
        while (!primeAnagramQueue.isEmpty()) {
            System.out.print(primeAnagramQueue.dequeue() + " ");
        }
    }

    private static Queue<Integer> generatePrimeAnagramQueue(int start, int end) {
        Queue<Integer> primeAnagramQueue = new Queue<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                int reverseNumber = reverseNumber(i);
                if (isPrime(reverseNumber) && i != reverseNumber) {
                    primeAnagramQueue.enqueue(i);
                }
            }
        }

        return primeAnagramQueue;
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

