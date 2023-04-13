import java.util.Random;
public class Lecture5Exercises {

    /*
     *   implement a function to create a random password with
     *   given length using lower case letters
     *   lecture 5 page 14
     */
    public String weakPassword(int length) {

        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";

        Random random = new Random();

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(lowercaseLetters.length());
            password.append(lowercaseLetters.charAt(index));
        }

        return password.toString();
    }
    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */
    public String strongPassword(int length) throws Exception {
        if (length < 3) {
            throw new Exception("Password length must be at least 3");
        }

        Random random = new Random();

        StringBuilder password = new StringBuilder();

        char uppercaseLetter = getRandomChar('A', 'Z', random);
        password.append(uppercaseLetter);

        char lowercaseLetter = getRandomChar('a', 'z', random);
        password.append(lowercaseLetter);

        char digit = getRandomChar('0', '9', random);
        password.append(digit);

        String specialChars = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/";
        char specialChar = getRandomChar(specialChars, random);
        password.append(specialChar);

        for (int i = 4; i < length; i++) {
            int charType = random.nextInt(4);
            char c;

            switch (charType) {
                case 0:
                    c = getRandomChar('A', 'Z', random);
                    break;
                case 1:
                    c = getRandomChar('a', 'z', random);
                    break;
                case 2:
                    c = getRandomChar('0', '9', random);
                    break;
                default:
                    c = getRandomChar(specialChars, random);
            }

            password.append(c);
        }

        return password.toString();
    }

    private char getRandomChar(char start, char end, Random random) {
        int range = end - start + 1;
        int index = random.nextInt(range);
        return (char) (start + index);
    }

    private char getRandomChar(String charSet, Random random) {
        int index = random.nextInt(charSet.length());
        return charSet.charAt(index);
    }

    /*
     *   implement a function that checks if a integer is a fibobin number
     *   integer n is fibobin is there exist an i where:
     *       n = fib(i) + bin(fib(i))
     *   where fib(i) is the ith fibonacci number and bin(i) is the number
     *   of ones in binary format
     *   lecture 5 page 17
     */
    public boolean isFiboBin(int n) {
        int fibPrev = 0;
        int fibCurr = 1;

        while (fibCurr <= n) {
            int temp = fibCurr;
            fibCurr += fibPrev;
            fibPrev = temp;
        }

        for (int i = 0; i <= fibPrev; i++) {
            int fibI = fib(i);
            int binI = Integer.bitCount(fibI); // number of ones in binary format

            if (n == fibI + binI) {
                return true;
            }
        }

        return false;
    }

    private int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int fibPrev = 0;
        int fibCurr = 1;

        for (int i = 2; i <= n; i++) {
            int temp = fibCurr;
            fibCurr += fibPrev;
            fibPrev = temp;
        }

        return fibCurr;
    }
}
