import java.util.*;

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            res |= (n >> i & 1) << (31 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 1;
        System.out.println(Integer.toBinaryString(i));
        int result = solution.reverseBits(i);

        System.out.println(Integer.toBinaryString(result));
        
    } 
}