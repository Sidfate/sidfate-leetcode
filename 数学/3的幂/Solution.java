import java.util.*;

class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        if(n<=3) return 1;
        if(n<5) return 2;
        int a = 2;

        for(int i=5; i<n; i++) {
            if(isPrime(i)) a++;
        }
        return a++;
    }

    public static boolean isPrime(int num) {
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countPrimes(15);
        System.out.println("质数个数:"+result);
    } 
}