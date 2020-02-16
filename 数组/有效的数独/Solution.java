import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        int len = 0, i = 0;
        for(; i<9; i++) {
            set.clear();
            len = 0;
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    len++;
                    set.add(board[i][j]);
                }
            }
            if(set.size() != len) {
                return false;
            }

            set.clear();
            len = 0;
            for(int j=0; j<9; j++) {
                if(board[j][i] != '.') {
                    len++;
                    set.add(board[j][i]);
                }
            }
            if(set.size() != len) {
                return false;
            }
        }
        
        i = 0;
        while(i<9) {
            set.clear();
            len = 0;
            for(int j=(i%3)*3; j<(i%3+1)*3; j++) {
                for(int k=(i/3)*3; k<(i/3+1)*3; k++) {
                    if(board[j][k] != '.') {
                        len++;
                        set.add(board[j][k]);
                    }
                }
            }
            if(set.size() != len) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] nums = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        boolean valid = solution.isValidSudoku(nums);
        System.out.println("验证结果:" + valid);
    } 
}