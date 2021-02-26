public class InsertionSort {
    /*
     * arr[] = {64, 25, 12, 22, 11}
     * go through each element, and insert it in right position for them in the previously sorted part of the array
     * compare and shift the rest of the sorted part of the array to the right
     * Complexity O(n^2)
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        Util.printArray(sort(arr));
    }

    public static int[] sort(int[] arr) {
        for (int j = 1; j < arr.length; j ++) {
            int key = arr[j];
            int i = j-1;
            while (i >= 0 && arr[i] > key) {
                arr[i+1] = arr [i];
                i = i - 1;
            }
            arr[i+1] = key;
        }
        return arr;
    }
}
