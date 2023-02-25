//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int c = 0, max = 0;
        Stack <Character> st= new Stack<>();
        for(int i = 0; i< s.length(); i++)
        {
            char ch = s.charAt(i);
            if( ch == '(' )
            {
                if( st.size() == 0 || st.peek() == '(' )
                {
                    c++;
                }
                st.push( ch );
                
            }
            else if( ch == ')')
            {
                st.pop();
                max = c > max ? c : max;
                c--;
            }
        }
        return max;
    }
}
        
