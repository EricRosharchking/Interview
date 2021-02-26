public class Util {
    public static void printArray(int[] arr) {
        System.out.print("[");
        int i = 0;
        for (; i < arr.length -1; i ++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[i]);
        System.out.println("]");
    }
}
