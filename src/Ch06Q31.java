import java.util.Scanner;

public class Ch06Q31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        long number;
        int sum;
        int sumEven;
        int sumOdd;
        System.out.println("Enter a credit card number as a long integer: ");
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            number = Long.parseLong((input));
            int size = getSize(number);
            //System.out.println(size);
            if (size < 13 || size > 16) {
                break;
            }

            if (isValid(number)) {
                System.out.println(input + " is valid");
            } else {
                System.out.println(input + " is invalid");
            }
        }

    }


    public static boolean isValid(long number) {
        int  sumEven = sumOfDoubleEvenPlace(number);
        int sumOdd = sumOfOddPlace(number);
        int sum = sumEven + sumOdd;
        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        char[] chars = String.valueOf(number).toCharArray();
        int l = chars.length - 1;
        for (int i = 0; i < l + 1; i++) {
            if (i % 2 == 1) {
                //System.out.println(chars[l - i]);
                int doubleNum = 2 * Integer.parseInt(String.valueOf(chars[l - i]));
                sum = sum + getDigit(doubleNum);
            }
        }
        return sum;
    }


    public static int getDigit(int number) {
        int dig = 0;
        char[] chars = String.valueOf(number).toCharArray();
        if (chars.length == 1) {
            return number;
        } else {
            int dig1 = Integer.parseInt(String.valueOf(chars[0]));
            int dig2 = Integer.parseInt(String.valueOf(chars[1]));
            dig = dig1 + dig2;
            return dig;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        char[] chars = String.valueOf(number).toCharArray();
        int l = chars.length - 1;
        for (int i = 0; i < l + 1; i++) {
            if (i % 2 == 0) {
                //System.out.println(chars[l - i]);
                sum = sum + Integer.parseInt(String.valueOf(chars[l - i]));

            }
        }
        return sum;
    }

    /**
     * public static boolean prefixMatched(long number, int d){
     * <p>
     * }
     */
    public static int getSize(long d) {
        char[] chars = String.valueOf(d).toCharArray();
        int length = chars.length;
        return length;
    }

//    public static long getPredix(long number, int k) {
//        char[] chars = String.valueOf(number).toCharArray();
//        for (int i = 0; i < k; i++) {
//
//        }
//        return ;
//    }
}
