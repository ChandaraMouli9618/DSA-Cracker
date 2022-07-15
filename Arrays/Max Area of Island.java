/*
Name       : Max Area of Island
Difficulty : Medium
Link       : https://leetcode.com/problems/max-area-of-island/
Author     : Chandra Mouli
*/


class Solution {
    
    int x[] = {-1, 0, 1, 0};
    int y[] = {0, -1, 0, 1};
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        
      //Traverse and check for an island.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0) continue;
              
              // After finding an island count group of islands attached to it and compare
              //   it with previous maximum area to find maximum area.
                max = Math.max( getCurrIslandArea(grid, n-1, m-1, i, j), max);
            }
        }
        
        return max;
    }
    
    int getCurrIslandArea(int[][] grid, int row, int col, int i, int j){
        if(i < 0 || i > row || j < 0 || j > col || grid[i][j] == 0) return 0;
        
        //making element 0 to avoid duplicate count.
        grid[i][j] = 0;
        int count = 0;
      
      //Checking in four directions.
        for(int k=0;k<4;k++){
          count += getCurrIslandArea(grid, row, col, i+x[k], j+y[k]);
        }
      
      //returning neighbour area count and +1 for current island.
        return count+1;
    }
}
