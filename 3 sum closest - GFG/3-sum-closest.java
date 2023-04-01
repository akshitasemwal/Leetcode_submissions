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
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


class Solution{
     static int closest3Sum(int A[], int N, int X)
    {
        //sort
        //2 pointer approach
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int ans =-1;
        //{-4, -1, 1, 2}
        for(int i=0; i<N; i++)
        {
            int target = X-A[i];
            int start = i+1;
            int end = N-1;
            while(start<end)
            {
                int sum = A[start] + A[end];
                int diff = Math.abs(target - sum);
                if(diff < min)
                {
                    min = diff;
                    ans = sum+A[i];
                }
                if( sum < target)
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }
            
        }
        return ans;
        //keep a[i] as constant 
        //in the second loop, treat the rest of the problem as 2 sum problem
    }
}    
    //make a hashmap to store freq
    //check for (x-(a+b)) in the freq hashmap
    //remove an instance of freq[a[i]] and freq[a[j]] from the hashmap as they are currently in use
    //readd them after iteration