// Jaden, Blake
import java.util.Arrays;

public class lab {
    long time = System.currentTimeMillis();
    private static int permutationCount;

    private static void generatePermutations(int[] n, int start, int end){
        if (start == end) { // if the two pointers are at the same location then we print the array
            System.out.println(Arrays.toString(n));
            permutationCount++;
        } else {
            for (int i = start; i <= end; i++) {
                swap(n, start, i); // each iteration swaps the element at the start index with the element at the current i
                generatePermutations(n, start + 1, end); // recursive call to start + 1 
                swap(n, start, i); // reset for next iteration
            }
        }
    }

    private static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    public static void generatePermutationsIndex(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        generatePermutations(array, 0, n - 1);
    }


    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        generatePermutationsIndex(10);
        System.out.println("Permutation Count: " + permutationCount);
        System.out.println("Time taken: " + (System.currentTimeMillis() - timeStart) + " ms");
    }
}
