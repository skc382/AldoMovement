package just.practice;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class FirstDuplicate {

    public static void main(String[] args) {
        int[] b = {2, 3, 3, 1, 5, 2};

        // [2, 3, 3, 1, 5, 2]

        System.out.println(firstDuplicate(b));
    }

   static int firstDuplicate(int[] a) {

        int minIndex = a.length;

        for(int i = 0; i < a.length-1; i++) {

            int absValue = Math.abs(a[i]);

            if(a[absValue] < 0) {
                if(i < minIndex) {
                    minIndex = i;
                }
            } else {
                a[absValue] = -a[absValue];
            }
        }

        if(minIndex > a.length-1) {
            return -1;
        }

        return Math.abs(a[minIndex]);
    }

}
