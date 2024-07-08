package shree.exp.Arrays.Rotation;


import shree.exp.Utils;

public class SImpleRotation {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        SImpleRotation s = new SImpleRotation();
        s.methodOne(arr, 2);

//        s.methodTwo(arr, 1);

        Utils.printArray(arr);
    }

    // Use temp array O(n) time complexity
     public void methodOne(int[] arr, int numberOfRotations) {

        if(arr.length < numberOfRotations) {
            System.out.println("Cannot be greater");
            return;
        }

        int[] temp = new int[numberOfRotations];

        for (int i = 0; i < numberOfRotations; i++) {
            temp[i] = arr[i];
        }

        int nextIndex = numberOfRotations;

        int j = 0;
        int tempIndex = 0;
        while(j < arr.length) {

            if(j < nextIndex && nextIndex < arr.length) {
                arr[j] = arr[nextIndex];
                nextIndex++;
            } else if(tempIndex < temp.length){
                arr[j] = temp[tempIndex];
                tempIndex++;
            }
            j++;
        }
    }

    // rotate individually Time Complexity O(n X NumberOfRotations)
    public void methodTwo(int[] arr, int numberOfRotations) {

        if(arr.length < numberOfRotations && arr.length > 1) {
            System.out.println("Boom");
            return;
        }

        for (int i = 1; i <= numberOfRotations ; i++) {
            int tempElem = arr[0];

            for (int k = 1; k < arr.length ; k++) {
                arr[k - 1] = arr[k];
            }

            arr[arr.length-1] = tempElem;
        }
    }
}
