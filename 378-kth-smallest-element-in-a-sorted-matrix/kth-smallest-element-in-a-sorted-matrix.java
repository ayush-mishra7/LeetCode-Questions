class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1 && matrix[0].length == 1) 
            return matrix[0][0];

        int[] arr = new int[matrix.length * matrix[0].length];
        int m = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[m++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);
        return arr[k - 1];
    }
}