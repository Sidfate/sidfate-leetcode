import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        Map<Character, Integer> index = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            int value = 1;
            char key = s.charAt(i);
            if(!index.containsKey(key)) {
                index.put(key, i);
            }
            if(count.containsKey(key)) {
                value = count.get(key) + 1;
            }
            count.put(key, value);
        }

        for(char key: count.keySet()) {
            if(count.get(key) == 1) {
                return index.get(key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "loveleetcode";
        int index = solution.firstUniqChar(str);
    
        System.out.println("第一个唯一字符:" + index);
    } 
}