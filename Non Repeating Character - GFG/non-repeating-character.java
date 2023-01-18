//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        int[] visited= new int[26];
        int res=-1;
        for(int i=S.length()-1;i>=0;i--)
        {
            visited[S.charAt(i)-'a']++;
        }
        for(int i=0;i<S.length();i++)
        {
            if(visited[S.charAt(i)-'a']==1)
            {
                return S.charAt(i);
            }
        }
        return '$';
    }
}

