//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int x) {
        int n = arr.length;
        Set<ArrayList<Integer>> res = new LinkedHashSet<>();
        Arrays.sort(arr);
        for(int i = 0; i< n-3; i++)
        {
            for(int j = i+1; j<n-2; j++)
            {
                int t = x- arr[i] - arr[j];
                int k = j+1;
                int l = n-1;
                while(k<l)
                {
                    int val = arr[k]+arr[l];
                    if(val == t)
                    {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        list.add(arr[l]);
                        res.add(list);
                        k++;
                    }
                    else if(val<t)
                    {
                        k++;
                    }
                    else
                    {
                        l--;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new  ArrayList<ArrayList<Integer>>(res);
        return ans;
    }
}