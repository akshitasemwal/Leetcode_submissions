//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(stack.size()==0 || stack.peek()!=ch)
            {
                stack.push(ch);
            }
            else
            {
                stack.pop();
            }
        }
        StringBuilder str=new StringBuilder();
        while(!stack.isEmpty())
        {
            str.append(stack.peek());
            stack.pop();
        }
        str.reverse();
        if(str.length()>0)
        return str.toString();
        else return "-1";
    }
}
        
