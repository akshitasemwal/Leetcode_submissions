//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        int count = 0, maxCount = 0;
        for(int i = 1; i<n; i++)
        {
            arr[i] += arr[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i<n; i++)
        {
            if(map.containsKey(arr[i]))
            {
                count = i - map.get(arr[i]);
                maxCount = Math.max(count, maxCount);
            }
            else           //stores prefix sum and the first occurence pf the prefix sum
            {
                map.put(arr[i], i);
            }
        }
        return maxCount;
    }
}