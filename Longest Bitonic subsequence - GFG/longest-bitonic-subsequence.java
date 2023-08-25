//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];
        int[] bitonic = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        int max = 0;
        
        //LIS
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if( nums[i] > nums[j] )
                {
                    LIS[i] = Math.max( LIS[i], LIS[j] + 1 );
                }
            }
        }
        
        //LDS
        for(int i = n-1; i>=0; i--)
        {
            for(int j = n-1; j>=i; j--)
            {
                if( nums[i] > nums[j] )
                {
                    LDS[i] = Math.max( LDS[i], LDS[j] + 1 );
                }
            }
        }
        
        //Bitonic
        for(int i = 0; i<n; i++)
        {
            bitonic[i] = LIS[i] + LDS[i] - 1;
            max = Math.max(max, bitonic[i]);
        }
        
        return max;
    }
}