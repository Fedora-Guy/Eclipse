import java.util.ArrayList;

public class Combinations {
    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        ArrayList<Integer> excludedNumbers = new ArrayList<>();
        excludedNumbers.add(8);
        excludedNumbers.add(31);
        excludedNumbers.add(32);
        excludedNumbers.add(33);
        excludedNumbers.add(34);
        excludedNumbers.add(35);
        excludedNumbers.add(36);
        
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        generateCombinationsUtil(n, k, 0, new ArrayList<>(), combinations, excludedNumbers);
        
        // Print the total number of combinations
        System.out.println("Total combinations: " + combinations.size());
    }
    
    public static void generateCombinationsUtil(int n, int k, int start, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> excludedNumbers) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (!excludedNumbers.contains(i)) {
                current.add(i);
                generateCombinationsUtil(n, k, i + 1, current, result, excludedNumbers);
                current.remove(current.size() - 1);
            }
        }
    }
}
