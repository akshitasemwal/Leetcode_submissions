//{ Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int n, int m)
    {
        
        int top=0;
        int left=0;
        int right=m-1;
        int bottom=n-1;
        ArrayList<Integer> mat= new ArrayList<>();
        while(top<=bottom && left<=right)         //for checking that the conditions dont run out of bounds
        {
            for(int i=left;i<=right;i++)          //[1]
            {
                int ele=matrix[top][i];
                mat.add(ele);
            }
            top++;

            for(int j=top;j<=bottom;j++)           //[2]
            {
                int ele=matrix[j][right];
                mat.add(ele);
            }
            right--;

            if(top<=bottom)                        //[3]
            {
                for(int i=right;i>=left;i--)
                {
                    int ele=matrix[bottom][i];
                    mat.add(ele);
                }
                bottom--;
            }

            if(left<=right)                         //[4]
            {
                for(int i=bottom;i>=top;i--)
                {
                    int ele=matrix[i][left];
                    mat.add(ele);
                }
                left++;
            }
        }
        return mat;
    }
}
