class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1) {
            return false;
        }
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(0 == (nums[i] ^ nums[j])) {
                    return true;
                }
            }
        }
        return false;
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