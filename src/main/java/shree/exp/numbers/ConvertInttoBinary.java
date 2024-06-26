package shree.exp.numbers;

/**
 * Created by schampakaram on 1/18/18.
 */
public class ConvertInttoBinary {

    public static void main(String[] args) {
        convert(10);
    }

    private static void convert(int number) {

        StringBuilder builder = new StringBuilder();

        while(number >= 2) {
            Integer remainder = number % 2;
            builder.append(remainder);
            number = number / 2;
        }

        builder.append(number);

        System.out.println(builder.toString());
    }
}
