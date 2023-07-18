//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends

class Solution 
{
    public static boolean lessThanEqual(int mid, int[]arr, int n, int m)
    {
        int sum = 0;
        int parts = 1;
        for(int i = 0; i<n; i++)
        {
            if( arr[i] > mid )
            {
                return false;
            }
            sum += arr[i];
            if( sum > mid )
            {
                parts++;
                sum = arr[i];
            }
            if( parts > m )
            {
                return false;
            }
        }
        return true;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int m)
    {
        if( n<m ) return -1;
        int l = 1;
        int r = 0;
        int ans = 0;
        for(int i = 0; i<n; i++)
        {
            r += arr[i];
        }
        int mid = l + ( r - l ) / 2;
        while( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( lessThanEqual(mid, arr, n, m) )
            {
                r = mid - 1;
                ans = mid;
            }
            else
            {
                l = mid + 1;
            }
        }
        return ans;
    }
};