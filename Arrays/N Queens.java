/*
Name       : N Queens
Difficulty : Medium
Link       : https://leetcode.com/problems/n-queens/
Author     : Chandra Mouli
*/

class Solution {
    List<List<String>> posList = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        //grid is used as reference array  to check for
        // already placed queens.
        int[][] grid = new int[n][n];
        for(int[] arr: grid) Arrays.fill(arr,0);
        
        ArrayList<Integer> path = new ArrayList<>();
      
        // Construct the board and stores the ans in the result.
        constructN_QueenPos(grid, n, 0,path);
        
        return posList;
    }
    
    void constructN_QueenPos(int[][] grid,int n, int row, ArrayList<Integer> path){
        
        if(row == n){
          // if row reached max limit, it indicates that all
          //  queens are placed in their respective positions.
          
            posList.add( getResultBoard(path, n) );
            return;
        }
        
        for(int i=0;i<n;i++){  
            if(isSafe(grid, n, row, i)){
                grid[row][i] = 1;
                path.add(i);
                constructN_QueenPos(grid, n, row+1, path);
                path.remove(path.size()-1);
                grid[row][i] = 0;
            }     
        }
    }
    
    // Checking if tere exist any previous 
    //  queens in curren queen path
  
    boolean isSafe(int[][] grid, int n, int row, int col){
        
        //Top left Diagonal
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(grid[i][j] == 1) return false;
        }
        
        //Top rihgt Diagonal
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++){
            if(grid[i][j] == 1) return false;
        }
        
        
        //Top Vertical
        for(int i = row-1, j = col; i >= 0; i--){
            if(grid[i][j] == 1) return false;
        }
        return true;
    }
    
    // Formatting the output
    ArrayList<String> getResultBoard(ArrayList<Integer> path, int n){
        String str = "";
        ArrayList<String> resultBoard = new ArrayList<>();
            
        for(int j: path){
            
            for(int i=0;i<j;i++){
                str += ".";
            }
            
            str += "Q";
            
            for(int i=j+1;i<n;i++){
                str += ".";
            }
            resultBoard.add(str);
            str = "";
        }
        
        return resultBoard;
    }
    
}
