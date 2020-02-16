class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true; 
        int i = 0, j = s.length()-1;
        while(i <= j) {
            char head = s.charAt(i);
            char tail = s.charAt(j);

            int headState = getState(head);
            int tailState = getState(tail);

            if(headState == -1 || tailState == -1) {
                if(headState == -1) i++;
                if(tailState == -1) j--;
                continue;
            }
            if(headState == 2) head -= 32;
            if(tailState == 2) tail -= 32;
            if(head != tail) return false;
            i++;
            j--;
        }

        return true;
    }

    // 0 数字，1 大写，2 小写，-1 其他字符
    public int getState(char ch) {
        if(ch >= 48 && ch <= 57) {
            return 0;
        }
        if(ch >= 65 && ch <= 90) {
            return 1;
        }
        if(ch >= 97 && ch <= 122) {
            return 2;
        }

        return -1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(".,");
                                       
        System.out.println("是不是回文字符串:" + result);
    } 
}