import java.util.*;

class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        if(numRows <=0) return new ArrayList<>(); 
        List<List<Integer>> l = new ArrayList<>(numRows);

        l.add(new ArrayList<Integer>(){{ add(1); }});
        for(int i=1; i<numRows-1; i++) {
            l.add(new ArrayList<>());
        }
        if(numRows == 1) {
            return l;
        }
        generate(numRows-1, l);
        return l;
    }

    public void generate(int level, List<List<Integer>> l) {
        List<Integer> l1 = new ArrayList<>();
        if(level == 1) {
            l1.add(1);
            l1.add(1);
            l.add(level, l1);
            return;
        }
        
        generate(level - 1, l);
        List<Integer> l2 = l.get(level-1);
        l1.add(0, 1);
        for(int i=1; i<level; i++) {
            l1.add(i, l2.get(i-1) + l2.get(i));
        }
        l1.add(1);
        l.set(level, l1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);

        for(List<Integer> l1: result) {
            for(Integer l2: l1) {
                System.out.println(l2);
            }
            System.out.println("----");
        }
    } 
}