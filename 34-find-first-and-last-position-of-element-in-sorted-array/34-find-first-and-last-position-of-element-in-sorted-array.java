class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] arr= new int[]{-1,-1};
        
        /*for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            {
                arr[0]=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]==target)
            {
                arr[1]=i;
                break;
            }
        }*/
        int h=n-1;
        int l=0;
        int m=(h+l)/2;
        int i=0,j=0;
        while(l<=h)
        {
            if(nums[m]==target)
            {
                i=m;j=m;
                arr[1]=j;
                arr[0]=i;
                break;
            }
            else if(nums[m]>target)
            {
                h=m-1;
                m=(h+l)/2;
            }
            else
            {
                l=m+1;
                m=(h+l)/2;
            }
        }
        if(arr[0]!=-1)
        {
            while(nums[i]==target)
            {
                i--;
                if(i==-1)
                {
                    break;
                }
            }
            arr[0]=i+1;
            while(nums[j]==target)
            {
                j++;
                if(j>n-1)
                {
                    break;
                }
            }
            arr[1]=j-1;
        }
        return arr;
    }
}