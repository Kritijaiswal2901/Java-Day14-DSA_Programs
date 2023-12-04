import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DSA_Prog9 {
    public static void main(String[] args) {
        List<List<Integer>> primeAnagramRanges = generatePrimeAnagrams(0, 1000, 100);

        for (int i = 0; i < primeAnagramRanges.size(); i++) {
            List<Integer> primeAnagrams = primeAnagramRanges.get(i);
            List<Integer> nonAnagrams = generateNonAnagrams(primeAnagrams);

            System.out.println("Range " + i + " - Prime Anagrams: " + primeAnagrams);
            System.out.println("Range " + i + " - Non-Anagrams: " + nonAnagrams);
        }
    }

    private static List<List<Integer>> generatePrimeAnagrams(int start, int end, int rangeSize) {
        List<List<Integer>> primeAnagramRanges = new ArrayList<>();

        for (int i = start; i <= end; i += rangeSize) {
            List<Integer> primesInRange = new ArrayList<>();
            for (int j = i; j < i + rangeSize; j++) {
                if (isPrime(j)) {
                    primesInRange.add(j);
                }
            }

            List<Integer> primeAnagrams = findAnagrams(primesInRange);
            primeAnagramRanges.add(primeAnagrams);
        }

        return primeAnagramRanges;
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

    private static List<Integer> findAnagrams(List<Integer> numbers) {
        List<Integer> anagrams = new ArrayList<>();
        Map<String, List<Integer>> anagramMap = new HashMap<>();

        for (int number : numbers) {
            char[] charArray = Integer.toString(number).toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new ArrayList<>());
            }
            anagramMap.get(sortedString).add(number);
        }

        for (List<Integer> anagramList : anagramMap.values()) {
            if (anagramList.size() > 1) {
                anagrams.addAll(anagramList);
            }
        }

        return anagrams;
    }

    private static List<Integer> generateNonAnagrams(List<Integer> primeAnagrams) {
        List<Integer> nonAnagrams = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i) && !primeAnagrams.contains(i)) {
                nonAnagrams.add(i);
            }
        }
        return nonAnagrams;
    }
}
