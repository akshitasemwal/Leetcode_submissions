//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String s = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.remove3ConsecutiveDuplicates(s));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String remove3ConsecutiveDuplicates(String s)
    {
        
        Stack<Character> charSt=new Stack<>();
        Stack<Integer> countSt=new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(charSt.size()>0 && charSt.peek()==ch) 
            {
                countSt.push(countSt.peek()+1);
            }
            
            else 
            {
                countSt.push(1);
            }
        
            charSt.push(ch);
            if(countSt.peek()==3){
                for(int i=0;i<3;i++){
                    charSt.pop();
                    countSt.pop();
                }
            }
        }
        
        //System.out.println(charSt);
        
        StringBuilder str=new StringBuilder();
        while(charSt.size()>0) 
        {
            str.append(charSt.pop());
        }
        if(str.length()==0)
        {
            return "-1";
        }
        return str.reverse().toString();
    }
}