import java.util.*;

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += (n & 1);
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.hammingWeight(-3);
        System.out.println("1的个数:"+result);
    } 
}