class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 0, flag = 0;
        int len = nums.length;

        while(i < len) {
            int temp = target - nums[i];
            for(j=i+1; j<len; j++) {
                if(nums[j] == temp) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) {
                break;
            }
            i++;
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] result = solution.twoSum(new int[]{0,4,3,0}, 0);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    } 
}