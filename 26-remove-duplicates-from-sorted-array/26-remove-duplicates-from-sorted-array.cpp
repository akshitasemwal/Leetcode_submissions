class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        /*int j=0;
        for(int i=1;i<nums.size();i++)
        {
            if(nums[i]!=nums[j])
            {
                ++j;
                nums[j]=nums[i];
            }
        }*/
        int j=0;
    for(int i=0;i<nums.size()-1;i++)
    {
        if(nums[i]!=nums[i+1])
        {
            j++;
            nums[j]=nums[i+1];
        }
    }
        return j+1;
    }
};