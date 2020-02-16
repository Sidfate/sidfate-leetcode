import java.util.*;

class Solution {
    
    // sum[i] = max(sum[i-2] + n[i],  n[i-1])
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int sum = nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        int tmp = nums[0], max = sum;

        for(int i=2; i<nums.length; i++) {
            tmp = nums[i-2] + nums[i];
            if(nums[i-1] >= tmp) {
                sum = nums[i-1];
            }else {
                sum = tmp;
            }
            nums[i] += nums[i-2];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = solution.rob(new int[]{2,1,1,2});
        System.out.println("最大利润:" + sum);
    } 
}