class Solution {
    public int strStr(String haystack, String needle) {
        haystack.indexOf(needle);
        if(needle.length() == 0) {
            return 0;
        }
        int len = haystack.length() - needle.length();
        if(len < 0) {
            return -1;
        }

        int i = 0, j = 1;
        for(char ch: needle.toCharArray()) {
            if(-1 == haystack.indexOf(ch)) {
                return -1;
            }
        }
        while(i<haystack.length()) {
            int index = haystack.indexOf(needle.charAt(0), i);
            if(index == -1 || len < index) {
                return -1;
            }
            for(j=1; j<needle.length(); j++) {
                if(haystack.charAt(index+j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return index;
            }
            i = index+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.strStr("mississippi", "pi");
        
        System.out.println("字符串第一次出现的位置:" + result);
    } 
}