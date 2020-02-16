class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if(nums.length < 3) {
            return nums[0];
        }
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        if(nums[len-1] != nums[len-2]) {
            return nums[len-1];
        }
        for(int i = 1; i < len; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return 0;   
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = solution.singleNumber(new int[]{2,2,1});
        System.out.println("数字:" + number);

        number = solution.singleNumber(new int[]{4,1,2,1,2});
        System.out.println("数字:" + number);
    } 
}