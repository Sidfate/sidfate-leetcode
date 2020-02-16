class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int len = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != nums[len-1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = solution.removeDuplicates(nums);
        System.out.println("数组长度:"+result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    } 
}