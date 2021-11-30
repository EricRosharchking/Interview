public class Util {

    public static void printArray(int[] arr) {
        System.out.print("[");
        int i = 0;
        for (; i < arr.length -1; i ++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[i]);
        System.out.println("]");
    }

    public static Integer[][] createMatrix(Integer[][] matrix, int size) {
        Integer[][] res = new Integer[size][size];
        for (Integer[] row: matrix) {
            res[row[0]-1][row[2]-1] = row[1];
        }
        for (int i = 0; i < size; i++) {
            res[i][i] = 0;
            for (int j = 0; j< size; j++) {
                if (res[i][j] != null) {
                    res[j][i] = res[i][j];
                }
            }
        }
        return res;
    }
}
