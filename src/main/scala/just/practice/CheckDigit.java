package just.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class CheckDigit {

    public static void main(String[] args) {
        String input = "87815811023456421";

        GetCheckDigitAndCheckCode(input);
    }

    static String GetCheckDigitAndCheckCode(String input) {

        List<Integer> integerList = new LinkedList<>();

        for (int i = 0; i < input.length() ; i++) {
             integerList.add(Character.getNumericValue(input.charAt(i)));
        }

        Integer sum = 0;
        for (Integer num: integerList) {
            sum = sum + (num * 3);
        }

        System.out.println("CheckDigit: "+ ((sum%10)));

        Integer checkedDigit = 0;

        if((sum%10) <= 5) {
            checkedDigit = (sum%10);
        } else {
            checkedDigit = 10 - (sum%10);
        }


        integerList.add(checkedDigit);

        List<Integer> twoDigitList = new LinkedList<>();
        for (int i = 0; i < integerList.size() ; i = i+2) {
            String twoDigits = integerList.get(i) +""+ integerList.get(i+1);
            Integer twoDigitValue = Integer.valueOf(twoDigits);
            twoDigitList.add(twoDigitValue);
        }

        Integer finalSum = 0;
        for (int i = 0; i < twoDigitList.size(); i++) {
            finalSum = finalSum + (twoDigitList.get(i) * (3+i));
        }

        Integer add207 = finalSum + 207;
        Integer remainder = add207 % 103;

        System.out.println(remainder);

        return checkedDigit+","+remainder;
    }
}
