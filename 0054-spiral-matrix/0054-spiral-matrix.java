class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums= new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0,left=0;
        int right=m-1, bottom=n-1;
        while(top<=bottom && left<=right)     //for printing column wise
        {
            for(int i=left;i<=right;i++)      //for printing row wise (opposite cuz its row first traversal)
            {
                int ele=matrix[top][i];
                nums.add(ele);
            }
            top++;
            for(int j=top;j<=bottom;j++)
            {
                int ele=matrix[j][right];
                nums.add(ele);
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    int ele=matrix[bottom][i];
                    nums.add(ele);
                }
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    int ele=matrix[i][left];
                    nums.add(ele);
                }
                left++;
            }
        }
        return nums;
    }
}