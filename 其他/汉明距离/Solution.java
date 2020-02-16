import java.util.*;

class Solution {
    public int hammingDistance(int x, int y) {
        int a = x ^ y, count = 0;
        String b = Integer.toBinaryString(a);
        
        for(char ch: b.toCharArray()) {
            if(ch == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.hammingDistance(1, 4);
        System.out.println("汉明距离:"+result);
    } 
}