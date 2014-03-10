public class Solution {
    public void setZeroes_Omn(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] matrixCopy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixCopy[i][j] == 0) {
                    for (int x = 0; x < m; x++) {
                        matrix[x][j] = 0;
                    }
                    for (int y = 0; y < n; y++) {
                        matrix[i][y] = 0;
                    }
                }
            }
        }
    }

    public void setZeroes_Omplusn(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes_O1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int row = -1, col = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (row == -1) {
                        row = i;
                        col = j;
                    } else {
                        matrix[i][col] = 0;
                        matrix[row][j] = 0;
                    }
                }
            }
        }

        if (row == -1) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != row && matrix[i][col] == 0) || (j != col && matrix[row][j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }
        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }
}
