//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int matrix[][], int n, int m, int k)
	{
	    int top=0;
	    int left=0;
	    int right=m-1;
	    int bottom=n-1;
	    int count=0;
	    while(top<=bottom && left<=right)     //for printing column wise
        {
            for(int i=left;i<=right;i++)      //for printing row wise (opposite cuz its row first traversal)
            {
                int ele=matrix[top][i];
                count++;
	                if(count==k)
	                {
	                    return ele;
	                }
            }
            top++;
            for(int j=top;j<=bottom;j++)
            {
                int ele=matrix[j][right];
                count++;
	                if(count==k)
	                {
	                    return ele;
	                }
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    int ele=matrix[bottom][i];
                    count++;
	                if(count==k)
	                {
	                    return ele;
	                }
                }
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    int ele=matrix[i][left];
                    count++;
	                if(count==k)
	                {
	                    return ele;
	                }
                }
                left++;
            }
        }
	    
	    return 0;
	}
	
}