//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[])
    {
        List<Integer> LIS = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            //if it finds the number in LIS, return its index
            //otherwise return the position where the number would be inserted
            int index = Collections.binarySearch(LIS, arr[i], (a, b) -> (a - b));
            if( index < 0 )//index not found for curr element
            {
                index = -(index + 1);
            }
            if( index == LIS.size() )
            {
                LIS.add(arr[i]);
            }
            else
            {
                LIS.set(index, arr[i]);
            }
        }
        return LIS.size();
    }
} 