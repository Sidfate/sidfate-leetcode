import java.util.*;

class Solution {
    
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int buy = prices[0], max = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            }else {
                max = Math.max(max, prices[i] - buy);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = solution.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("最大利润:" + sum);
    } 
}