class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }else {
            return say(countAndSay(n-1));
        }
    }

    public String say(String str) {
        int len = str.length();
        String res = "";
        int step = 1;
        if(len == 1) return "11";
        for(int i=0; i<len-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                step++;
            }else {
                res += "" + step + str.charAt(i);
                step = 1;
            }
            if(i == len - 2) {
                res += "" + step + str.charAt(len - 1);
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.countAndSay(7);
        System.out.println("表达式1:" + result);
        // String say = solution.say("1211");
        // System.out.println("表达式2:" + say);
    } 
}