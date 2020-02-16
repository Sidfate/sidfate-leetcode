import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String result = "";
        
        for(int i=0; i<strs[0].length(); i++) {
            Set<Character> set = new HashSet<>();
            for(String str: strs) {
                set.add(str.charAt(i));
            }
            if(set.size() > 1) {
                return result;
            }
            result += set.iterator().next();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"flower","flow","flight"};
        String prefix = solution.longestCommonPrefix(strs);
        System.out.println("最小前缀:" + prefix);
    } 
}