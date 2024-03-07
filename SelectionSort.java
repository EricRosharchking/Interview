public class SelectionSort {
    /*
     * arr[] = {64, 25, 12, 22, 11}
     * go through each element, and select the right position for them in the previously sorted part of the array
     * switch it with the previous sorted elements for the right position of the element
     * Complexity O(n^2)
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        Util.printArray(sort(arr));
    }

    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length;i ++) {
            
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            System.out.print(i);
            Util.printArray(arr);
        }
        return arr;
    }

}
