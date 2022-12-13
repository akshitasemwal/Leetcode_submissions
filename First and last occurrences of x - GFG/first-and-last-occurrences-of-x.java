//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        //use binary search to find atleast one target element
        int h=n-1;
        int l=0;
        int m=l+(h-l)/2;
        int index=0;
        int flag=0;
        while(h>=l)
        {
            m=l+(h-l)/2;
            if(arr[m]==x)
            {
                index=m; //atleast one target element found
                flag=1;
                break;
            }
            if(arr[m]>x)
            {
                h=m-1;
            }
            if(arr[m]<x)
            {
                l=m+1;
            }
        }
        
        int i=index;  //to search last occurence
        int j=index;  //to search first occurence
        long first=-1;
        long last=-1;
        if(flag==1)
        {
            first=m;
        }
        else
        {
            ArrayList<Long> nums= new ArrayList<>();
            nums.add(first);
            nums.add(last);
            return nums;
        }
        for(i=index;i<n;i++)
        {
            if(arr[i]==x)
            {
                last=i;
            }
            else
            {
                break;
            }
        }
        for(i=index;i>=0;i--)
        {
            if(arr[i]==x)
            {
                first=i;
            }
            else
            {
                break;
            }
        }
        ArrayList<Long> nums= new ArrayList<>();
        nums.add(first);
        nums.add(last);
        return nums;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends