//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l = 1;
        int r = stalls[n-1] - stalls[0];
        int mid = l + ( r - l ) / 2;
        int ans = r;
        while(l <= r)
        {
            mid = l + ( r - l ) / 2;
            int count = 1;
            int j = 0;
            for(int i = 0; i<n; i++)
            {
                if( stalls[i] - stalls[j] >= mid )
                {
                    count++;
                    j = i;
                }
            }
            if(count < k)
            {
                r = mid - 1;
            }
            else 
            {
                ans = mid;
                l = mid + 1;
            }
            // System.out.println(l);
        }
        return ans;
    }
}


