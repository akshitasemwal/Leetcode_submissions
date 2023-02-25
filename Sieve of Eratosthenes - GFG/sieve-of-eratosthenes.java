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
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
            {
                result.add(i);
                for(int j = i*i; j <= n; j += i)
                {
                    if( j % i == 0)
                    {
                        prime[j] = false;
                    }
                }
            }
        }
        return result;
    }
}