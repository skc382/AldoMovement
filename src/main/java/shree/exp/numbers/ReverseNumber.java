package shree.exp.numbers;

/**
 * Created by schampakaram on 1/19/18.
 */
public class ReverseNumber {

    public static void main(String[] args) {
        int number = 12345678;

//        reverse(number);
//        printOnlyOddDigits(number);
        formNumberWithOnlyOddDigits(number);
    }

    private static void reverse(int number) {

        int reverseNumber = 0;

        while(number != 0) {
            int remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number = number / 10;
        }

        System.out.println(reverseNumber);
    }

    private static void printOnlyOddDigits(int number) {
        while(number != 0) {
            int remainder = number % 10;

            if((remainder % 2) != 0) {
                System.out.print(remainder);
            }

            number = number / 10;
        }
        System.out.println();
    }

    private static void formNumberWithOnlyOddDigits(int number) {

        int numberOfDigits = getNumberOfDigits(number);

        int[] arr = new int[numberOfDigits];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        int i = 0;
        while(number != 0) {
            int remainder = number % 10;

            if((remainder % 4) == 0) {
                arr[i] = remainder;
                i++;
            }
            number = number / 10;
        }

        int j = arr.length - 1;
        int result = 0;
        while(j >= 0) {
            if(arr[j] > -1) {
                result = result * 10 + arr[j];
            }

            j--;
        }

        System.out.print("form Number With Only Odd Digits: "+ result);
        System.out.println();
    }

    private static int getNumberOfDigits(int number) {
        return (int) Math.ceil(Math.log10(number));
    }
}
