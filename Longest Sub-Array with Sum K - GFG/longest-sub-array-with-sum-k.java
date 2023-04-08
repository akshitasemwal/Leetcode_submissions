//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i<n; i++)
        {
            sum += arr[i];
            
            if(sum == k)
            {
                count = i+1;
                maxCount = count > maxCount ? count : maxCount;
            }
            
            else if( map.containsKey( sum-k ))
            {
                count = i - map.get(sum-k);
                maxCount = count > maxCount ? count : maxCount;
            }
            if(!map.containsKey(sum))       //if i gets updated, and a 0 is present, it'll get ignored.
            {                               //we do this to check the leftmost presence of that particular element
                map.put(sum, i);
            }
        }
        return maxCount;
    }
    
    
}


