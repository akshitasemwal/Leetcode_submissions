//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<arr1.length; i++)
        {
            int target = arr1[i];
            int l = 0; 
            int r = arr2.length - 1;
            int mid = l + ( r - l ) / 2;
            while( l <= r )
            {
                mid = l + ( r - l ) / 2;
                if( target >= arr2[mid] )
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            list.add(l);
        }
        return list;
    }
}