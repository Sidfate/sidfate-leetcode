import java.util.*;

class Solution {
    
    char[] chars = new char[]{'(', '[', '{', '}', ']', ')'};
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;

        char ch = s.charAt(0);
        int i = getChar(ch);
        int first = s.indexOf(ch, 1);
        int j = s.indexOf(chars[5-i]);
        if(first != -1 && first < j) {
            j = s.lastIndexOf(chars[5-i]);
        }
        if(j == -1) {
            return false;
        }
        return isValid(s.substring(1, j)) && isValid(s.substring(j+1));
    }

    public int getChar(char ch) {
        switch(ch) {
            case '(':
                return 0;
            case ')':
                return 5;
            case '[':
                return 1;
            case ']':
                return 4;
            case '{':
                return 2;
            case '}':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isValid("{}{[{}]}");
        System.out.println("是不是有效的括号:"+result);
    } 
}