class Solution {
    public void rotate(int[][] matrix) {
        int i = 0, j = 0;
        int n = matrix[0].length;
        for(; i<n; i++) {
            for(j = 0; j<n/2; j++) {
                int next = n - 1 - j;
                int tmp = matrix[j][i];

                // 第一步交换
                matrix[j][i] = matrix[next][i];
                matrix[next][i] = tmp;
            }
        }
        for(i=0; i<n; i++) {
            for(j = i; j<n; j++) {
                int tmp = matrix[i][j];
                // 第二步交换
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
            {5, 1, 9,11},
            {2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,16}
        };
        solution.rotate(matrix);
        
        for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("\n");
		}
    } 
}