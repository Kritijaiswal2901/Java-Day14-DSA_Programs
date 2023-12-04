import java.util.ArrayList;
import java.util.List;

public class DSA_Prog8 {
    public static void main(String[] args) {
        List<List<Integer>> primeRanges = generatePrimeNumbers(0, 1000, 100);

        for (int i = 0; i < primeRanges.size(); i++) {
            System.out.println("Range " + i + ": " + primeRanges.get(i));
        }
    }

    private static List<List<Integer>> generatePrimeNumbers(int start, int end, int rangeSize) {
        List<List<Integer>> primeRanges = new ArrayList<>();

        for (int i = start; i <= end; i += rangeSize) {
            List<Integer> primesInRange = new ArrayList<>();
            for (int j = i; j < i + rangeSize; j++) {
                if (isPrime(j)) {
                    primesInRange.add(j);
                }
            }
            primeRanges.add(primesInRange);
        }

        return primeRanges;
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
}

