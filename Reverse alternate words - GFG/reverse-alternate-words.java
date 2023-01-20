//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while(t-- > 0){
            String s = sc.nextLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.reverseAlternate(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    void reverse(char[] str, int low, int high)
    {
        while(low<=high)
        {
            char temp=str[low];
            str[low]=str[high];
            str[high]= temp;
            low++;
            high--;
        }
    }
    
    String reverseAlternate(String s) 
    {
        int n=s.length();
        int end=0;
        int start=0;
        int count=1;
        char[] str= s.toCharArray();
        for(int i=0;i<n;i++)
        {
            if(str[i]==' ')
            {
                count++;
            }
            if(count%2==0 && str[i]==' ')
            {
                start=i+1;
            }
            else if(count%2!=0 && str[i]==' ')
            {
                end=i-1;
                reverse(str, start, end);
            }
            //System.out.println( start+"gvyj"+ end);
        }
        if(count%2==0)
        {
            reverse(str, start, n-1);
        }
        String A= new String(str);
        return A;
    }
} 