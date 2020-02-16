
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0 || nums2.length == 0 || nums1.length == 0) return;
        int[] a = new int[m+n];
        int i=0, j=0, k=0;

        while(k<a.length) {
            if(j == m) {
                a[k] = nums2[i];
                i++;
                k++;
                continue;
            }
            if(i == n) {
                a[k] = nums1[j];
                j++;
                k++;
                continue;
            }
            if(nums1[j] > nums2[i]) {
                a[k] = nums2[i];
                i++;
                k++;
                continue;
            }
            if(nums1[j] <= nums2[i]) {
                a[k] = nums1[j];
                j++;
                k++;
                continue;
            }
        }

        for(i=0; i<a.length; i++) {
            nums1[i] = a[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{2,0};
        int[] b = new int[]{1};
        solution.merge(a, 1, b, 1);
        
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]);
        }
    } 
}