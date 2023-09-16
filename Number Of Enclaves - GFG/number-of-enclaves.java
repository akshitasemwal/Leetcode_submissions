//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int i, int j, int[][] grid, boolean[][] visited)
    {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == 0 )
        {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, grid, visited);
        dfs(i - 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i , j - 1, grid, visited);
    }

    int numberOfEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int c = 0;
        int count = 0;
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if( grid[i][j] == 1 )
                {
                    count++;
                }
                if(visited[i][0] == false && grid[i][0] == 1)
                {
                    dfs(i, 0, grid, visited);
                }
                if(visited[0][j] == false && grid[0][j] == 1)
                {
                    dfs(0, j, grid, visited);
                }
                if(visited[grid.length - 1][j] == false && grid[grid.length - 1][j] == 1)
                {
                    dfs(grid.length - 1, j, grid, visited);
                }
                if(visited[i][grid[0].length - 1] == false && grid[i][grid[0].length - 1] == 1)
                {
                    dfs(i, grid[0].length - 1, grid, visited);
                }
            }
        }

        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if( visited[i][j] == true )
                {
                    c++;
                }
            }
        }   

        return count - c;
    }
}