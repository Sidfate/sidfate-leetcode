class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for(; i<nums.length; i++) {
            if(nums[i] == 0) {
                for(j=i+1; j<nums.length; j++) {
                    if(nums[j] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1};
        solution.moveZeroes(nums);
        
        for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
    } 
}