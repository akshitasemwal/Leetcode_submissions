class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int cursum=0;
        for(int i=0;i<nums.length;i++)
        {
            cursum+=nums[i];
            if(cursum<nums[i])
            {
                cursum=nums[i];
            }
            if(maxsum<cursum)
            {
                maxsum=cursum;
            }
        }
        return maxsum;
    }
}