//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] nums , int n, int t) {
        int sum = 0;
        for(int i = 0; i<n; i++)                     
        {
            sum += nums[i];
        }
        sum += t;                                   
        if( sum % 2 != 0 || sum < 0 )
        {
            return 0;
        }
        sum /= 2;
        return subsetSum(nums, n, sum);
    }
    
    public static int subsetSum(int[] arr, int n, int sum)            
    {
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<sum+1; j++)
            {
                if(i == 0)
                {
                    dp[i][j] = 0;   //single empty subset
                }
                if(j == 0)
                {
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 0; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
};