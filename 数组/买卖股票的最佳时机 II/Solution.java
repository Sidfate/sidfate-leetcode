class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int i = 0;
        int result = 0;
        while(i < prices.length - 1) {
            if(prices[i] > prices[i+1]) {
                i++;
                continue;
            }

            int j = i+1;
            for(; j < prices.length - 1; j++) {
                if(prices[j] > prices[j+1]) {
                    break;
                }
            }
            result += prices[j] - prices[i];
            i = j;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int price = solution.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("最大价格:" + price);

        price = solution.maxProfit(new int[]{1,2,3,4,5});
        System.out.println("最大价格:" + price);

        price = solution.maxProfit(new int[]{7,6,4,3,1});
        System.out.println("最大价格:" + price);
    } 
}