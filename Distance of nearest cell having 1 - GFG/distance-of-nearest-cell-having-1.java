//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public void bfs(int[][] mat, Queue<int[]> q, int[][] ans, boolean[][] visited)
    {
        
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        while( !q.isEmpty() )
        {
            int[] arr = q.remove();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];
            ans[r][c] = d;
            for(int i = 0; i<4; i++)
            {
                int nRow = r + x[i];
                int nCol = c + y[i];
                if( nRow >= 0 && nRow < mat.length && nCol >= 0 && nCol < mat[0].length && visited[nRow][nCol] == false )
                {
                    int[] nArr = {nRow, nCol, d + 1};
                    q.add(nArr);
                    visited[nRow][nCol] = true;
                }
            }
        }
    }
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] mat)
    {
        // Code here
        int[][] ans = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for(int i = 0; i<mat.length; i++)
        {
            for(int j = 0; j<mat[0].length; j++)
            {
                if(mat[i][j] == 1)
                {
                    int[] arr = {i, j, 0};
                    q.add(arr);
                    visited[i][j] = true;
                }
            }
        }

        bfs(mat, q, ans, visited);
        return ans;
    }
}