//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static boolean subsetSum(int[] nums, int s)         
    {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][s+1];
        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<s+1; j++)
            {
                if( i == 0 )
                {
                    dp[i][j] = false;
                }
                if(j == 0 )
                {
                    dp[i][j] = true;
                }
            }
        }
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<s+1; j++)
            {
                if(nums[i - 1] <= j)
                {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][s];
    }
    
    static int equalPartition(int n, int nums[])
    {
        int sum = 0;
        for(int i = 0; i<nums.length; i++)
        {
            sum += nums[i];
        }
        if( sum%2 == 0)
        {
            int s = sum/2;
            boolean l = subsetSum(nums, s);      
            if( l == true )
            {
                return 1;
            }
        }
        return 0;
    }
}