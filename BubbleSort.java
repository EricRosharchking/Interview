public class BubbleSort {
    /*
     * bubblesort: constantly swapping adjacent elements if they are in the wrong
     * order.
     * if no elements were swapped, then the array is sorted
     */
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        Util.printArray(sort(arr));
    }

    public static int[] sort(int[] arr) {
        
        // for (int num = arr.length; num > 0; num --) {
        boolean swapped = true;
        do{
            swapped = false;
            for (int i = 0; i < arr.length-1; i ++) {
                if (arr[i] > arr[i+1]) {
                    int j = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = j;
                    swapped = true;
                }
            }
        } while (swapped);

        return arr;
    }
}
