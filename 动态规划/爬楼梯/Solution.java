import java.util.*;

class Solution {
    
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int sum[] = new int[n];
        sum[0] = 1;
        sum[1] = 2;
        for (int i = 2; i < n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = solution.climbStairs(7);
        System.out.println("有几种方法:" + sum);
    } 
}