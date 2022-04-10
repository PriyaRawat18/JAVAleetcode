/*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.*/


class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet();
        
        for (int i =0 ; i < 9; i++) {
            
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add("row" + i + board[i][j]) || !seen.add("col" + j + board[i][j])) {
                        return false;
                    }
                    if (!seen.add("box" + (i / 3) * 3 + j / 3 + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
