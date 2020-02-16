
class Solution {
    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        int start = 1;
        int end = n;
        while(start != end) {
            if(end - start == 1) return isBadVersion(start) ? start:end;
            int count = start + (end - start) / 2;
            if(isBadVersion(count)) {
                end = count;
            }else {
                start = count;
            }
            
        }
        
        return start+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int version = solution.firstBadVersion(5);
        System.out.println("第一个错误的版本"+version);
    } 
}