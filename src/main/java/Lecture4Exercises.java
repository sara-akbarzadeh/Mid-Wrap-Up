public class Lecture4Exercises {

    /*
     *   implement a function that returns factorial of given n
     *   lecture 4 page 15
     */
    public long factorial(int n) {
        if (n == 0) {
            return 1L;
        } else {
            return n * factorial(n-1);
        }
    }

    /*
     *   implement a function that return nth number of fibonacci series
     *   the series -> 1, 1, 2, 3, 5, 8, ...
     *   lecture 4 page 19
     */
    public long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    /*
     *   implement a function that return reverse of a given word
     *   lecture 4 page 19
     */
    public String reverse(String word) {
        StringBuilder reversed = new StringBuilder();
        for (int i = word.length()-1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }

    /*
     *   implement a function that returns true if the given line is
     *   palindrome and false if it is not palindrome.
     *   palindrome is like 'wow', 'never odd or even', 'Wow'
     *   lecture 4 page 19
     */
    public boolean isPalindrome(String line) {
        String cleanLine = line.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = cleanLine.length();
        for (int i = 0; i < length/2; i++) {
            if (cleanLine.charAt(i) != cleanLine.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

    /*
     *   implement a function which computes the dot plot of 2 given
     *   string. dot plot of hello and ali is:
     *       h e l l o
     *   h   *
     *   e     *
     *   l       * *
     *   l       * *
     *   o           *
     *   lecture 4 page 26
     */
    public char[][] dotPlot(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[][] dotPlot = new char[m][n];

        for (int j = 0; j < n; j++) {
            dotPlot[0][j] = str2.charAt(j);
        }

        for (int i = 0; i < m; i++) {
            dotPlot[i][0] = str1.charAt(i);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dotPlot[i][j] = '*';
                } else {
                    dotPlot[i][j] = ' ';
                }
            }
        }

        return dotPlot;
    }
}

