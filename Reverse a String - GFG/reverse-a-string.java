//{ Driver Code Starts
// Initial template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.revStr(S));
        }
    }
}
// } Driver Code Ends


class Solution {
    static String revStr(String S) {
        int high=S.length()-1;
        char[] str=S.toCharArray();
        int low=0;
        while(low<=high)
        {
            char temp=str[low];
            str[low]=str[high];
            str[high]= temp;
            low++;
            high--;
        }
        String A= new String(str);
        return A;
    }
}