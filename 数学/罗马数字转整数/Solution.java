import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        char[] ss = s.toCharArray();
        int sum = 0, i = 0;
        for(i=0; i<ss.length-1; i++) {
            int now = map.get(ss[i]);
            int next = map.get(ss[i+1]);
            if(now < next) {
                sum += next - now;
                i++;
            }else {
                sum += now;
            }
        }
        if(i == ss.length-1) {
            sum += map.get(ss[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.romanToInt("LVIII");
        System.out.println("转换的整数:"+result);
    } 
}