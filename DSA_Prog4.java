import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CashCounter<T> {
    private int cashBalance;
    private Queue<Customer<T>> customerQueue;

    public CashCounter() {
        this.cashBalance = 0;
        this.customerQueue = new LinkedList<>();
    }

    public void enqueue(Customer<T> customer) {
        customerQueue.add(customer);
    }

    public void dequeue() {
        if (!customerQueue.isEmpty()) {
            Customer<T> customer = customerQueue.poll();

            if (customer.getOperation().equals("deposit")) {
                cashBalance += (Integer) customer.getAmount();
                System.out.println("Deposited $" + customer.getAmount() + ". Current balance: $" + cashBalance);
            } else if (customer.getOperation().equals("withdraw")) {
                int amount = (Integer) customer.getAmount();
                if (cashBalance >= amount) {
                    cashBalance -= amount;
                    System.out.println("Withdrawn $" + amount + ". Current balance: $" + cashBalance);
                } else {
                    System.out.println("Insufficient funds. Unable to withdraw $" + amount);
                }
            }
        } else {
            System.out.println("No customers in the queue.");
        }
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }
}

class Customer<T> {
    private String operation;
    private T amount;

    public Customer(String operation, T amount) {
        this.operation = operation;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public T getAmount() {
        return amount;
    }
}
public class DSA_Prog4{
    public static void main(String[] args) {
        CashCounter<Integer> bankCashCounter = new CashCounter<>();
        Scanner scanner = new Scanner(System.in);

        bankCashCounter.enqueue(new Customer<>("deposit", 100));
        bankCashCounter.enqueue(new Customer<>("withdraw", 50));
        bankCashCounter.enqueue(new Customer<>("deposit", 200));

        while (!bankCashCounter.isEmpty()) {
            bankCashCounter.dequeue();
        }

        scanner.close();
    }
}

