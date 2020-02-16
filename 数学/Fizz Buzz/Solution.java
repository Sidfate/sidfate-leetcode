import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>();
        if(n<=0) return l;

        for(int i=1; i<n+1; i++) {
            String str = "";
            if(i%3 == i) {
                str += "Fizz";
            }
            if(i%5 == i) {
                str += "Buzz";
            }
            if(!str.isEmpty()) 
                l.add(str);
            else 
                l.add(Integer.toString(i));
        }

        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.fizzBuzz(15);
        
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    } 
}