class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        if(digits[len-1] != 9) {
            digits[len-1] += 1;
            return digits;
        }else {
            digits[len-1] = 0;
        }
        int i = len-2;
        while(i >= 0) {
            if(digits[i] != 9) {
                digits[i] += 1;
                break;
            }
            digits[i] = 0;
            i--;
        }
        if(digits[0] != 0) {
            return digits;
        }
        int[] nums = new int[len+1];
        for(i=1; i<len+1; i++) {
            nums[i] = 0;
        }
        nums[0] = 1;
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = solution.plusOne(new int[]{1,2,3});
        for(int num: nums1) {
            System.out.println(num);
        }
        
        int[] nums2 = solution.plusOne(new int[]{1,8,9});
        for(int num: nums2) {
            System.out.println(num);
        }
    } 
}