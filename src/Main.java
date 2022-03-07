import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * search value for binary to decimal
         * search value for decimal to binary
         */
        System.out.println(BinaryToDecimal(scanner.next()));
        System.out.println(DecimalToBinary(scanner.nextInt()));
        /**
         * search for max Palindrom in text
         */
        String text = scanner.nextLine().replaceAll("\\s+","");
        System.out.println(resultOfMaxPalindrom(text));

    }

    public static int BinaryToDecimal(String number) {
        int result = 0;
        int result2 = 1;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '1') {
                for (int j = 0; j < number.length() - (i + 1); j++) {
                    result2 *= 2;
                }
                result += result2;
                result2 = 1;
            }
        }
        return result;
    }


    public static int DecimalToBinary(int number) {
        String binary = "";
        if (number <= 0) {
            binary = "0";
        } else {
            while (number > 0) {
                binary = (number % 2) + binary;
                number /= 2;
            }
        }
        return Integer.parseInt(binary);
    }


    public static Boolean palindrom(String text) {
        String temp = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            temp += text.charAt(i);
        }
        if (temp.equals(text)) {
            return true;
        }
        return false;
    }
    public static String resultOfMaxPalindrom(String text) {
        String result = "";
        for (int i = 0; i <= text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String string = text.substring(i,j);
                if (palindrom(string)) {
                    if (result.length() < string.length()) {
                        result = string;
                    }
                }
            }
        }
        return result;
    }

}
