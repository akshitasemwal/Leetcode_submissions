//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static void dfs(int i, int j, char[][] board, boolean[][] visited)
    {
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true || board[i][j] == 'X' )
        {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, board, visited);
        dfs(i - 1, j, board, visited);
        dfs(i, j + 1, board, visited);
        dfs(i, j - 1, board, visited);
    }
    

    static char[][] fill(int n, int m, char board[][]) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if( board[0][j] == 'O' && !visited[0][j])
                {
                    dfs(0, j, board, visited);
                }
                if( board[i][0] == 'O' && !visited[i][0])
                {
                    dfs(i, 0, board, visited);
                }
                if( board[board.length - 1][j] == 'O' && !visited[board.length - 1][j])
                {
                    dfs(board.length - 1, j, board, visited);
                }
                if( board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1])
                {
                    dfs(i, board[0].length - 1, board, visited);
                }
            }
        } 
        //System.out.println(Arrays.deepToString(visited));
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if(visited[i][j] == false)
                {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }
}