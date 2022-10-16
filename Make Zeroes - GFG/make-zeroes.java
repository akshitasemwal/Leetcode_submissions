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
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.MakeZeros(matrix);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] arr= new int[n][m];    //to use as an unchanged reference to loop up when calculating
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int sum=0;
                if(arr[i][j]==0)
                {
                    if(i-1>=0)
                    {
                        sum+=arr[i-1][j];
                        matrix[i-1][j]=0;
                    }
                    if(i+1<n)
                    {
                        sum+=arr[i+1][j];
                        matrix[i+1][j]=0;
                    }
                    if(j+1<m)
                    {
                        sum+=arr[i][j+1];
                        matrix[i][j+1]=0;
                    }
                    if(j-1>=0)
                    {
                        sum+=arr[i][j-1];
                        matrix[i][j-1]=0;
                    }
                    matrix[i][j]=sum;
                    sum=0;
                }
            }
        }
    }
}