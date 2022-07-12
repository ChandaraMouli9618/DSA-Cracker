/*
Name       : Rate in a Maze
Difficulty : Medium
Link       : https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
Author     : Chandra Mouli
*/


class Solution {
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Maze is a square with side length 'n'.
        ArrayList<String> pathList = new ArrayList<>();
      
        // If first or last blocks are blocked return empty pathList.
        if(m[0][0] == 0 || m[n-1][n-1] == 0) return pathList;
        getPaths(0, 0, m, n-1, "", pathList);
      
        return pathList;
    }
    
    static void getPaths(int i, int j , int[][] m, int n, String path, ArrayList<String> pathList){
      
        // Base cases for false result.
        if(i < 0 || i > n || j < 0 || j > n || m[i][j] == 0) return;
        if(i == n && j == n){
            pathList.add(path);
            return;
        }
      
        //Mark as blocked for avoiding infinite loops.
        m[i][j] = 0;
      
        // Traverse all the directions.
        getPaths(i-1, j, m, n, path+"U", pathList);
        getPaths(i+1, j, m, n, path+"D", pathList);
        getPaths(i, j-1, m, n, path+"L", pathList);
        getPaths(i, j+1, m, n, path+"R", pathList);
      
        //Unblock while returning.
        m[i][j] = 1;
    }
}
