class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i=0; i<len; i++) {
            if(len/2 - 1 < i) {
                break;
            }
            
            char tmp = s[i];
            s[i] = s[len -1 - i];
            s[len -1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] str = {'h','e'};
        solution.reverseString(str);
        
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    } 
}