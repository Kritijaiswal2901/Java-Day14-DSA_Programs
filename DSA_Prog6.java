import java.io.*;
import java.util.*;

class Slot {
    private List<Integer> chain;

    public Slot() {
        this.chain = new LinkedList<>();
    }

    public void addToChain(int number) {
        chain.add(number);
    }

    public void removeFromChain(int number) {
        chain.remove((Integer) number);
    }

    public List<Integer> getChain() {
        return chain;
    }

    public boolean containsNumber(int number) {
        return chain.contains(number);
    }
}

public class DSA_Prog6 {
    private Map<Integer, Slot> slots;

    public DSA_Prog6() {
        this.slots = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            slots.put(i, new Slot());
        }
    }

    public int hashFunction(int number) {
        return number % 11;
    }

    public void addToSlot(int number) {
        int slotIndex = hashFunction(number);
        Slot slot = slots.get(slotIndex);

        if (!slot.containsNumber(number)) {
            slot.addToChain(number);
            System.out.println("Added " + number + " to Slot " + slotIndex);
        } else {
            System.out.println(number + " already exists in Slot " + slotIndex);
        }
    }

    public void removeFromSlot(int number) {
        int slotIndex = hashFunction(number);
        slots.get(slotIndex).removeFromChain(number);
    }

    public void displayHashTable() {
        for (Map.Entry<Integer, Slot> entry : slots.entrySet()) {
            int slotIndex = entry.getKey();
            List<Integer> chain = entry.getValue().getChain();
            System.out.println("Slot " + slotIndex + ": " + chain);
        }
    }

    public static void main(String[] args) {
        DSA_Prog6 hashingFunction = new DSA_Prog6();
        Scanner scanner = new Scanner(System.in);

        try (Scanner fileScanner = new Scanner(new File("Prog6_input.txt"))) {
            while (fileScanner.hasNext()) {
                int number = fileScanner.nextInt();
                hashingFunction.addToSlot(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();

        int searchSlotIndex = hashingFunction.hashFunction(searchNumber);
        List<Integer> searchChain = hashingFunction.slots.get(searchSlotIndex).getChain();

        if (searchChain.contains(searchNumber)) {
            System.out.println("Number " + searchNumber + " found in Slot " + searchSlotIndex);
            hashingFunction.removeFromSlot(searchNumber);
        } else {
            System.out.println("Number " + searchNumber + " not found in Slot " + searchSlotIndex);
            hashingFunction.addToSlot(searchNumber);
        }

        System.out.println("Updated Hash Table:");
        hashingFunction.displayHashTable();

        scanner.close();
    }
}


