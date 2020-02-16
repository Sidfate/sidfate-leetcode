import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length - 1] != nums.length) return nums.length;

        for(int i=0; i<nums.length+1; i++) {
            if(i != nums[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println("没有出现的数:"+result);
    } 
}