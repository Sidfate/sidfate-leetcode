class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1) {
            return;
        }
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int next = Math.abs((nums.length + i-(k%nums.length)) % nums.length);
            list.add(nums[next]);
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums3 = {1, 2, 3};
        solution.rotate(nums3, 4);
        for(int num: nums3) {
            System.out.println(num);
        }
        int[] nums1 = {1,2,3,4,5,6,7};
        solution.rotate(nums1, 3);
        for(int num: nums1) {
            System.out.println(num);
        }

        int[] nums2 = {-1,-100,3,99};
        solution.rotate(nums2, 2);
        for(int num: nums2) {
            System.out.println(num);
        }
    } 
}