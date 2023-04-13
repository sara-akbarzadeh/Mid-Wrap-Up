import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Lecture6Exercises {

    /*
     *   implement a function that takes an array of int and return sum of
     *   elements at even positions
     *   lecture 6 page  16
     */
    public long calculateEvenSum(int[] arr) {
        long evenSum = 0;

        for (int i = 0; i < arr.length; i += 2) {
            evenSum += arr[i];
        }

        return evenSum;
    }

    /*
     *   implement a function that takes an array of int and return that
     *   array in reverse order
     *   lecture 6 page 16
     */
    public int[] reverseArray(int[] arr) {
        int[] reversedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversedArr[arr.length - i - 1] = arr[i];
        }

        return reversedArr;
    }

    /*
     *   implement a function that calculate product of two 2-dim matrices
     *   lecture 6 page 21
     */
    public double[][] matrixProduct(double[][] m1, double[][] m2) throws RuntimeException {
        int m1Rows = m1.length;
        int m1Cols = m1[0].length;
        int m2Cols = m2[0].length;

        if (m1Cols != m2.length) {
            throw new RuntimeException("Matrices cannot be multiplied - invalid dimensions");
        }

        double[][] result = new double[m1Rows][m2Cols];

        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                double sum = 0;
                for (int k = 0; k < m1Cols; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    /*
     *   implement a function that return array list of array list of string
     *   from a 2-dim string array
     *   lecture 6 page 30
     */
    public List<List<String>> arrayToList(String[][] names) {
        List<List<String>> result = new ArrayList<>();

        for (String[] row : names) {
            List<String> listRow = Arrays.asList(row);
            result.add(listRow);
        }

        return result;
    }

    /*
     *   implement a function that return a list of prime factor of integer n
     *   in ascending order
     *   lecture 6 page 30
     */
    public List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    /*
     *   implement a function that return a list of words in a given string
     *   lecture 6 page 30
     */

    public List<String> extractWord(String line) {
        List<String> words = new ArrayList<>();

        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            String word = token.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                words.add(word.toLowerCase());
            }
        }

        return words;
    }
}
