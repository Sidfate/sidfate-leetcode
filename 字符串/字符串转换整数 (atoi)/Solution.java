import java.math.BigDecimal;

class Solution {
    public int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        String temp = "";
        int flag = 0;
        for(char ch: str.toCharArray()) {
            if(ch >= 48 && ch <= 57) {
                if(flag > 1) return 0;
                if(flag == 1 && temp.isEmpty()) return 0;
                temp += ch; 
            }else {
                if(!temp.isEmpty()) break;
                if(ch == 45 || ch == 43) temp += ch; 
                if(ch != 32) flag++;
            }
        }
        if(temp.isEmpty() || temp.equals("-") || temp.equals("+")) return 0;
        
        BigDecimal decimal = new BigDecimal(temp);
        BigDecimal intMax = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal intMin = new BigDecimal(Integer.MIN_VALUE);
        if(decimal.compareTo(intMax) == 1) {
            return intMax.intValue();
        }
        if(decimal.compareTo(intMin) == -1) {
            return intMin.intValue();
        }
        return decimal.intValue();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.myAtoi("+1");
        
        System.out.println("转换的数字:" + result);
    } 
}