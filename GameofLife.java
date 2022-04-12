/*Completion Streak: 5 Days*/




/*According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]*/

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int prev [][] = new int [n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                prev[i][j]=board[i][j];
            }
        }
        int population_count [][] = new int [n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int count = 0;
                if(i-1>=0&&j-1>=0&&i-1<n&&j-1<m)count+=board[i-1][j-1];
                if(i-1>=0&&j>=0&&i-1<n&&j<m)count+=board[i-1][j];
                if(i-1>=0&&j+1>=0&&i-1<n&&j+1<m)count+=board[i-1][j+1];
                if(i>=0&&j-1>=0&&i<n&&j-1<m)count+=board[i][j-1];
                if(i>=0&&j+1>=0&&i<n&&j+1<m)count+=board[i][j+1];
                if(i+1>=0&&j-1>=0&&i+1<n&&j-1<m)count+=board[i+1][j-1];
                if(i+1>=0&&j>=0&&i+1<n&&j<m)count+=board[i+1][j];
                if(i+1>=0&&j+1>=0&&i+1<n&&j+1<m)count+=board[i+1][j+1];
                population_count[i][j]=count;
            }
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(prev[i][j]==1){
                    if(population_count[i][j]<2){
                        board[i][j]=0;
                    }
                    else if(population_count[i][j]>3){
                        board[i][j]=0;
                    }
                }
                else{
                   if(population_count[i][j]==3){
                        board[i][j]=1;
                    } 
                }
            }
        }
    }
}
