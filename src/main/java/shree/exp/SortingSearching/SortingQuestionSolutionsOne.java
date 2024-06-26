package shree.exp.SortingSearching;

import shree.exp.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SortingQuestionSolutionsOne {

    public static void main(String[] args) {

//        (new Q10Point1()).execute();
        (new Q10Point2()).execute();
//        (new Q10Point4()).execute();

    }


    private static class Q10Point1 {
        public void execute() {
            int[] largerArray = {12, 43, 54, 65, 54, 102, 0, 0, 0, 0, 0};
            int[] smallerArray = {13, 44, 56, 78, 213};
            Utils.printArray(merge(largerArray, smallerArray));
        }

        private int[] merge(int[] largerArray, int[] smallerArray) {
            int[] helper = new int[largerArray.length];

            for (int i = 0; i < largerArray.length; i++) {
                helper[i] = largerArray[i];
            }

            /**
             * Must have three pointers for three arrays. Ie. Pointer should be unique to the array
             */
            int lgArrIndex = 0;
            int current = 0;
            int i = 0;
            while (i < smallerArray.length) {
                if (helper[lgArrIndex] < smallerArray[i] && helper[lgArrIndex] != 0) {
                    largerArray[current] = helper[lgArrIndex];
                    lgArrIndex++;
                } else {
                    largerArray[current] = smallerArray[i];
                    i++;
                }
                current++;
            }

            int remaining = lgArrIndex - largerArray.length - 1;
            for (int j = 0; j <= remaining; j++) {
                if (largerArray[lgArrIndex + j] != 0)
                    largerArray[current + j] = helper[lgArrIndex + j];
            }

            return largerArray;
        }
    }

    private static class Q10Point2 {
        // Group anagrams
        public void execute() {
            String[] input = {"scar", "cars", "halb", "blha", "lahb"};
            Map<String, List<String>> map = new HashMap<>();

            for (String s : input) {
                char[] chars = s.toCharArray();
                qsort(chars, 0, chars.length-1);

                List<String> val =  map.get(String.valueOf(chars));
                if(val == null) {
                    val = new ArrayList<>();
                    val.add(s);
                    map.put(String.valueOf(chars), val);
                } else  {
                    val.add(s);
                }
            }

            System.out.println();
        }

        private void qsort(char[] array, int left, int right) {
            int index = partition(array, left, right);

            if(left < index-1) {
                qsort(array, left, index-1);
            }

            if(index < right) {
                qsort(array, index, right);
            }
        }

        private int partition(char[] array, int left, int right) {
            char pivot =  array[(left + right) / 2];

            while(left <= right) {
                while(array[left] < pivot) left++;

                while(array[right] > pivot) right--;

                if(left <= right) {
                    Utils.swap(array, left, right);
                    left++;
                    right--;
                }
            }

            return left;
        }
    }

    private static class Q10Point3 {
        // Group anagrams
        public void execute() {

        }

       private int binarySearch(String[] array, int left, int right, String element) {
            int mid = (left + right) / 2 ;

            if(!array[mid].isEmpty() && (array[mid].compareToIgnoreCase(element) == 0)) return mid;

            if(left > right) return -1;

            if( array[mid].compareToIgnoreCase(element) > 0) {
                return  binarySearch(array, left, mid, element);
            } else {
                return binarySearch(array, mid+1, right, element);
            }
       }
    }

    private static class Q10Point4 {
        // No size sorted array search
        public void execute() {
            Listy listy = new Listy() {{
                add(12);
                add(32);
                add(45);
                add(54);
                add(55);
                add(345);
                add(543);
                add(677);
                add(876);
                add(909);
            }};

            System.out.println(search(listy, 9));
        }

        private int search(Listy listy, int element) {

            int index = 1;
            while (listy.get(index) != -1 && listy.get(index) < element) {
                index = 2 * index;
            }

            return binarySearch(listy, 0, index, element);
        }

        private int binarySearch(Listy listy, int left, int right, int element) {

            int mid = (left + right) / 2;

            if(listy.get(mid) == element) return mid;

            if(right <= left) return -1;

            if(element < listy.get(mid) || listy.get(mid) == -1) {
               return binarySearch(listy, left, mid, element);
            } else {
                return binarySearch(listy, mid+1, right, element);
            }
        }

        private class Listy extends ArrayList<Integer> {

            @Override
            public int size() {
                return -100;
            }

            @Override
            public Integer get(int index) {
                try {
                    return super.get(index);
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex.getMessage());
                    return -1;
                }
            }

        }
    }
}
