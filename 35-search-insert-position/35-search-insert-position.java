class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int high=n-1;
        int low=0;
        int mid=(high+low)/2;
        for(int i=0;i<n;i++)
        {
            if(nums[mid]==target)
            {
                return mid;
            }
            if( high==low || high<low)
            {
                break;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
                mid=(high+low)/2;
            }
            else
            {
                low=mid+1;
                mid=(high+low)/2;
            }
        }
        if(nums[low]<target)
        return low+1;
        else
            return low;
   }
}
    