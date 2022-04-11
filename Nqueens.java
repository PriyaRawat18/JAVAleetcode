/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]*/


public List<List<String>> solveNQueens(int n) {
        boolean[][] matrix = fillVisitedMatrix(n);
        return solveNQueensV1(0,n,matrix);
    }

    private List<List<String>> solveNQueensV1(int currentRow, int size, boolean[][] matrix) {
        if(currentRow==size){
            ArrayList<List<String>> list = new ArrayList<>();
            list.add(getQueensPositionV1(matrix));
            return list;
        }
        ArrayList<List<String>> list = new ArrayList<>();
        for (int col=0;col<size;col++) {
            if (isSafe(currentRow, col,matrix)) {
                matrix[currentRow][col] = true;
                list.addAll(solveNQueensV1(currentRow + 1, size,matrix));
                matrix[currentRow][col] = false;
            }
        }
        return list;
    }

    private boolean[][] fillVisitedMatrix(int n) {
        boolean[][] matrix = new boolean[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=false;
            }
        }
        return matrix;
    }
    
    private List<String> getQueensPositionV1(boolean[][] matrix){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<matrix.length;i++){
            StringBuilder str = new StringBuilder();
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j])
                    str.append("Q");
                else
                    str.append(".");
            }
            list.add(str.toString());
        }
        return list;
    }
    
     private boolean isSafe(int row, int col,boolean[][] matrix) {
        //upwards direction
        for (int i = 0;i<row;i++){
            if (matrix[i][col])
                return false;
        }

        //left diagonal
        int left = Math.min(row,col);
        for (int i=1;left-i>=0;i++){
            if(matrix[row-i][col-i]){
                return false;
            }
        }

        //right diagonal
        int right = Math.min(row,matrix.length-col-1);
        for (int i=1;right-i>=0;i++){
            if(matrix[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
