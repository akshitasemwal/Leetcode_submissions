//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) 
    { 
        int n = s.length();
        int[] freq = new int[26];
        for( int i = 0; i < n; i++)
        {
            if( freq[s.charAt(i)-'a'] !=0 )
            {
                String str = "";
                str += s.charAt(i);
                return str;
            }
            else
            {
                freq[s.charAt(i)-'a']++;
            }
        }
        
        return "-1";
    }
} 