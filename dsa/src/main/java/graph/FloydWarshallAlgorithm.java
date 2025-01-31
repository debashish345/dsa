package graph;
/*
* Problem link : https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042
* */
public class FloydWarshallAlgorithm {

    public void shortestDistance(int[][] mat) {
        int vertices = mat.length;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (mat[i][j] == -1 && i != j) {
                    mat[i][j] = (int) 1e9;
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            for (int r = 0; r < mat.length; r++) {
                for (int c = 0; c < mat.length; c++) {
                    if (mat[r][i] != (int) 1e9 && mat[i][c] != (int) 1e9
                            && mat[r][i] + mat[i][c] < mat[r][c]) {
                        mat[r][c] = mat[r][i] + mat[i][c];
                    }
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (mat[i][j] == (int) 1e9) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}