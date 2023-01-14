//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        StringBuilder s1=new StringBuilder();
        s1.append(S);
        s1.reverse();
        //System.out.println(s1);
        StringBuilder s2=new StringBuilder();
        s2.append(S);
        //System.out.println(s2);
        int res=s1.compareTo(s2);
        if(res==0)
        {
            return 1;
        }
        return 0;
    }
};