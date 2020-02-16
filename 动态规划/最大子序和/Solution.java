import java.util.*;

class Solution {
    
    // [-2,1,-3,4,-1,2,1,-5,4],
    public int maxSubArray(int[] nums) {
        int sum = nums[0], index = 0, tmp = nums[0];

        for(int i=1; i<nums.length; i++) {
            tmp += nums[i];
            if(tmp <= nums[i]) {
                tmp = nums[i];
            }
            sum = Math.max(sum, tmp);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("最大连续和:" + sum);
    } 
}