import java.io.*;
import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}


class OrderedList<T extends Comparable<T>> {
    private Node<T> head;

    public OrderedList() {
        this.head = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null || head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            Node<T> prev = null;

            while (current != null && current.data.compareTo(data) < 0) {
                prev = current;
                current = current.next;
            }

            prev.next = newNode;
            newNode.next = current;
        }
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            Node<T> current = head;
            while (current != null) {
                writer.print(current.data + " ");
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class DSA_Prog2 {
    public static void main(String[] args) {
        OrderedList<Integer> numberList = new OrderedList<>();
        Scanner scanner = new Scanner(System.in);

        try (Scanner fileScanner = new Scanner(new File("Prog2_input.txt"))) {
            while (fileScanner.hasNext()) {
                int number = fileScanner.nextInt();
                numberList.insert(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a number to insert or search: ");
        int userInput = scanner.nextInt();

        if (numberList.search(userInput)) {
            numberList.remove(userInput);
            System.out.println("Number found! Removing from the list.");
        } else {
            numberList.insert(userInput);
            System.out.println("Number not found! Inserting into the list.");
        }

        System.out.print("Updated List: ");
        numberList.display();

        numberList.saveToFile("Prog2_output.txt");

        scanner.close();
    }
}

