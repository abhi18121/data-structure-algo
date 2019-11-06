package data.struture.algorithm;

import java.util.Arrays;

class ZigZagFashion {

    public static void main(String[] args) {
        //Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
        //Output: arr[] = {3, 7, 4, 8, 2, 6, 1} 3 < 7 > 4 < 8 > 2 < 6 > 1
        // The converted array should be in form a < b > c < d > e < f.
        int[] inputArray = {4, 3, 7, 8, 6, 2, 1};
        new ZigZagFashion().convertToZigZagFashion(inputArray);
        System.out.print(Arrays.toString(inputArray));
    }

    private void convertToZigZagFashion(int[] inputArray) {
        boolean isLessThanOrder = true; //space complexity O(1)
        for (int i = 0; i < inputArray.length - 2; i++) { // time complexity O(n-2) nothing but O(n)
            if (isLessThanAndSwappable(inputArray, isLessThanOrder, i)) {
                swapElements(inputArray, i);
            } else if (isGreaterThanAndSwappable(inputArray, isLessThanOrder, i)) {
                swapElements(inputArray, i);
            }
            isLessThanOrder = !isLessThanOrder;
        }
    }

    private boolean isGreaterThanAndSwappable(int[] inputArray, boolean isLessThanOrder, int i) {
        return !isLessThanOrder && inputArray[i] < inputArray[i + 1];
    }

    private boolean isLessThanAndSwappable(int[] inputArray, boolean isLessThanOrder, int i) {
        return isLessThanOrder && inputArray[i] > inputArray[i + 1];
    }

    private void swapElements(int[] inputArray, int i) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[i + 1];
        inputArray[i + 1] = temp;
    }
}
