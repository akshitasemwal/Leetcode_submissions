//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int findMinCost(String s, String t, int costX, int costY)
	{
		int n = s.length();
	    int m = t.length();
	    int[][] dp = new int[n+1][m+1];
	    for(int i = 1; i<n+1; i++)
	    {
	        for(int j = 1; j<m+1; j++)
	        {
	            if(s.charAt(i-1) == t.charAt(j-1))
	            {
	                dp[i][j] = 1 + dp[i-1][j-1];
	            }
	            else
	            {
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	    }
	    int c1 = (n - dp[n][m]) * costX;
	    int c2 = (m - dp[n][m]) * costY;
	    return c1 + c2;
	}
}
