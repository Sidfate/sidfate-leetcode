class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        int i = 0;

        if(s.length() != t.length()) {
            return false;
        }
        for(; i<s.length(); i++) {
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        for(i=0; i<26; i++) {
            if(chars[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "anagram";
        String str2 = "nagaram";
        boolean result = solution.isAnagram(str1, str2);
        
        System.out.println("是不是异位字符串:" + result);
    }  
}