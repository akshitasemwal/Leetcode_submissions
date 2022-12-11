//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int N, int target)
    {
        int high=N-1;
        int low=0;
        int mid=low+(high-low)/2;
        if(target>arr[high])
        {
            return high+1;
        }
        while(high>=low)
        {
            mid=low+(high-low)/2;
            if(target==arr[mid])
            {
                return mid;
            }
            if(target>arr[mid])
            {
                low=mid+1;
            }
            if(target<arr[mid])
            {
                high=mid-1;
            }
        }
        return low;
    }
}