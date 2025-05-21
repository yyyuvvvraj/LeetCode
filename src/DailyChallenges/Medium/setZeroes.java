package DailyChallenges.Medium;

public class setZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int col0 = 1;  // To track if the first column should be zero

            // Step 1: Mark rows and columns that need to be set to zero
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) {
                    col0 = 0;
                }
                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // Step 2: Set the matrix elements to zero based on markers
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // Step 3: Handle the first row
            if (matrix[0][0] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[0][j] = 0;
                }
            }

            // Step 4: Handle the first column
            if (col0 == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
        }

        // For testing the solution
        public static void main(String[] args) {
            Solution sol = new Solution();

            int[][] matrix = {
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            };

            sol.setZeroes(matrix);

            // Print the updated matrix
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
