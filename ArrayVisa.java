public class ArrayVisa {
    /*
    I/p: arr=[0,2,3,100,5]
    O/p: arr=[0,-1,2,3,-1]
    index of the second array equals to the element of the array, if no element of the input exists, then -1
    */

    // brute force: time complexity O(n^2)
    // public static void main(String[] args) {
    //     int[] arr = {0,2,3,100,5};
    //     int[] out = {-1, -1, -1, -1, -1};

    //     for (int i = 0; i < arr.length; i ++) {
    //         if (contains(arr, i)) {
    //             out[i] = i;
    //         }
    //     }
    //     System.out.print("[");
    //     for (int i: out)
    //         System.out.print(i + " ");
        
    //     System.out.println("]");
    // }

    public static boolean contains(int[] arr, int num) {
        for (int i: arr) {
            if ( i == num) {
                return true;
            }
        }
        return false;
    }

    //swap: time complexity O(n)
    public static void main(String[] args) {
        
        int[] arr = {2,0,3,100,5};

        int i = 0;
        while (i < arr.length ) {
            if (i == arr[i]) {
                i ++;
            }
            System.out.println(i + ":");
            int tmp = arr[i];
            if (tmp < 0) {
                i ++;
            } else if (tmp < arr.length) {
                arr[i] = arr[tmp];
                arr[tmp] = tmp;
            } else {
                arr[i] = -1;
                i ++;
            }
            printArray(arr);
        }
        System.out.println("===========");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        int i = 0;
        for (; i < arr.length -1; i ++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[i]);
        System.out.println("]");
    }
}
