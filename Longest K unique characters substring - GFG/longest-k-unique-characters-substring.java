//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int i = 0;
        int j = 0;
        int l = 0;
        int max = -1;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while( j < n )
        {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == k)
            {
                l = j - i + 1;
                max = Math.max(l, max);
            }
            if(map.size() > k)
            {
                while(map.size() > k)
                {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                    if(map.get(s.charAt(i))<=0)
                    {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}