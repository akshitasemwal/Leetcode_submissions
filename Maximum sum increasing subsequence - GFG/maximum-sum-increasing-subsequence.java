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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int[] LIS = new int[n];
	    for(int i = 0; i<n; i++)
	    {
	        LIS[i] = arr[i];
	    }
	    int max = 0;
	    for(int i = 0; i<n; i++)
	    {
	        for(int j = 0;j<i; j++)
	        {
	            if( arr[i] > arr[j] )
	            {
	                LIS[i] = Math.max(LIS[i], arr[i] + LIS[j]);
	            }
	        }
	        max = Math.max(LIS[i], max);
	    }
	    return max;
	}  
}