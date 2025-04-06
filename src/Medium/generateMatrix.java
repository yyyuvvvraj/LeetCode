package Medium;
//Problem-59
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int minRow = 0, maxRow = n - 1;
        int minCol = 0, maxCol = n - 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            for (int c = minCol; c <= maxCol; c++) {
                arr[minRow][c] = count++;
            }
            minRow++;

            for (int r = minRow; r <= maxRow; r++) {
                arr[r][maxCol] = count++;
            }
            maxCol--;

            if (minRow <= maxRow) {
                for (int c = maxCol; c >= minCol; c--) {
                    arr[maxRow][c] = count++;
                }
                maxRow--;
            }

            if (minCol <= maxCol) {
                for (int r = maxRow; r >= minRow; r--) {
                    arr[r][minCol] = count++;
                }
                minCol++;
            }
        }

        return arr;
    }

}
