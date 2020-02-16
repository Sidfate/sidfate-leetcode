class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        int i = 0;
        if(nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        for(; i<nums2.length; i++) {
            int value = 1;
            if(map.containsKey(nums2[i])) {
                value = map.get(nums2[i]) + 1;
            }
            map.put(nums2[i], value);
        }
        for(i=0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i]) && map.get(nums1[i]) > 0) {
                result.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
            }
        }
        
        return result.stream().mapToInt(j->j).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = solution.intersect(
            new int[]{1,2,1},
            new int[]{2,2}
        );
        for(int num: nums1) {
            System.out.println(num);
        }

        int[] nums2 = solution.intersect(
            new int[]{4,9,5},
            new int[]{9,4,9,8,4}
        );
        for(int num: nums2) {
            System.out.println(num);
        }
    } 
}