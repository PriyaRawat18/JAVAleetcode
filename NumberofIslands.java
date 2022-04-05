/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.*/


class Solution {
    
    private void make(char[][] grid, int x, int y) {
        if ( x+1<grid.length ) {
            if (grid[x+1][y] == '1') {
                grid[x+1][y]='0';
                make(grid,x+1,y);
            }
        }
        if ( x-1>=0 ) {
            if (grid[x-1][y] == '1') {
                grid[x-1][y]='0';
                make(grid,x-1,y);
            }
        }
        if ( y+1<grid[0].length ) {
            if (grid[x][y+1] == '1') {
                grid[x][y+1]='0';
                make(grid,x,y+1);
            }
        }
        if ( y-1>=0 ) {
            if (grid[x][y-1] == '1') {
                grid[x][y-1]='0';
                make(grid,x,y-1);
            }
        }
    }
    
    
    public int numIslands(char[][] grid) {
        int c=0;
        for (int i=0;i<grid.length;i++ ) {
            for (int j=0;j<grid[i].length;j++ ) {
                if (grid[i][j] == '1') {
                    c++;
                    grid[i][j]='0';
                    make(grid,i,j);
                }
            }
        }
        return c;
    }
}
