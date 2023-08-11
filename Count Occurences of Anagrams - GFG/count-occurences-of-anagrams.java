//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int n = txt.length();
        int k = pat.length();
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Character, Integer> mapPat = new HashMap<>();
        Map<Character, Integer> mapTxt = new HashMap<>();
        for(int l = 0; l<k; l++)
        {
            mapPat.put(pat.charAt(l), mapPat.getOrDefault(pat.charAt(l), 0) + 1);
        }
        // System.out.println(mapPat);
        while( j < n )
        {
            mapTxt.put(txt.charAt(j), mapTxt.getOrDefault(txt.charAt(j), 0) + 1);
            if(j - i + 1 == k)
            {
                // System.out.println(mapTxt);
                if(mapTxt.equals(mapPat))
                {
                    count++;
                }
                mapTxt.put(txt.charAt(i), mapTxt.getOrDefault(txt.charAt(i), 0) - 1);
                if(mapTxt.get(txt.charAt(i)) <= 0)
                {
                    mapTxt.remove(txt.charAt(i));
                }
                i++;
            }
            j++;
        }
        return count;
    }
}