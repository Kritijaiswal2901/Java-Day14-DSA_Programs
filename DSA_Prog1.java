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

class UnOrderedList<T> {
    private Node<T> head;

    public UnOrderedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
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

public class DSA_Prog1 {
    public static void main(String[] args) {
        UnOrderedList<String> wordList = new UnOrderedList<>();
        Scanner scanner = new Scanner(System.in);

        try (Scanner fileScanner = new Scanner(new File("Prog1_input.txt"))) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                wordList.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a word to search: ");
        String searchWord = scanner.next();

        if (wordList.search(searchWord)) {
            wordList.remove(searchWord);
            System.out.println("Word found! Removing from the list.");
        } else {
            wordList.add(searchWord);
            System.out.println("Word not found! Adding to the list.");
        }

        System.out.print("Updated List: ");
        wordList.display();

        wordList.saveToFile("Prog1_output.txt");

        scanner.close();
    }
}
