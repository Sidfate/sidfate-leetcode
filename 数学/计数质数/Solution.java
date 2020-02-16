import java.util.*;

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        while(n%3==0){
            n/=3;
        }
        return n==1;        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isPowerOfThree(15);
        System.out.println("是不是3的幂:"+result);
    } 
}