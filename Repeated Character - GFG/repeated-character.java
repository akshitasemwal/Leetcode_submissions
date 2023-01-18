//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    char firstRep(String S)
    {
        /*
        int[] freq= new int[26];
        for(int i=0;i<S.length();i++)
        {
            freq[S.charAt(i)-'a']++;
        }
        
        for(int i=0;i<S.length();i++)
        {
            if(freq[S.charAt(i)-'a'] > 1)
            {
                return S.charAt(i);
            }
        }
        return '#';
        */
        
        int[] fIndex= new int[26];
        Arrays.fill(fIndex,-1);
        int res= Integer.MAX_VALUE;
        for(int i=0;i<S.length();i++)
        {
            int fi=fIndex[S.charAt(i)-'a'];
            if(fi==-1)   //if :first occurence
            {
                fIndex[S.charAt(i)-'a']=i;     //stores first occurence
            }
            else
            {
                res=Math.min(res,fi);        //result= first/previous/smaller occurence of that character
            }
        }
        if(res==Integer.MAX_VALUE)
        {
            return '#';
        }
        return S.charAt(res);
    }
}