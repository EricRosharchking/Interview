import java.util.Arrays;

public class JPGraph {

    public static void main(String[] args) {
        Integer[][] graph = testMatrix();
        System.out.println("----------------------------");
        populateMatrixGraph(graph);
    }

    public static Integer[][] testMatrix() {
        Integer[][] matrix = { 
            { 1, 1, 2 }, 
            { 1, 1, 3 }, 
            { 2, 1, 3 }, 
            { 2, 1, 4 }, 
            { 3, 1, 4 }, 
            { 4, 1, 5 },
            { 6, 1, 7 }, 
            { 6, 1, 8 }, 
            { 7, 1, 8 } };

        Integer[][] graph = Util.createMatrix(matrix, 8);
        for (Integer[] row : graph)
            System.out.println(Arrays.toString(row));
        return graph;
    }

    public static void populateMatrixGraph(Integer[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = j; k < graph.length; k++) {
                    if (graph[i][j] != null && graph[j][k] != null) {
                        if (graph[i][k] == null || graph[i][k] > graph[i][j] + graph[j][k]) {
                            graph[i][k] = graph[i][j] + graph[j][k];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != null) {
                    graph[j][i] = graph[i][j];
                }
            }
        }
        for (Integer[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }
}
